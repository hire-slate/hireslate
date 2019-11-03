<div class="page-content">
	<div class="form-v1-content">
		<div class="wizard-form">
			<form class="form-register" action="/user/register/new" method="post">
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
										<input type="text" class="form-control" id="first-name"
											name="userFName" placeholder="First Name" required>
									</fieldset>
								</div>
								<div class="form-holder">
									<fieldset>
										<legend>Last Name</legend>
										<input type="text" class="form-control" id="last-name"
											name="userLName" placeholder="Surname" required>
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Middle Name</legend>
										<input type="text" class="form-control" id="last-name"
											name="userMName" placeholder="Middle Name" required>
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Your Email</legend>
										<input type="text" name="userEmail" id="your_email"
											class="form-control" pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}"
											placeholder="example@email.com" required>
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Password</legend>
										<input type="Password" name="userPassword" id="password"
											placeholder="password" class="form-control" required>
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Confirm Password</legend>
										<input type="Password" name="userCPassword" id="cpassword"
											class="form-control" placeholder="confirm password" required>
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									<fieldset>
										<legend>Birth Date:</legend>
										<input type="date" class="form-control" id="date"
											name="userBDate" placeholder="dd/mm/yyyy" required>
									</fieldset>

								</div>
								<div class="form-holder">
									<fieldset>
										<legend>Phone Number</legend>
										<input type="text" class="form-control" id="phone"
											name="userPhoneNo" placeholder="+1 888-999-7777" required>
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<select name="userGender" id="gender">
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
										<input type="text" class="form-control" id="address1"
											name="userAddress" placeholder="Address Line 1" required>
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Landmark</legend>
										<input type="text" class="form-control" id="landmark"
											name="userLandmark" placeholder="Landmark" required>
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									<fieldset>
										<legend>City</legend>
										<input type="text" class="form-control" id="city"
											name="userCity" placeholder="City" required>
									</fieldset>
								</div>
								<div class="form-holder">
									<fieldset>
										<legend>Pincode</legend>
										<input type="number" class="form-control" id="pincode"
											name="userPincode" placeholder="Pincode" required>
									</fieldset>
								</div>

							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>state</legend>
										<input type="text" class="form-control" id="state"
											name="userState" placeholder="State" required>
									</fieldset>
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
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Course</legend>
										<input type="text" class="form-control" id="course"
											name="candidateCourse" placeholder="Course Name" required>
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Stream</legend>
										<input type="text" class="form-control" id="stream"
											name="candidateStream" placeholder="stream Name" required>
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder">
									<fieldset>
										<legend>Start Year</legend>
										<input type="text" class="form-control" id="syear"
											name="candidateStartYear" placeholder="yyyy" required>
									</fieldset>
								</div>
								<div class="form-holder">
									<fieldset>
										<legend>End Year</legend>
										<input type="text" class="form-control" id="eyear"
											name="candidateEndYear" placeholder="yyyy" required>
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>LinkedIn</legend>
										<input type="text" class="form-control" id="linkedin"
											name="candidatelinkedIn" placeholder="LinkedIn">
									</fieldset>
								</div>
							</div>
							<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Github</legend>
										<input type="text" class="form-control" id="github"
											name="candidateGithub" placeholder="Github">
									</fieldset>
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
<script type="text/javascript">
	$("#form-total").steps({
		headerTag : "h2",
		bodyTag : "section",
		transitionEffect : "fade",
		enableAllSteps : true,
		stepsOrientation : "vertical",
		autoFocus : true,
		transitionEffectSpeed : 500,
		titleTemplate : '<div class="title">#title#</div>',
		labels : {
			previous : 'Back Step',
			next : '<i class="zmdi zmdi-arrow-right"></i>',
			finish : '<button type="submit"><i class="zmdi zmdi-check"></i></button>',
			current : ''
		},
	});
</script>



