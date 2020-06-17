<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="org.springframework.expression.Expression" %>
<%@ page import="org.springframework.expression.ExpressionParser" %>
<%@ page import="org.springframework.expression.spel.standard.SpelExpressionParser" %> 
<section class="content-header">
	<h1>Job Master</h1>
</section>

<section class="content">
<div id="jobOpenDate" style="display: none">${jobOpeningDate}</div>
<div id="jobCloseDate" style="display: none">${jobClosingDate}</div>

	<div class="row">
		<div class="col-md-8">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Create Job Step</h3>
					<form role="form" action="/admin/job-steps/create/${jobId}" method="post">
						<div class="box-body">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="jobStepName">Name</label> <input type="text"
											class="form-control" name="jobStepName"
											placeholder="Enter job step name" required="required" />
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
												id="reservation" name="jobStepDates" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-group">
								<button type="submit" name="submit" value="save"
									class="btn btn-primary">Save and create new</button>
								<button type="submit" name="submit" value="finish"
									class="btn btn-primary">Finish</button>
								<button type="button" class="btn btn-danger">Cancel</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">${jobName}</h3>
				</div>

				<div class="box-body">
					<div class="row">
						<div class="col-md-12">
							<ul class="timeline timeline-inverse">
								<%int i =0; %>
								<c:forEach items="${jobStages}" var="variable">
									<c:set var="startDate" scope="request" value="${variable.stageStartDate}" />
									<c:set var="endDate" scope="request" value="${variable.stageEndDate}"> </c:set>
										<%
											Timestamp t1 = (Timestamp)request.getAttribute("startDate");
											Timestamp t2 = (Timestamp)request.getAttribute("endDate");
											String fromDate = new SimpleDateFormat("dd/MMM").format(t1);
											String toDate = new SimpleDateFormat("dd/MMM").format(t2);
										%>
									<li class="time-label">
										<span class="bg-red" id="stageDateData"><%=fromDate%> - <%=toDate%></span>
									</li>
									<li>
										<i class="fa bg-blue" id="stageNumberData"><%=++i%></i>
										<div class="timeline-item">
											<h3 class="timeline-header">
												<a href="#" id="stageNameData">${variable.stageName}</a>
											</h3>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script>
$("#reservation").daterangepicker({
	locale : {
		format : 'YYYY-MM-DD'
	},
	minDate : $("#jobOpenDate").html(),
	maxDate : $("#jobCloseDate").html(),
});


</script>