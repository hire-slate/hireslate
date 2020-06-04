package com.hireslate.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.hireslate.model.JobMasterEntity;
import com.hireslate.model.CandidateMasterEntity;
import com.hireslate.model.JobCandidateMappingEntity;
import com.hireslate.model.UserEntity;
import com.hireslate.repository.JobStagesRepository;
import com.hireslate.service.CandidateMasterService;
import com.hireslate.service.JobCandidateMappingService;
import com.hireslate.service.JobMasterService;
import com.hireslate.service.JobStagesService;
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
	@Autowired
	JobCandidateMappingService jcms;
	
	
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
	
	@Autowired
	private JobStagesService jss;
	
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
			request.getSession().setAttribute("imgurl", "https://hireslate.s3.ap-south-1.amazonaws.com/"+user.getUserId()+"/photo.png");
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
			InputStream is= file.getInputStream();
			s3client.putObject(new PutObjectRequest(bucket, userId+"/photo.png",is,new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead));	
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
		
		if(password.equals(cPassword)) {
		String sql = "update user set User_Fname='"+firstName+"',User_Mname='"+middleName+"',User_Lname='"+lastName+"',User_UserName='"+userName+"',User_Password='"+cPassword+"' where User_Id="+request.getSession().getAttribute("userId");
		jdbcTemplate.execute(sql);
		
		return "redirect:/user/editprofile";
		}else {
			return "redirect:/user/editprofile";
		}
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
			InputStream is= file.getInputStream();
			s3client.putObject(new PutObjectRequest(bucket, userId+"/photo.png",is,new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead));
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
	
	@RequestMapping(value = "/jobDescription/{id}",method = RequestMethod.GET)
	public String jobDescription(Model model,@PathVariable("id")int jobId) {
		Map<String, Object> jobDescription = jobMasterService.viewJobDescription(jobId);
		model.addAttribute("jobEntity", jobDescription);
		return "user/jobDescription.jsp";
	}
	
	@RequestMapping(value = "/job-apply", method = RequestMethod.POST)
	public String userAppliedJob(Model model, @RequestParam("userId")int userId, @RequestParam("jobId")int jobId, HttpServletRequest request,HttpServletResponse response ) 
			throws AddressException, MessagingException, IOException{
		HttpSession s = request.getSession();
		JobCandidateMappingEntity jobCandidateMappingEntity = new JobCandidateMappingEntity();
		jobCandidateMappingEntity.setJobId(jobId);
		jobCandidateMappingEntity.setUserId(userId);
		try {
			jcms.insert(jobCandidateMappingEntity);
			s.setAttribute("MsgForJobApply", "You applied for this job successfully");
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			   
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("hireslate@gmail.com", "hesoyamtrojan@123");
			      }
			   });
			   Message msg = new MimeMessage(session);
			   msg.setFrom(new InternetAddress("hireslate@gmail.com", false));
			   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userService.getUserEmail(userId)));
			   System.out.println(userService.getUserEmail(userId));
			   msg.setSubject("Hireslate: Applied for "+jobMasterService.getJobTitle(jobId));
			   String line1 = "You have applied for "+jobMasterService.getJobTitle(jobId)+"<br/>";
			   String line2 = "Interview Steps are as follows :<br/>";
			   String line3 = jss.getInterviewSteps(jobId);
			   msg.setContent(line1+line2+line3, "text/html");
			   msg.setSentDate(new java.util.Date());
			   Transport.send(msg);
		}
		catch(DuplicateKeyException e) {
			s.setAttribute("MsgForJobApply", "You Already applied for this job");
		}
		
		return "redirect:/user/tryfrontend";
	}
}