<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<section class="content-header">
	<h1>User Profile</h1>
</section>

<section class="content">

	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Update Basic Details</h3>
				</div>
				<form role="form" action="/user/updatebasic" method="post">
					<div class="box-body">
						<div class="col-md-4">
							<div class="form-group">
								<input type="hidden" name="userId" value="">
								<label for="firstName">First Name</label> <input type="text" class="form-control" name="firstName" value="${firstName}">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="middleName">Middle Name</label> <input type="text"
									class="form-control" name="middleName" value="${middleName}">
							</div>
						</div>
						<div class="col-md-4">
							<div class="f
							orm-group">
								<label for="lastName">Last Name</label> <input type="text"
									class="form-control" name="lastName" value="${lastName}">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="username">Username</label> 
								<input type="text" class="form-control" name="userName" value="${username}" required="required">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="password">Password</label> 
								<input type="password" class="form-control" name="password" required="required">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="cpassword">Confirm Password</label> 
								<input type="password" class="form-control" name="cPassword" required="required">
							</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Update</button>
							<button type="button" class="btn btn-danger">Cancel</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Update Contact Details</h3>
				</div>
				<form role="form" action="user/updatecontact" method="post">
				<input type="hidden" name="userId" value="">
					<div class="box-body">
						<div class="col-md-6">
							<div class="form-group">
								<label for="email">Email Address</label> 
								<input type="email" class="form-control" name="email" value="${email}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="mobile">Mobile Number</label> 
								<input type="number" class="form-control" name="mobile" value="${mobileNumber}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="addressLine">Address Line</label> 
								<input type="text" class="form-control" name="addressLine" value="${addressLine}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="addressLandmark">Address Landmark</label> 
								<input type="text" class="form-control" name="addressLandmark" value="${addressLandmark}">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="city">City</label> 
								<input type="text" class="form-control" name="city" value="${city}">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="State">State</label> 
								<input type="text" class="form-control" name="state" value="${state}">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="city">Pincode</label> 
								<input type="number" class="form-control" name="pincode" value="${pincode}">
							</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Update</button>
							<button type="button" class="btn btn-danger">Cancel</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Update Educational Details</h3>
				</div>
				<form role="form" action="user/updateeducation" method="post">
				<input type="hidden" name="userId" value="">
					<div class="box-body">
						<div class="col-md-6">
							<div class="form-group">
								<label for="institute">Institute</label> 
								<input type="text" class="form-control" name="institute" value="${institute}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="university">University</label> 
								<input type="text" class="form-control" name="university" value="${university}">
							</div>
						</div>
						<div class="col-md-6">
								<div class="form-group">
									<label for="syear">Start Year</label> 
									<input type="number" class="form-control" name="syear" value="${startYear}">
								</div>
						</div>
						<div class="col-md-6">
								<div class="form-group">
									<label for="eyear">End Year</label> 
									<input type="number" class="form-control" name="eyear" value="${endYear}">
								</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Update</button>
							<button type="button" class="btn btn-danger">Cancel</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">			
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Update resume</h3>
				</div>
				<form role="form" action="user/uploadresume" method="post" enctype="multipart/form-data">
				<input type="hidden" name="userId" value="">
					<div class="box-body">
						<div class="col-md-4">
							<div class="form-group">
								<label for="resume">Upload Resume</label>
								<input type="file" name="resume" />
							</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Update</button>
							<button type="button" class="btn btn-danger">Cancel</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-6">
			<div class="box box-primary">
					<h3 class="box-title">Update Profile Photo</h3>
				</div>
				<form role="form" action="user/uploadphoto" method="post" enctype="multipart/form-data">
					<div class="box-body">
						<div class="col-md-4">
							<div class="form-group">
								<label for="photo">Upload Photo</label>
								<input type="file" name="photo"/>
							</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Update</button>
							<button type="button" class="btn btn-danger">Cancel</button>
						</div>
					</div>
				</form>
			</div>
		</div>
</section>