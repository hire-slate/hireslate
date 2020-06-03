package com.hireslate.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
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
	private String bucket;
	@Value("${aws.url}")
	private String awsUrl;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
		PutObjectRequest putObjectRequest = new PutObjectRequest( bucket, folderName, emptyContent,metadata);
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
	
	@RequestMapping(value="/update-company-basic",method=RequestMethod.POST)
	public String updateBasic(HttpServletRequest request, @RequestParam("companyName") String companyName,
			@RequestParam("website") String website,@RequestParam("password") String password,@RequestParam("cpassword") String cpassword) {
		
		String sql = "update company_master set Company_Name='"+companyName+"',Company_Website='"+website+"', Company_Password='"+cpassword+"'"
				+ "where Company_Id="+request.getSession().getAttribute("companyId");
		jdbcTemplate.execute(sql);
		return "redirect:/user/company/edit-companyprofile";
	}
	
	@RequestMapping(value="/update-company-contact",method=RequestMethod.POST)
	public String updateContact(HttpServletRequest request, @RequestParam("addressLine") String addressLine,@RequestParam("addressLandmark") String landmark,
			@RequestParam("city") String city,@RequestParam("pincode") String pincode,@RequestParam("contact") String contact){
		int pin = Integer.parseInt(pincode);
		String sql = "update company_master set Company_AddressLine='"+addressLine+"',Company_Landmark='"+landmark+"', Company_City='"+city+"'"
				+", Company_Pincode="+pin+ " where Company_Id="+request.getSession().getAttribute("companyId");
		jdbcTemplate.execute(sql);
		return "redirect:/user/company/edit-companyprofile";
	}
	
	@RequestMapping(value="/update-company-documents",method=RequestMethod.POST)
	public String updateDocuments(HttpServletRequest request,@RequestParam("pancard") String pancard,@RequestParam("gst") String gst) {
		
		String sql = "update company_master set Company_Gsitn='"+gst+"',Company_Pancard='"+pancard+
				"' where Company_Id="+request.getSession().getAttribute("companyId");
		jdbcTemplate.execute(sql);
		return "redirect:/user/company/edit-companyprofile";
	}
	
	@RequestMapping(value="/update-logo",method=RequestMethod.POST)
	public String updatePhoto(HttpServletRequest request,@RequestParam("logo") MultipartFile file) {
		
		String companyId = (String) request.getSession().getAttribute("companyId");
		AWSCredentials credentials = new BasicAWSCredentials(accessToken,secretKey);
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.AP_SOUTH_1)
				  .build();
		try {
			//byte[] bytes = file.getBytes();
			//String path = file.getOriginalFilename();
	        //Path path = java.nio.file.Paths.get(file.getOriginalFilename());
			s3client.putObject(
					new PutObjectRequest(bucket, "company/"+companyId+"/logo.png", new File(file.getOriginalFilename()))
							.withCannedAcl(CannedAccessControlList.PublicRead));
		}catch(Exception e){}
		return "redirect:/user/company/edit-companyprofile";
	}
	
	@RequestMapping(value="/update-pancard",method=RequestMethod.POST)
	public String updatePancard(HttpServletRequest request,@RequestParam("pancard") MultipartFile file) {
		
		String companyId = (String) request.getSession().getAttribute("companyId");
		AWSCredentials credentials = new BasicAWSCredentials(accessToken,secretKey);
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.AP_SOUTH_1)
				  .build();
		try {
			//byte[] bytes = file.getBytes();
			//String path = file.getOriginalFilename();
	        //Path path = java.nio.file.Paths.get(file.getOriginalFilename());
			s3client.putObject(
					new PutObjectRequest(bucket, "company/"+companyId+"/pancard.png", new File(file.getOriginalFilename()))
							.withCannedAcl(CannedAccessControlList.PublicRead));
		}catch(Exception e){}
		return "redirect:/user/company/edit-companyprofile";
	}
	
	@RequestMapping(value="/edit-companyprofile",method=RequestMethod.GET)
	public String updateForm(HttpServletRequest request) {
		
		CompanyMasterEntity cme = companyMasterService.getCompany((int)request.getSession().getAttribute("companyId"));
		//System.out.println((int)request.getSession().getAttribute("companyId"));
		//request.getSession().setAttribute("companyName", cme.getCompanyName());
		request.getSession().setAttribute("cwebsite",cme.getCompanyWebsite());
		request.getSession().setAttribute("cpassword",cme.getCompanyPassword());
		request.getSession().setAttribute("caddressLine",cme.getCompanyAddressLine());
		request.getSession().setAttribute("caddressLandmark",cme.getCompanyLandmark());
		request.getSession().setAttribute("ccity",cme.getCompanyCity());
		request.getSession().setAttribute("cpincode",cme.getCompanyPincode());
		request.getSession().setAttribute("ccontact",cme.getCompanyContact());
		request.getSession().setAttribute("pancard",cme.getCompanyPancard());
		request.getSession().setAttribute("gst",cme.getCompanyGstin());
		return "admin/companyedit.jsp";
	}
}