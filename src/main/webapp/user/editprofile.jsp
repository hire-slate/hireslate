<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<section class="content-header">
	<h1>User Profile</h1>
</section>

<section class="content">

	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Update Basic Details</h3>
				</div>
				<form role="form" action="" method="post">
					<div class="box-body">
						<div class="col-md-4">
							<div class="form-group">
								<input type="hidden" name="userId" value=""> <label
									for="firstName">First Name</label> <input type="text"
									class="form-control" name="firstName" value="">
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label for="middleName">Middle Name</label> <input type="text"
									class="form-control" name="middleName" value="">
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label for="lastName">Last Name</label> <input type="text"
									class="form-control" name="lastName" value="">
							</div>
						</div>
						
						<div class="col-md-4">
							<div class="form-group">
								<label for="username">Username</label> 
								<input type="text" class="form-control" name="username" value="">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="password">Password</label> 
								<input type="password" class="form-control" name="password" value="">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="cpassword">Confirm Password</label> 
								<input type="password" class="form-control" name="cpassword" value="">
							</div>
						</div>
						
						<div class="box-header with-border">
							<h3 class="box-title">Update Contact Details</h3>
						</div>
						
						<div class="col-md-6">
							<div class="form-group">
								<label for="email">Email Address</label> 
								<input type="email" class="form-control" name="email" value="">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="mobile">Mobile Number</label> 
								<input type="number" class="form-control" name="mobile" value="">
							</div>
						</div>
						
						<div class="col-md-6">
							<div class="form-group">
								<label for="">Address Line</label> 
								<input type="text" class="form-control" name="addressLine" value="">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="">AddressLandmark</label> 
								<input type="text" class="form-control" name="AddressLandmark" value="">
							</div>
						</div>
						
						<div class="col-md-4">
							<div class="form-group">
								<label for="city">City</label> 
								<input type="text" class="form-control" name="city" value="">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="State">State</label> 
								<input type="text" class="form-control" name="state" value="">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="city">Pincode</label> 
								<input type="number" class="form-control" name="pincode" value="">
							</div>
						</div>
						<!-- /.box-body -->
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Update</button>
							<button type="button" class="btn btn-danger">Cancel</button>
						</div>
					</div>
				</form>
				
				<div class="box-header with-border">
					<h3 class="box-title">Update Educational Details</h3>
				</div>
				<form role="form" action="" method="post">
				
					<div class="col-md-6">
							<div class="form-group">
								<label for="institute">Institute</label> 
								<input type="number" class="form-control" id="institute" value="">
							</div>
					</div>
					<div class="col-md-6">
							<div class="form-group">
								<label for="university">University</label> 
								<input type="text" class="form-control" id="university" value="">
							</div>
					</div>
					<div class="col-md-6">
							<div class="form-group">
								<label for="syear">Start Year</label> 
								<input type="number" class="form-control" id="syear" value="">
							</div>
					</div>
					<div class="col-md-6">
							<div class="form-group">
								<label for="eyear">End Year</label> 
								<input type="number" class="form-control" id="eyear" value="">
							</div>
					</div>
					
						
				
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Update</button>
					<button type="button" class="btn btn-danger">Cancel</button>
				</div>
				</form>
				
				
				
				
				<div class="box-header with-border">
					<h3 class="box-title">Update resume</h3>
				</div>
				<form role="form" action="" method="post" enctype="multipart/form-data">
				<div class="col-md-4">
					<div class="form-group">
						<label for="resume">Upload Resume</label>
						<input type="file" id="resume" />
						</div></div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Update</button>
					<button type="button" class="btn btn-danger">Cancel</button>
				</div>
				</form>
				
				<div class="box-header with-border">
					<h3 class="box-title">Update Profile Photo</h3>
				</div>
				<form role="form" action="" method="post" enctype="multipart/form-data">
				<div class="col-md-4">
					<div class="form-group">
						<label for="photo">Upload Photo</label>
				<input type="file" id="photo"/>
				</div></div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Update</button>
					<button type="button" class="btn btn-danger">Cancel</button>
				</div>
				</form>
			</div>
		</div>
	</div>
</section>