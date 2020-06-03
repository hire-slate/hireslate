package com.hireslate.controller;

import java.io.File;
import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
//import com.amazonaws.services.cloudfront.model.Paths;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.hireslate.model.CandidateMasterEntity;
import com.hireslate.model.UserEntity;
import com.hireslate.service.CandidateMasterService;
import com.hireslate.service.JobMasterService;
import com.hireslate.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired 
	UserService  userService;
	@Autowired
	JobMasterService jobMasterService;
	@Autowired
	CandidateMasterService cms;
	
	@Value("${aws.accessToken}")
	private String accessToken;
	@Value("${aws.secretKey}")
	private String secretKey;
	@Value("${aws.bucket}")
	private String bucket;
	@Value("${aws.url}")
	private String awsUrl;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "/index" , method = RequestMethod.GET)
	public String showIndex(HttpServletRequest request) {
		request.setAttribute("totalJobs",jobMasterService.totalJobs());
		return "user/index.jsp";
	}
	
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String doUserLogin(Model model,@RequestParam("username") String username, @RequestParam("password") String password,HttpServletRequest request) {
		String msg;
		UserEntity user = userService.doLogin(username, password);
		if(user != null) {
			request.getSession().setAttribute("userId", user.getUserId());
			request.getSession().setAttribute("userfname", user.getUserFname());
			request.getSession().setAttribute("userlname", user.getUserLname());
			msg = "redirect:/user/tryfrontend";  
		}
		else {
			model.addAttribute("message", "Invalid");
			msg = "redirect:/user/index";
		}
		return msg;
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String doUserLogout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		return "redirect:/user/index";
	}
	
	@RequestMapping(value="/uploadphoto", method=RequestMethod.POST)
	public String uploadPhoto(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes, HttpServletRequest request,HttpServletResponse response) {
		
		 if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return "";
	        }
		
		String userId = (String) request.getSession().getAttribute("userId");
		AWSCredentials credentials = new BasicAWSCredentials(accessToken,secretKey);
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.AP_SOUTH_1)
				  .build();
		try {
			byte[] bytes = file.getBytes();
			String path = file.getOriginalFilename();
	        //Path path = java.nio.file.Paths.get(file.getOriginalFilename());
			s3client.putObject(
					new PutObjectRequest(bucket, userId+"/photo.png", new File(file.getOriginalFilename()))
							.withCannedAcl(CannedAccessControlList.PublicRead));
		}catch(Exception e){}
		
		return "redirect:/user/index";
	}
	
	@RequestMapping(value="/editprofile", method=RequestMethod.GET)
	public String editProfile(HttpServletRequest request,HttpServletResponse response) {
		UserEntity userEntity = userService.viewUser((int)request.getSession().getAttribute("userId"));
		CandidateMasterEntity cme = cms.getCandidate((int)request.getSession().getAttribute("userId"));
		
		request.getSession().setAttribute("firstName", userEntity.getUserFname());
		request.getSession().setAttribute("middleName", userEntity.getUserMname());
		request.getSession().setAttribute("lastName", userEntity.getUserLname());
		request.getSession().setAttribute("mobileNumber", userEntity.getUserMobileNumber());
		request.getSession().setAttribute("email", userEntity.getUserEmail());
		request.getSession().setAttribute("addressLine", userEntity.getUserAddressLine());
		request.getSession().setAttribute("addressLandmark", userEntity.getUserAddressLandmark());
		request.getSession().setAttribute("city", userEntity.getUserCity());
		request.getSession().setAttribute("state", userEntity.getUserState());
		request.getSession().setAttribute("pincode", userEntity.getUserPincode());
		request.getSession().setAttribute("username", userEntity.getUserUserName());
		
		request.getSession().setAttribute("institute", cme.getCandidateInstitute());
		request.getSession().setAttribute("university", cme.getCandidateUniversity());
		request.getSession().setAttribute("startYear", cme.getCandidateCourseStartYear());
		request.getSession().setAttribute("endYear", cme.getCandidateCourseEndYear());
		
		return "user/editprofile.jsp";
	}
	
	@RequestMapping(value="/updatebasic", method=RequestMethod.POST)
	public String updateBasic(HttpServletRequest request,HttpServletResponse response, @RequestParam String firstName,@RequestParam String middleName
			,@RequestParam String lastName,@RequestParam String userName,@RequestParam String password,@RequestParam String cPassword) {
		
		String sql = "update user set User_Fname='"+firstName+"',User_Mname='"+middleName+"',User_Lname='"+lastName+"',User_UserName='"+userName+"',User_Password='"+cPassword+"' where User_Id="+request.getSession().getAttribute("userId");
		jdbcTemplate.execute(sql);
		
		return "redirect:/user/editprofile";
	}
	
	@RequestMapping(value="/uploadresume", method=RequestMethod.POST)
	public String uploadResume(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes, HttpServletRequest request,HttpServletResponse response) {
		
		 if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return "";
	        }
		
		String userId = (String) request.getSession().getAttribute("userId");
		AWSCredentials credentials = new BasicAWSCredentials(accessToken,secretKey);
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.AP_SOUTH_1)
				  .build();
		try {
			byte[] bytes = file.getBytes();
			String path = file.getOriginalFilename();
	        //Path path = java.nio.file.Paths.get(file.getOriginalFilename());
			s3client.putObject(
					new PutObjectRequest(bucket, userId+"/resume.pdf", new File(file.getOriginalFilename()))
							.withCannedAcl(CannedAccessControlList.PublicRead));
		}catch(Exception e){}
		
		return "redirect:/user/index";
	}
	
	@RequestMapping(value="/user/updateeducation", method=RequestMethod.POST)
	public String updateEducation(HttpServletRequest request, @RequestParam String institute,@RequestParam String syear,@RequestParam String university
			,@RequestParam String eyear) {
		
		int start = Integer.parseInt(syear);
		int end = Integer.parseInt(eyear);
		
		String sql ="update candidate_master set Candidate_Institute='"+institute+"',Candidate_Course_StartYear="+start+",Candidate_Course_EndYear="+
		end+",Candidate_University='"+university+"' where User_Id="+request.getSession().getAttribute("userId");
		jdbcTemplate.execute(sql);
		return "redirect:/user/editprofile";
	}
	
	@RequestMapping(value="/user/updatecontact", method=RequestMethod.POST)
	public String updateContact(@RequestParam String email,@RequestParam String mobile,@RequestParam String addressLine,
			@RequestParam String addressLandmark, @RequestParam String city,@RequestParam String state, @RequestParam String pincode,HttpServletRequest request) {
		
		int pin = Integer.parseInt(pincode);
		String sql = "update user set User_Email='"+email+"', User_MobileNumber='"+mobile+"', User_AddressLine='"+addressLine+"',User_AddressLandmark='"+addressLandmark+"',User_City='"+city
				+ "',User_State='"+state+"',User_PinCode="+pin+" where User_Id="+request.getSession().getAttribute("userId");
		jdbcTemplate.execute(sql);
		return "redirect:/user/editprofile";
	}
}
