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

				<form role="form" action="/admin/job-master/create" method="post">
					<div class="box-body">

						<div class="row">

							<div class="col-md-3">
								<div class="form-group">
									<label for="skillName">Job Title</label> 
									<input type="text" class="form-control" name="jobTitle" placeholder="Enter Job Name">
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label for="skillName">Job Type</label>
									  <select class="form-control select2" name="jobTypeId" style="width: 100%;">
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
										<input type="date" class="form-control pull-right" id="date"
											name="jobOpeningDate">
									</div>
								</div>


								<!-- /.box-body -->
							</div>

							<div class="col-md-3">


								<div class="form-group">
									<label>Closing Date:</label>

									<div class="input-group date">
										<div class="input-group-addon">
											<i class="fa fa-calendar"></i>
										</div>
										<input type="date" class="form-control pull-right" id="date"
											name="jobClosingDate">
									</div>
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="skillName">Job Description</label>
									<textarea name="jobDescription"></textarea>
									<script>
										CKEDITOR.replace('jobDescription')
									</script>

								</div>

							</div>	
							<div class="col-md-6">
								<div class="form-group">
									<label for="skillName">Job Benefits</label>
									<textarea name="jobBenefits"></textarea>
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
									<input class="form-control" type="number" name="jobSalary">	
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Job Skills</label>
									  <select class="form-control" id="jobSkills" multiple name="jobSkills[]" style="width: 100%;">
              						  		<c:forEach items="${skill}" var="variable">
              						  			<option value="${variable.skillId}">${variable.skillName}</option> 
              						  		</c:forEach>
              						  </select>
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label for="skillName">Vacancy</label> <input type="text"
										class="form-control" name="jobVacancy"
										placeholder="Select Job Type">
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
		$("#jobSkills").select2();
	});
</script>



