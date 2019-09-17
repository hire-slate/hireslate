<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<section class="content-header">
	<h1>Employee Master</h1>

</section>
<!-- Main content -->
<section class="content">

	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Create New Employee</h3>
				</div>

				<form role="form" action="/admin/employee-master/create" method="post">
					<div class="box-body">

						<div class="row">

							<div class="col-md-3">
								<div class="form-group">
									<label for="Company_Id">Company Name</label> 
									<div class="form-group">
									<select class="form-control select2" name="Company_Id" id ="companyId" style="width: 100%;">
										<c:forEach items="${companyId}" var="variable">
											  <option value="${variable.companyId}">${variable.companyName}</option>  
										</c:forEach>
									</select>
								</div>
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label for="User_Id">Job Type</label> 
									<select class="form-control select2" name="User_Id" id ="users" style="width: 100%;">
										<c:forEach items="${users}" var="variable">
											<option value="${variable.userId}">${variable.userFname} ${variable.userLname}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
					
					
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Create</button>
						<button type="button" class="btn btn-danger">Cancel</button>
					</div>
			</div>
			</form>
			</div>
		</div>
	</div>
	
</section>
<script>
	$(document).ready(function() {
		$('.select2').select2();
		$("#users").select2();
		$("#companyId").select2();
	});
</script>



