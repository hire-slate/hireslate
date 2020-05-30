package com.hireslate.controller;

import java.io.File;
import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.hireslate.model.UserEntity;
import com.hireslate.service.JobMasterService;
import com.hireslate.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired 
	UserService  userService;
	@Autowired
	JobMasterService jobMasterService;
	
	@Value("$aws.accessToken")
	private String accessToken;
	@Value("$aws.secretKey")
	private String secretKey;
	@Value("$aws.bucket")
	private String bucket;
	@Value("$aws.url")
	private String awsUrl;
	
	@RequestMapping(value = "/index" , method = RequestMethod.GET)
	public String showIndex(HttpServletRequest request) {
		request.setAttribute("totalJobs",jobMasterService.totalJobs());
		return "user/index.jsp";
	}
	
	@RequestMapping(value="/editprofile", method=RequestMethod.GET)
	public String editProfile(Model model,HttpServletRequest request,HttpServletResponse response) {
		return "user/editprofile.jsp";
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
	            return "redirect:uploadStatus";
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
		
		return "";
	}
	
	
	
	@RequestMapping(value="/updatebasic", method=RequestMethod.POST)
	public String updateBasic(HttpServletRequest request,HttpServletResponse response) {
		return "";
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
		
		return "";
	}
}
