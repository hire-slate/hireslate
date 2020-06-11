<div class="page-content">
 <script src="https://www.google.com/recaptcha/api.js" async defer></script>

		<div class="form-v1-content">
			<div class="wizard-form">
		        <form class="form-register" action="/user/company/register/new" method="post" id="companyForm" enctype="multipart/form-data">
		        	<div id="form-total">
		        		<!-- SECTION 1 -->
			            <h2>
			            	<p class="step-icon"><span>01</span></p>
			            	<span class="step-text">Company Infomation</span>
			            </h2>	
			            <section>
			                <div class="inner">
			                	<div class="wizard-header">
									<h3 class="heading">Company Infomation</h3>
									<p>Please enter your Company infomation and proceed to the next step so we can build your accounts.  </p>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Name</legend>
											<input type="text" class="form-control" id="first-name" name="companyName" placeholder="Company Name" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Website</legend>
											<input type="text" class="form-control" id="last-name" name="companyWebsite" placeholder="Company Website Link" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Contact No</legend>
											<input type="text" name="companyContact" id="cpassword" class="form-control" placeholder="Company Contact" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Username</legend>
											<input type="text" name="companyUsername" id="cpassword" class="form-control" placeholder="Username" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Password</legend>
											<input type="password" name="companyPassword" id="cpassword" class="form-control" placeholder="Password" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Confirm Password</legend>
											<input type="password" name="companyCPassword" id="cpassword" class="form-control" placeholder="Confirm Password" required>
										</fieldset>
									</div>
								</div>
				
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Address</legend>
											<input type="text" class="form-control" id="last-name" name="companyAddress" placeholder="Address Line 1" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Landmark</legend>
											<input type="text" name="companyLandmark" id="your_email" class="form-control" pattern="[^@]+@^@]+.[a-zA-Z]{2,6}" placeholder="Landmark" required>
										</fieldset>
									</div>
								</div>
								<div class = "form-row">
									<div class="form-holder">
										<fieldset>
											<legend>City</legend>
											<input type="text" class="form-control" id="city" name="companyCity" placeholder="City" required>
										</fieldset>
									</div>
									<div class="form-holder">
										<fieldset>
											<legend>Pincode</legend>
											<input type="number" class="form-control" id="pincode" name="companyPincode" placeholder="Pincode" required>
										</fieldset>
									</div>
									
								</div>
								<div class = "form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>State</legend>
											<input type="text" class="form-control" id="state" name="companyState" placeholder="State" required>
										</fieldset>
									</div>
								</div>
								<div class = "form-row">	
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>GST No.</legend>
											<input type="text" class="form-control" id="gst" name="companyGST" placeholder="GST No" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Pancard</legend>
											<input type="text" name="companyPancard" id="pancard" class="form-control" placeholder="Company Pancard" required>
										</fieldset>
									</div>
								</div>	
								<div class="form-row">
								<div class="form-holder form-holder-2">
									<fieldset>
										<legend>Company Logo</legend>
										<input type="file" class="form-control" name="logo" required>
										<p>Upload PNG only</p>
									</fieldset>
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
			finish : '<i class="zmdi zmdi-check"></i>',
			current : ''
		},

		onFinished : function(event, currentIndex){
			$("#companyForm").submit();	
		}
	});
</script>
	