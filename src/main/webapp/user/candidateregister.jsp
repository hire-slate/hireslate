<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <script src="https://www.google.com/recaptcha/api.js" async defer></script>

<div class="page-content">
	<div class="form-v1-content">
		<div class="wizard-form">
			<form class="form-register" action="/user/register/new" method="post" id="userForm" enctype="multipart/form-data">
				<div id="form-total">
					<h2>
						<p class="step-icon">
							<span>01</span>
							</p>
						<span class="step-text">Personal Infomation</span>
					</h2>
					<section>
						<div class="inner">
							<div class="wizard-header">
								<h3 class="heading">Personal Infomation</h3>	
								<p>Please enter your personal infomation and proceed to the
									next step so we can build your accounts.</p>
							</div>
							<div class="form-row">
								<div class="form-holder">
									<fieldset>
										<legend>First Name</legend>
										<input type="text" class="form-control" id="first-name" name="userFName" placeholder="First Name" required>
									</fieldset>
									<div id="errorFirstName" style="display: none"><small style="color: red; ">Enter First Name</small></div>
								</div>
								<div class="form-holder">
									<fieldset>
										<legend>Last Name</legend>
										<input type="text" class="form-control" id="last-name" name="userLName" placeholder="Surname" required>
									</fieldset>
									<div id="errorLastName" style="display: none"><small style="color: red; ">Enter Last Name</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Middle Name</legend>
										<input type="text" class="form-control" id="middle-name" name="userMName" placeholder="Middle Name" required>
									</fieldset>
									<div id="errorMiddleName" style="display: none"><small style="color: red; ">Enter Middle Name</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Your Email</legend>
										<input type="text" name="userEmail" id="email" class="form-control" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}"
											placeholder="example@email.com" required>
									</fieldset>
									<div id="errorEmail" style="display: none"><small style="color: red; ">Enter Email</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Password</legend>
										<input type="Password" name="userPassword" id="password" placeholder="password" class="form-control" required>
									</fieldset>
									<div id="errorPassword" style="display: none"><small style="color: red; ">Enter Password</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Confirm Password</legend>
										<input type="Password" name="userCPassword" id="cpassword"
											class="form-control" placeholder="confirm password" required>
									</fieldset>
									<div id="errorCPassword" style="display: none"><small style="color: red; ">Enter Confirm Password</small></div>
									<div id="errorCMPassword" style="display: none"><small style="color: red; ">Password and confirm password must match</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									<fieldset>
										<legend>Birth Date:</legend>
										<input type="date" class="form-control" id="birthdate" name="userBDate" placeholder="dd/mm/yyyy" required>
									</fieldset>
									<div id="errorBDate" style="display: none"><small style="color: red; ">Enter BirthDate</small></div>
								</div>
								<div class="form-holder">
									<fieldset>
										<legend>Phone Number</legend>
										<input type="text" class="form-control" id="phoneno" name="userPhoneNo" placeholder="+1 888-999-7777" required>
									</fieldset>
									<div id="errorPhoneNo" style="display: none"><small style="color: red; ">Enter Phone Number</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<select name="userGender" id="gender" required>
										<option value="0" selected>Male</option>
										<option value="1">Female</option>
										<option value="2">other</option>
									</select>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Address</legend>
										<input type="text" class="form-control" id="address1" name="userAddress" placeholder="Address Line 1" required>
									</fieldset>
									<div id="errorAddress1" style="display: none"><small style="color: red; ">Enter Address</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Landmark</legend>
										<input type="text" class="form-control" id="landmark" name="userLandmark" placeholder="Landmark" required>
									</fieldset>
									<div id="errorLandmark" style="display: none"><small style="color: red; ">Enter Landmark</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									<fieldset>
										<legend>City</legend>
										<input type="text" class="form-control" id="city" name="userCity" placeholder="City" required>
									</fieldset>
									<div id="errorCity" style="display: none"><small style="color: red; ">Enter City</small></div>
								</div>
								<div class="form-holder">
									<fieldset>
										<legend>Pincode</legend>
										<input type="number" class="form-control" id="pincode" name="userPincode" placeholder="Pincode" required>
									</fieldset>
									<div id="errorPincode" style="display: none"><small style="color: red; ">Enter Pincode</small></div>
								</div>

							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>state</legend>
										<input type="text" class="form-control" id="state" name="userState" placeholder="State" required>
									</fieldset>
									<div id="errorState" style="display: none"><small style="color: red; ">Enter State</small></div>
								</div>
							</div>

						</div>
					</section>
					<h2>
						<p class="step-icon">
							<span>02</span>
						</p>
						<span class="step-text">Eductional Information</span>
					</h2>
					<section>
						<div class="inner">
							<div class="wizard-header">
								<h3 class="heading">Eductional Information</h3>
								<p>Please enter your eductional infomation and proceed to
									the next step so we can build your accounts.</p>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Institute</legend>
										<input type="text" class="form-control" id="institute"
											name="candidateInstitute"
											placeholder="institute/College Name" required>
										</fieldset>
									<div id="errorInstitute" style="display: none"><small style="color: red; ">Enter Institute</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>University</legend>
										<input type="text" class="form-control" id="university"
											name="candidateUniversity" placeholder="University Name"
											required>
									</fieldset>
									<div id="errorUniversity" style="display: none"><small style="color: red; ">Enter University</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Course</legend>
											<select name="candidateCourse" id="course" required>
												<option value="0">select course</option>
												<c:forEach items="${courses}" var="variable">
													<option value="${variable.courseId}">${variable.courseName}</option>
												</c:forEach>
											</select>
										
									</fieldset>
									<div id="errorCourse" style="display: none"><small style="color: red; ">Select Course</small></div>
		
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Stream</legend>
										<select name="candidateStream" id="stream" required>
											<option value="0">select Stream</option>
											<c:forEach items="${streams}" var="variable">
													<option value="${variable.streamId}">${variable.streamName}</option>
											</c:forEach>
										</select>
									</fieldset>
									<div id="errorStream" style="display: none"><small style="color: red; ">Select Stream</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									<fieldset>
										<legend>Start Year</legend>
										<input type="text" class="form-control" id="syear"
											name="candidateStartYear" placeholder="yyyy" required>
									</fieldset>
									<div id="errorSYear" style="display: none"><small style="color: red; ">Enter Start Year</small></div>
								</div>
								<div class="form-holder">
									<fieldset>
										<legend>End Year</legend>
										<input type="text" class="form-control" id="eyear"
											name="candidateEndYear" placeholder="yyyy" required>
									</fieldset>
									<div id="errorEYear" style="display: none"><small style="color: red; ">Enter End Year</small></div>
								</div>
								<div class="form-holder form-holder-2">
								<div id="errorSEWrong" style="display: none"><small style="color: red">Start year must be less than end year</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>LinkedIn</legend>
										<input type="url" class="form-control" id="linkedin"
											name="candidatelinkedIn" placeholder="LinkedIn">
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Github</legend>
										<input type="url" class="form-control" id="github"
											name="candidateGithub" placeholder="Github">
									</fieldset>
								</div>
							</div>
						</div>
					</section>
					
					<h2>
						<p class="step-icon">
							<span>03</span>
						</p>
						<span class="step-text">Upload Documents</span>
					</h2>
					<section>
						<div class="inner">
							<div class="wizard-header">
								<h3 class="heading">Upload Documents</h3>
								<p>Please Upload the required documents.</p>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Photo</legend>
										<input type="file" class="form-control" name="photo" id="photo" required>
										<p>Upload PNG of square 544px only </p>
									</fieldset>
									<div id="errorPhoto" style="display: none"><small style="color: red; ">Upload your photo</small></div>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Resume</legend>
										<input type="file" class="form-control" name="resume" id="resume" required>
										<p>Upload PDF only</p>
									</fieldset>
									<div id="errorResume" style="display: none"><small style="color: red; ">Upload your resume</small></div>
								</div>
							</div>
							
							<div class="form-row">
								<div class="g-recaptcha col-sm-5" name="recaptcha" data-sitekey="6LeqHwEVAAAAAHqdURfybvwQ2_Q6hkjvsuOy9BRE">
								</div>
							</div>
						</div>
					</section>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/frontend/cregister/js/jquery-2.1.4.js" type="text/javascript"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-steps/1.1.0/jquery.steps.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>

