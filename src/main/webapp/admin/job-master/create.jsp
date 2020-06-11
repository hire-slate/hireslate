<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<section class="content-header">
	<h1>Job Master</h1>

</section>
<!-- Main content -->
<section class="content">

	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Create New Job</h3>
				</div>

				<form role="form" action="/admin/job-master/create" method="post" onSubmit="return validationCheck()">
					<div class="box-body">

						<div class="row">

							<div class="col-md-3">
								<div class="form-group">
									<label for="skillName">Job Title</label>
									<input type="text" class="form-control" name="jobTitle" placeholder="Enter Job Name" required="required">
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label for="skillName">Job Type</label> 
									<select class="form-control select2" name="jobTypeId" style="width: 100%;" required="required">
											<option value="0">Select Job Type</option>
										<c:forEach items="${jobType}" var="variable">
											<option value="${variable.jobTypeId}">${variable.jobTypeName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
		 					<div class="col-md-3">
								<div class="form-group">
									<label>Opening Date:</label>
									<div class="input-group date">
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
										<input type="date" class="form-control pull-right" id="openingDate" name="jobOpeningDate" required="required">
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Closing Date:</label>
									<div class="input-group date">
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
										<input type="date" class="form-control pull-right" id="closingDate" name="jobClosingDate" required="required">
									</div>
									<div id="errorMsg" style="display: none"><small style="color: red">Opening date must less then closing</small></div>
								</div>
							</div>

						</div>
						
						<div class="row">
							
							<div class="col-md-6">
								<div class="form-group">
									<label for="skillName">Job Description</label>
									<textarea name="jobDescription" required="required"></textarea>
									<script>
										CKEDITOR.replace('jobDescription')
									</script>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="skillName">Job Benefits</label>
									<textarea name="jobBenefits" required="required"></textarea>
									<script>
										CKEDITOR.replace('jobBenefits')
									</script>
								</div>
							</div>
						
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label>Job Salary</label> 
									<input class="form-control" type="number" name="jobSalary" placeholder="Enter Job Salary">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Job Skills</label> 
									<select class="form-control select2" id="jobSkills" multiple="multiple" name="jobSkills" required="required">
										<c:forEach items="${skill}" var="variable">
											<option value="${variable.skillId}">${variable.skillName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label for="skillName">Vacancy</label>
									<input type="text" class="form-control" name="jobVacancy" placeholder="Enter Vacancy">
								</div>
							</div>
						</div>
						<div class="form-group">
							<button type="submit" id="btnSubmit" class="btn btn-primary">Create Steps</button>
							<a href="/admin/job-master"><button type="button" id="btnCancel" class="btn btn-danger">Cancel</button></a>
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
	});

	function validationCheck(){
		if($("#openingDate").val() > $("#closingDate").val()){
			$("#errorMsg").css("display","flex");			
			return false;
		}
	}
</script>



