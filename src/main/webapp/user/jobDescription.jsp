 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
	
	<div class="row">
		<div class="col-md-1">
		</div>
		<div class="col-md-10">
			<div class="row">
				<div class="col-md-12">
					<div class="box box-primary">
					 	<div class="box-header with-border">
            		 		<div class="row" style="padding-left: 10px">
	            		 	 	<div class="col-md-8">
							 		<p style="font-size: 20px"><strong>${jobEntity["Job_Title"]}</strong></p>
	            		 			<p>${jobEntity["Company_Name"]}</p>
	            		 			<ul style="list-style-type: none; padding: unset;">
							 			<li style="float: left; margin-left: 0px; margin-right: 20px" id="companyName">${jobEntity["Job_Type_Name"]}</li>
		            		 			<li style="float: left; margin-left: 0px; margin-right: 20px" id="jobTypeName">${jobEntity["Job_Vacancy"] }</li>
		            		 			<li style="float: left; margin-left: 0px; margin-right: 20px" id="jobTypeName">${jobEntity["Job_Salary"] }</li>
		            		 			<li style="float: left; margin-left: 0px; margin-right: 20px" id="cityName"><i class="fa fa-fw fa-map-marker"></i> ${jobEntity["Company_City"] }</li>
		            		 			<li class="spacer" style="clear: both"></li>
	            		 			</ul>
	            		 		</div>
 								<div class="col-md-3">
 									<input type="hidden" id="userId" name="userId" value="<%=session.getAttribute("userId") %>"/>
									<input type="hidden" name="jobId" id="jobId"/>
									<button class="btn btn-success" type="submit" style="margin-top: 15px; margin-left:10px; float: right">Apply For Job</button>
								</div>
            		 		</div>
						</div>            		 
     					<div class="row">
	     	       		 	<div class="box-body">
	            		 		<div class="box-header with-border">
	        	    		 		<p><strong>Responsibilities and Duties:</strong></p>
			       		 		</div>
								<div style="margin-left: 10px">
									${jobEntity["Job_Description"]}	
								</div>	
								<div class="box-header with-border">
									<p><strong>Qualifications:</strong></p>
								</div>
								<div style="margin-left: 10px">
									${jobEntity["Job_Benefits"]}
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section> 