<script type="text/javascript">


	function validateStep1(){
		var result = true;

		if($("#first-name").val() == ""){
			$("#errorFirstName").css("display","flex");
			result = false;
		}
		else{
			$("#errorFirstName").css("display","none");
		}
		if($("#last-name").val() == ""){
			$("#errorLastName").css("display","flex");
			result = false;
		}
		else{
			$("#errorLastName").css("display","none");
		}
		if($("#middle-name").val() == ""){
			$("#errorMiddleName").css("display","flex");
			result = false;
		}
		else{
			$("#errorMiddleName").css("display","none");
		}
		if($("#email").val() == ""){
			$("#errorEmail").css("display","flex");
			result = false;
		}
		else{
			$("#errorEmail").css("display","none");
		}
		if($("#password").val() == ""){
			$("#errorPassword").css("display","flex");
			result = false;
		}
		else{
			$("#errorPassword").css("display","none");
		}
		if($("#cpassword").val() == ""){
			$("#errorCPassword").css("display","flex");
			result = false;
		}
		else{
			$("#errorCPassword").css("display","none");
		}
		if($("#birthdate").val() == ""){
			$("#errorBDate").css("display","flex");
			result = false;
		}
		else{
			$("#errorBDate").css("display","none");
		}
		if($("#phoneno").val() == ""){
			$("#errorPhoneNo").css("display","flex");
			result = false;
		}
		else{
			$("#errorPhoneNo").css("display","none");
		}
		if($("#address1").val() == ""){
			$("#errorAddress1").css("display","flex");
			result = false;
		}
		else{
			$("#errorAddress1").css("display","none");
		}
		if($("#landmark").val() == ""){
			$("#errorLandmark").css("display","flex");
			result = false;
		}
		else{
			$("#errorLandmark").css("display","none");
		}
		if($("#city").val() == ""){
			$("#errorCity").css("display","flex");
			result = false;
		}
		else{
			$("#errorCity").css("display","none");
		}
		if($("#pincode").val() == ""){
			$("#errorPincode").css("display","flex");
			result = false;
		}
		else{
			$("#errorPincode").css("display","none");
		}
		if($("#state").val() == ""){
			$("#errorState").css("display","flex");
			result = false;
		}
		else{
			$("#errorState").css("display","none");
		}
		if( ($("#password").val() != "") && ($("#cpassword").val() != "") && ($("#password").val() != $("#cpassword").val()) ){
			$("#errorCMPassword").css("display","flex");
			result = false;
		}
		else{
			$("#errorCMPassword").css("display","none");
		}
		return result;
	}


	function validateStep2(){

		var result = true;

		if($("#institute").val() == ""){
			$("#errorInstitute").css("display","flex");
			result = false;
		}
		else{
			$("#errorInstitute").css("display","none");
		}

		
		if($("#university").val() == ""){
			$("#errorUniversity").css("display","flex");
			result = false;
		}
		else{
			$("#errorUniversity").css("display","none");
		}
		if($("#course").val() == 0){
			$("#errorCourse").css("display","flex");
			result = false;
		}
		else{
			$("#errorCourse").css("display","none");
		}
		if($("#stream").val() == 0){
			$("#errorStream").css("display","flex");
			result = false;
		}
		else{
			$("#errorStream").css("display","none");
		}
		if($("#syear").val() == ""){
			$("#errorSYear").css("display","flex");
			result = false;
		}
		else{
			$("#errorSYear").css("display","none");
		}
		if($("#eyear").val() == ""){
			$("#errorEYear").css("display","flex");
			result = false;
		}
		else{
			$("#errorEYear").css("display","none");
		}
		if( ($("#syear").val() != "") && ($("#eyear").val() != "") && ($("#syear").val() > $("#eyear").val()) ){
			$("#errorSEWrong").css("display","flex");
			result = false;
		}
		else{
			$("#errorSEWrong").css("display","none");
		}
		return result;
	}

	function validateStep3(){
		var result = true;

		if($("#photo").val() == ""){
			$("#errorPhoto").css("display","flex");
			result = false;
		}
		else{
			$("#errorPhoto").css("display","none");
		}

		
		if($("#resume").val() == ""){
			$("#errorResume").css("display","flex");
			result = false;
		}
		else{
			$("#errorResume").css("display","none");
		}
		return result;
	}
	
	$("#form-total").steps({
		headerTag : "h2",
		bodyTag : "section",
		transitionEffect : "fade",
		stepsOrientation : "vertical",
		autoFocus : true,
		transitionEffectSpeed : 500,
		titleTemplate : '<div class="title">#title#</div>',
		labels : {
			previous : 'Back Step',
			next : '<i class="zmdi zmdi-arrow-right"></i>',
			finish : '<i class="zmdi zmdi-check"></i>',
			current : ''
		},
		onStepChanging : function(event, currentIndex, newIndex){
			if(currentIndex > newIndex){
				return true;
			}
	
			if(currentIndex == 0){
				return validateStep1();
			}
			if(currentIndex == 1){
				//return true;
				return validateStep2();
			}
			
		},
		onFinished : function(event, currentIndex){
			if(validateStep3()){
				$("#userForm").submit();
			}	
		}
	})
</script>
