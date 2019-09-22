<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <section class="content-header" >
        <h1>
     		Job Master 
       </h1>
      </section>

    <!-- Main content -->
    <section class="content">
    <div class="box">
       <div class="box-body">
    	<div class = "row">
    		<div class= "col-md-1">
    			<a href="/admin/job-master/create/form"><button type=" button" class = "btn btn-block btn-primary" >Create</button></a>
    		</div>
    	</div>
      	<div class="row" style="margin-top: 20px">
        	<div class="col-xs-12">
          
             <table id="jobTable" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th style="width: 60px"><input type = "checkBox"></th>
				  <th style="width: 10px"><i class="fa fa-edit"></i></th>
				  <th style="width: 10px"><i class="fa fa-trash-o"></i></th>
                  <th style="width: 100px">Sr No.</th>
                  <th>Job Title</th>
				  <th>Job Type</th>
				  <th>Job Salary</th>
				  <th>Job Vacancy</th>
				  <th>Job Openings</th>
				  <th>Job Closing</th>
		        </tr>
                </thead>
               
               
               
                <tbody>
				<% int i = 0; %>                
                <c:forEach items="${jobMaster}" var="variable">
                <tr>
                    
                  <td><input type = "checkbox"></td>
                  <td><span ><a href="/admin/job-master/edit/${variable.jobId}"><i class="fa fa-edit"></a></i></span></td>
                  <td><span ><a href="/admin/job-master/delete/${variable.jobId}"><i class="fa fa-trash-o"></i></span></td>
               	  <td><%= ++i %></td>
                  <td>${variable.jobTitle}</td>
                  <td>${variable.jobTypeId}</td>
                  <td>${variable.jobSalary}</td>
                  <td>${variable.jobVacancy}</td>
                  <td>${variable.jobOpeningDate}</td>
				  <td>${variable.jobClosingDate}</td>
		        </tr>
                </c:forEach>
               
             </tbody>
           </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    
    <script>
		$(document).ready(function(){
			$("#jobTable").DataTable(
					{
					"scrollX":false,
					"scrollY":true
			});
		});
    </script>
    
   