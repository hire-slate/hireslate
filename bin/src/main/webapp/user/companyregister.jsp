<div class="page-content">
		<div class="form-v1-content">
			<div class="wizard-form">
		        <form class="form-register" action="/user/company/register/new" method="post">
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
											<legend>Company Name</legend>
											<input type="text" class="form-control" id="first-name" name="companyName" placeholder="Company Name" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Company Website</legend>
											<input type="text" class="form-control" id="last-name" name="companyWebsite" placeholder="Company Website Link" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Company Contact</legend>
											<input type="text" name="companyContact" id="cpassword" class="form-control" placeholder="Company Contact" required>
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
											<legend>state</legend>
											<input type="text" class="form-control" id="state" name="companyState" placeholder="State" required>
										</fieldset>
									</div>
								</div>
								<div class = "form-row">	
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>GST No.</legend>
											<input type="text" class="form-control" id="state" name="companyGST" placeholder="GST No" required>
										</fieldset>
									</div>
								</div>
								<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<legend>Pancard</legend>
											<input type="text" name="companyPancard" id="cpassword" class="form-control" placeholder="Company Pancard" required>
										</fieldset>
									</div>
								</div>
									<div class="form-row">
									<div class="form-holder form-holder-2">
										<fieldset>
											<input type="submit" name="companySubmit" id="cpassword" class="form-control" value="register" required>
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
			finish : '<i class="zmdi zmdi-check"></i>',
			current : ''
		},
	});
</script>
	