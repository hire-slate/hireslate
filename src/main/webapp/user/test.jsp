<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
  <head>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/css/jquery.paginate.css">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/frontend/js/bootstrap.min.js"></script>
    
    <!-- Bootstrap -->

		 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    
	<script src="${pageContext.request.contextPath}/resources/frontend/js/jquery.paginate.js"></script>
		 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/frontend/cregister/css/style.css">
    
  </head>
  <body>

<!-- ********************* Header *******************************************-->


 	<!-- the code represent navbar -->
 	
<div class="container">
	<form action="">
	<ul  id="questionsbox" style="{ list-style-type: none;">
	<% int i = 0; 
		String name = "question"+i;
	%>
	<c:forEach items="${testQuestions}" var="variable">
	<li>
	<div class="boxBorder">
	
        <div class="row">
		<div class="col-md-12">
		<p class="question"><%= ++i %>.&nbsp;${variable.testQuestion}</p>
		</div>
		<%name= "question"+i;%>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<p class="answer">A. <input type="radio" name=<%=name %> value="1">&nbsp;${variable.testAnswerOption1}</p>
		</div>	
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<p class="answer">B. <input type="radio" name=<%=name %> value="2">&nbsp;${variable.testAnswerOption2}</p>
		</div>	
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<p class="answer">C. <input type="radio" name=<%=name %> value="3">&nbsp;${variable.testAnswerOption3}</p>
		</div>	
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<p class="answer">D. <input type="radio" name=<%=name %> value="4">&nbsp;${variable.testAnswerOption4}</p>
		</div>	
	</div>
	
</div>
</li>
 </c:forEach>
 </ul>
 <input class = "btn btn-primary" type="submit" name="testSubmit" value="submit"/>
 </form>
</div>

    
    <script type="text/javascript">
    $('#questionsbox').paginate({

    	  // how many items per page
    	  perPage:                1,      

    	  // boolean: scroll to top of the container if a user clicks on a pagination link        
    	  autoScroll:             true,           

    	  // which elements to target
    	 // scope:                  '',         

    	  // defines where the pagination will be displayed    
    	  paginatePosition:       ['bottom'],     

    	  // Pagination selectors
    	  //containerTag:           'nav',
    	  //paginationTag:          'ul',
    	  //itemTag:                'li',
    	  //linkTag:                'a',

    	  // Determines whether or not the plugin makes use of hash locations
    	  useHashLocation:        true,               	  
    	});
    </script>
  </body>
</html>