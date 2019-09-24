<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->

		 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    
		 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/cregister/css/style.css">
    
  </head>
  <body>

<!-- ********************* Header *******************************************-->


 	<!-- the code represent navbar -->
 	
<div class="container">
	<form action="">
	<% int i = 0; %>
	<c:forEach items="${testQuestions}" var="variable">
	<div class="boxBorder">
        <div class="row">
		<div class="col-md-12">
		<p class="question"><%= ++i %>.&nbsp;${variable.testQuestion}</p>
		</div>
		
	</div>
	<div class="row">
		<div class="col-md-12">
			<p class="answer">A. <input type="radio" name="question"+i value="1">${variable.testAnswerOption1}</p>
		</div>	
	</div>
	<div class="row">
		<div class="col-md-12">
			<p class="answer">A. <input type="radio" name="question"+i value="2">${variable.testAnswerOption2}</p>
		</div>	
	</div>
	<div class="row">
		<div class="col-md-12">
			<p class="answer">A. <input type="radio" name="question"+i value="3">${variable.testAnswerOption3}</p>
		</div>	
	</div>
	<div class="row">
		<div class="col-md-12">
			<p class="answer">A. <input type="radio" name="question"+i value="4">${variable.testAnswerOption4}</p>
		</div>	
	</div>
</div>
 </c:forEach>
 <input type="submit" name="testSubmit" value="submit"/>
 </form>
</div>



    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/frontend/js/bootstrap.min.js"></script>
  </body>
</html>