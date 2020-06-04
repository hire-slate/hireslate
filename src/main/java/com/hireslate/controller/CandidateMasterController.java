package com.hireslate.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hireslate.model.CandidateMasterEntity;
import com.hireslate.model.UserEntity;
import com.hireslate.service.CandidateMasterService;
import com.hireslate.service.UserService;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.common.io.Files;

@Controller
@RequestMapping(value="/user")
public class CandidateMasterController {

	@Autowired
	UserService userService;
	@Autowired
	CandidateMasterService candidateMasterService;
	@Value("${aws.accessToken}")
	private String accessToken;
	@Value("${aws.secretKey}")
	private String secretKey;
	@Value("${aws.bucket}")
	private String bucket;
	@Value("${aws.url}")
	private String awsUrl;
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String showCandidateRegisterForm() {
		return "user/candidateregister.jsp";
	}
	
	@RequestMapping(value = "/register/new" , method = RequestMethod.POST)
	public String RegisterCandidate(Model model,@RequestParam("userFName") String fname,@RequestParam("userLName") String lname,@RequestParam("userMName") String mname,
			@RequestParam("userEmail") String email,@RequestParam("userPassword") String password, @RequestParam("userPhoneNo") String phNo,
			@RequestParam("userGender") int gender,@RequestParam("userAddress")  String address, @RequestParam("userLandmark") String landmark, @RequestParam("userCity") String city,
			@RequestParam("userState") String state,@RequestParam("userBDate") String bdate,@RequestParam("userPincode") int pincode,@RequestParam("candidateInstitute") String institute,
			@RequestParam("candidateUniversity") String university,@RequestParam("candidateCourse") int courseId,@RequestParam("candidateStream") int streamId,
			@RequestParam("candidateStartYear") String startYear,@RequestParam("candidateEndYear") String endYear,@RequestParam("candidatelinkedIn") String linkedIn,
			@RequestParam("candidateGithub") String github, @RequestParam("photo") MultipartFile photo, @RequestParam("resume") MultipartFile resume) {
	
		
		UserEntity user = new UserEntity();
		CandidateMasterEntity candidate = new CandidateMasterEntity();
		
		Date userBirthDate = Date.valueOf(bdate);
		
		user.setUserFname(fname);
		user.setUserMname(mname);
		user.setUserLname(lname);
		user.setUserEmail(email);
		user.setUserPassword(password);
		user.setUserMobileNumber(phNo);
		user.setUserGender(gender);
		user.setUserAddressLine(address);
		user.setUserAddressLandmark(landmark);
		user.setUserCity(city);
		user.setUserState(state);
		user.setUserPincode(pincode);
		user.setUserDateOfBirth(userBirthDate);
		user.setUserRole(1);
		user.setUserUserName(email);
	
		int userId = userService.insertUserForCandidate(user);
		candidate.setUserId(userId);
		candidate.setCandidateInstitute(institute);
		candidate.setCandidateUniversity(university);
		candidate.setCourseId(courseId);
		candidate.setStreamId(streamId);
		candidate.setCandidateCourseStartYear(Integer.parseInt(startYear));
		candidate.setCandidateCourseEndYear(Integer.parseInt(endYear));
		candidate.setCandidateLinkedIn(linkedIn);
		candidate.setCandidateGithub(github);
		candidateMasterService.insertCandidateMaster(candidate);
		//System.out.println("value inserted");
		
		AWSCredentials credentials = new BasicAWSCredentials(accessToken,secretKey);
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.AP_SOUTH_1)
				  .build();
		
		String folderName = ""+userId+"/";
		//CommonService.createFolder(bucket, folderName, s3client,"/");
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, folderName, emptyContent,metadata);
		s3client.putObject(putObjectRequest);
		
		String photoExtension = Files.getFileExtension(photo.getOriginalFilename());
		try {
		if(photoExtension.equals("PNG")|| photoExtension.equals("png")) {
			InputStream is= photo.getInputStream();
			s3client.putObject(new PutObjectRequest(bucket, userId+"/photo.png",is,new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead));
		}
		
		String resumeExtension = Files.getFileExtension(resume.getOriginalFilename());
		
		if(resumeExtension.equals("pdf")|| resumeExtension.equals("PDF")) {
			InputStream is= resume.getInputStream();
			s3client.putObject(new PutObjectRequest(bucket, userId+"/resume.pdf",is,new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead));
		
		}
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

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getUserEmail()));
		   msg.setSubject("WELCOME TO HIRESLATE");
		   String message = "Welcome "+user.getUserFname()+" to Hireslate. We Hope you find a perfect job for your career.";
		   msg.setContent(message, "text/html");
		   msg.setSentDate(new java.util.Date());
		   Transport.send(msg);
		}catch(Exception e){
		}
		return "redirect:/user/index";
	}
}