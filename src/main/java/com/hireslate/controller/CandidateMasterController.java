package com.hireslate.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hireslate.model.CandidateMasterEntity;
import com.hireslate.model.UserEntity;
import com.hireslate.service.CandidateMasterService;
import com.hireslate.service.UserService;

@Controller
@RequestMapping(value="/user")
public class CandidateMasterController {

	@Autowired
	UserService userService;
	@Autowired
	CandidateMasterService candidateMasterService;
	
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
			@RequestParam("candidateGithub") String github) {
	
		
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
		candidate.setCandidateCourseStartYear(startYear);
		candidate.setCandidateCourseEndYear(endYear);
		candidate.setCandidateLinkedIn(linkedIn);
		candidate.setCandidateGithub(github);
		candidateMasterService.insertCandidateMaster(candidate);
		System.out.println("value inserted");
		return "redirect:/user/register";
		
	}

	
	
}
