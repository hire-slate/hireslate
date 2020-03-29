<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content-header">
	<h1>Job Master</h1>
</section>

<section class="content">
	<div class="row">
		<div class="col-md-8">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Create Job Step</h3>
					<form role="form" action="" method="post">
						<div class="box-body">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="jobStepName">Name</label> <input type="text"
											class="form-control" name="jobStepName"
											placeholder="Enter job step name" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label>Date range:</label>

										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<input type="text" class="form-control pull-left"
												id="reservation" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary">Save and create new</button>
								<button type="submit" class="btn btn-primary">Finish</button>
								<button type="button" class="btn btn-danger">Cancel</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<script>
	$("#reservation").daterangepicker();
</script>