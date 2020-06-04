<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<section class="content-header">
	<h1>Company Profile</h1>
</section>

<section class="content">

	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Update Basic Details</h3>
				</div>
				<form role="form" action="/user/company/update-company-basic" method="post">
					<div class="box-body">
						<div class="col-md-6">
							<div class="form-group">
								<label for="companyName">Company Name</label> 
								<input type="text" class="form-control" name="companyName" value="${companyName}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="website">Website</label> 
								<input type="text" class="form-control" name="website" value="${cwebsite}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="password">Password</label> 
								<input type="password" class="form-control" name="password" value="${cpassword}" required="required">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="username">Confirm Password</label> 
								<input type="password" class="form-control" name="cpassword" value="${cpassword}" required="required">
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
				<form role="form" action="/user/company/update-company-contact" method="post">
					<div class="box-body">
						<div class="col-md-6">
							<div class="form-group">
								<label for="addressLine">Address Line</label> 
								<input type="text" class="form-control" name="addressLine" value="${caddressLine}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="addressLandmark">Address Landmark</label> 
								<input type="text" class="form-control" name="addressLandmark" value="${caddressLandmark}">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="city">City</label>
								<input type="text" class="form-control" name="city" value="${ccity}">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="pincode">Pincode</label>
								<input type="number" class="form-control" name="pincode" value="${cpincode}">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="pincode">Contact</label>
								<input type="text" class="form-control" name="contact" value="${ccontact}">
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
					<h3 class="box-title">Update Company Documents</h3>
				</div>
				<form role="form" action="/user/company/update-company-documents" method="post">
				
					<div class="box-body">
						<div class="col-md-6">
							<div class="form-group">
								<label for="pancard">Pancard</label> 
								<input type="text" class="form-control" name="pancard" value="${cpancard}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="gst">GSTIN</label> 
								<input type="text" class="form-control" name="gst" value="${gst}">
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
					<h3 class="box-title">Update Logo</h3>
				</div>
				<form role="form" action="/user/company/update-company-logo" method="post" enctype="multipart/form-data">
					<div class="box-body">
						<div class="col-md-4">
							<div class="form-group">
								<label for="logo">Upload Logo</label>
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
					<h3 class="box-title">Update Pancard</h3>
				</div>
				<form role="form" action="/user/company/update-company-pancard" method="post" enctype="multipart/form-data">
					<div class="box-body">
						<div class="col-md-4">
							<div class="form-group">
								<label for="pancard">Upload Pancard</label>
								<input type="file" name="pancard"/>
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