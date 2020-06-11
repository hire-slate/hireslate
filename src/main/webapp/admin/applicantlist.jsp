<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<section class="content">
 	<div class="row">
		<c:forEach items="${candidates}" var="variable">
 		<div class="col-md-3">
   			<div class="box box-primary">
	        <!-- /.box-header -->
	        <img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath}/resources/dist/img/user4-128x128.jpg" alt="User profile picture">

              <h3 class="profile-username text-center">${variable.User_Fname} ${variable.User_Lname }</h3>

              <p class="text-muted text-center">Software Engineer</p>
	        
	            <div class="box-body box-profile">
	              <strong><i class="fa fa-book margin-r-5"></i>Education</strong>
	
	              <p class="text-muted">
	                ${variable.Course_Name} In ${variable.Stream_Name}
	              </p>
	
	              <hr>
	
	              <strong><i class="fa fa-map-marker margin-r-5"></i> Location</strong>
	
	              <p class="text-muted">${variable.User_City}, ${variable.User_State }</p>
	
	              <hr>
	
	              <strong><i class="fa fa-pencil margin-r-5"></i>LinkedIn</strong>
	
	              <p class="text-muted">${variable.Candidate_LinkedIn}</p>
	
	
	              <hr>
	
	              <strong><i class="fa fa-file-text-o margin-r-5"></i>Github</strong>
	
				<p class="text-muted">${variable.Candidate_GitHub}</p>
	            </div>
	            <!-- /.box-body -->
          	</div>
          </div>
          </c:forEach>
   	</div>
</section>