package com.hireslate.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.hireslate.model.CompanyMasterEntity;
import com.hireslate.service.CompanyMasterService;

@Controller
@RequestMapping("/user/company")

public class CompanyMasterController {
	
	@Autowired
	CompanyMasterService companyMasterService;
	
	@Value("${aws.accessToken}")
	private String accessToken;
	@Value("${aws.secretKey}")
	private String secretKey;
	@Value("${aws.bucket}")
	private String bucket1;
	@Value("${aws.url}")
	private String awsUrl;
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String showCandidateRegisterForm() {
		return "user/companyregister.jsp";
	}

	@RequestMapping(value = "/register/new", method=RequestMethod.POST)
	public String RegisterCompany(Model model,@RequestParam("companyName") String companyName , @RequestParam("companyWebsite") String companyWebsite,
									@RequestParam("companyUsername") String companyUsername, @RequestParam("companyPassword") String companyPassword,
									@RequestParam("companyCPassword") String companyCPassword,@RequestParam("companyContact") String companyContact, @RequestParam("companyPancard") String companyPancard,
									@RequestParam("companyAddress") String companyAddress,@RequestParam("companyLandmark") String companyLandmark,@RequestParam("companyCity") String companyCity,
									@RequestParam("companyPincode") String companyPincode, @RequestParam("companyState") String companyState,@RequestParam("companyGST") String companyGST,HttpServletRequest request) {

		String msg;
		if(companyPassword.equals(companyCPassword)) {
		CompanyMasterEntity company = new CompanyMasterEntity();
		company.setCompanyName(companyName);
		company.setCompanyContact(companyContact);
		company.setCompanyWebsite(companyWebsite);
		company.setCompanyUsername(companyUsername);
		company.setCompanyPassword(companyPassword);
		company.setCompanyPancard(companyPancard);
		company.setCompanyAddressLine(companyAddress);
		company.setCompanyPincode(Integer.parseInt(companyPincode));
		company.setCompanyLandmark(companyLandmark);
		company.setCompanyGstin(companyGST);
		company.setCompanyCity(companyCity);
		
		msg = companyMasterService.insertCompanyMaster(company,request);
		
		}
		else {
			msg = "redirect:/user/company/register";
		}
		AWSCredentials credentials = new BasicAWSCredentials(accessToken,secretKey);
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.AP_SOUTH_1)
				  .build();
		
		int lastId = companyMasterService.getLastCompanyId();
		String folderName = "company/"+lastId+"/";
		//CommonService.createFolder(bucket, folderName, s3client,"/");
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		PutObjectRequest putObjectRequest = new PutObjectRequest( bucket1, folderName, emptyContent,metadata);
		s3client.putObject(putObjectRequest);
		return msg;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public String showLoginPage(Model model){
		return "admin/login.jsp";
	}

	@RequestMapping(value = "/dologin")
	public String doLogin(@RequestParam("companyUsername") String username,@RequestParam("companyPassword") String password,HttpServletRequest request) {
		String msg;
		msg = companyMasterService.doCompanyLogin(username,password,request);
		//System.out.println(msg);
		return msg;
	}
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String doLogout(HttpServletRequest request) {
		String msg = companyMasterService.doCompanyLogout(request);
		return msg;
	}
	
	@RequestMapping(value = "/companyregister", method = RequestMethod.GET )
	public String showCompanyRegisterPage(Model model){
		return "user/companyregister.jsp";
	}
}