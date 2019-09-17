package com.hireslate.model;

import java.util.Date;

public class UserEntity {
	
	private int userId,userGender,userRole,userPincode;
	private String userFname,userMname,userLname,userMobileNumber,userEmail,userAddressLine,userAddressLandmark,userCity,userState,userUserName,userPassword;
	private Date userDateOfBirth;
	
	public UserEntity(int userId, int userGender, int userRole, int userPincode, String userFname, String userMname,
			String userLname, String userMobileNumber, String userEmail, String userAddressLine,
			String userAddressLandmark, String userCity, String userState, String userUserName, String userPassword,
			Date userDateOfBirth) {
		super();
		this.userId = userId;
		this.userGender = userGender;
		this.userRole = userRole;
		this.userPincode = userPincode;
		this.userFname = userFname;
		this.userMname = userMname;
		this.userLname = userLname;
		this.userMobileNumber = userMobileNumber;
		this.userEmail = userEmail;
		this.userAddressLine = userAddressLine;
		this.userAddressLandmark = userAddressLandmark;
		this.userCity = userCity;
		this.userState = userState;
		this.userUserName = userUserName;
		this.userPassword = userPassword;
		this.userDateOfBirth = userDateOfBirth;
	}
	
	public UserEntity() {}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserGender() {
		return userGender;
	}

	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public int getUserPincode() {
		return userPincode;
	}

	public void setUserPincode(int userPincode) {
		this.userPincode = userPincode;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserMname() {
		return userMname;
	}

	public void setUserMname(String userMname) {
		this.userMname = userMname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddressLine() {
		return userAddressLine;
	}

	public void setUserAddressLine(String userAddressLine) {
		this.userAddressLine = userAddressLine;
	}

	public String getUserAddressLandmark() {
		return userAddressLandmark;
	}

	public void setUserAddressLandmark(String userAddressLandmark) {
		this.userAddressLandmark = userAddressLandmark;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserUserName() {
		return userUserName;
	}

	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getUserDateOfBirth() {
		return userDateOfBirth;
	}

	public void setUserDateOfBirth(Date userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}
	
	
}
