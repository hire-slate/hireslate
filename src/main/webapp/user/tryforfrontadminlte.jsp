<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<section class="content">
	<div class="mycustomclass" style="margin: auto">
		<div class="row">
			<form name="form">
				<div class="col-md-12">
					<div class="input-group input-group-sm"
						style="width: 500px; margin: auto; margin-bottom: 10px">
						<input type="text" name="input" class="form-control pull-right"
							placeholder="Search" value=" " onkeyup="callJobs()">
					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="searchresult" id="search"></div>
	<form id="oneCompany" method="Post" action="/user/job-apply" onsubmit="showMessage()">
		
		<input type="hidden" id="userId" name="userId" value="<%=session.getAttribute("userId") %>"/>
		<input type="hidden" name="jobId" id="jobId"/>
		<div class="row" style="margin: auto">
				
			<div class="col-md-2"></div>
			<div class="col-md-8 col-sm-6 col-xs-12">
		
				<div class="box" style="">
					<div class="row" style="position: relative; padding: 10px;">
						 	
			        	<div class="col-md-2">
			        		<img src="${pageContext.request.contextPath}/resources/dist/img/Logo-Design1.jpg" style="height: 70px;"/>
						</div>
						
						 
						<div class="col-md-7" style="padding-left: 10px">
								<label id="jobName" style="font-size: 20px; margin-bottom: 10px"></label> 
						 		<ul style="list-style-type: none; padding: unset;">
						 			<li style="float: left; margin-left: 0px; margin-right: 20px" id="companyName"></li>
		           		 			<li style="float: left; margin-left: 0px; margin-right: 20px" id="jobTypeName"></li>
		           		 			<li style="float: left; margin-left: 0px; margin-right: 20px" id="cityName"><i class="fa fa-fw fa-map-marker"></i></li>
		           		 			<li class="spacer" style="clear: both"></li>
		           		 		</ul>
		           		</div>
						<div class="col-md-3">
							<button class="btn btn-success" type="submit"  style="margin-top: 15px; margin-left:10px; float: right">Apply</button>
							<a id="link"><button class="btn btn-submit" style="margin-top: 15px;  float: right"><i class="fa fa-eye"></i></button></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<script>
		$("#oneCompany").hide(); 

		function showMessage(){
				alert("hi");
		}
		

		callJobs();
		function callJobs() {
			var skill  = document.form.input.value;
			var userId = $("#userId").attr("value");

			$.ajax({
				type : "POST",
				url : "/admin/job-master/search",
				data : JSON.stringify({"skill" : skill,"userId" : userId}),
				contentType : "application/json;charset=utf-8",
				dataType : "json",
				success : function(result) {

					for (i = 0; i < result.length; i++) {
						//console.log(result[i]);
						var x = $("#oneCompany").clone();
						x.removeAttr("id");
						x.addClass("oneCompany");
						x.attr("id","form"+result[i]);
						x.find("#link").attr("href","/user/jobDescription/"+result[i]);
						x.find("#jobId").attr("value",result[i]);
						i++;
						x.find("#jobName").html(result[i]);
						i++;
						x.find("#companyName").html(result[i]);
						i++;
						x.find("#cityName").append(result[i]);
						i++;
						x.find("#jobTypeName").append(result[i]);
						$(".searchresult").append(x);
					}
					$(".oneCompany").show();
				},
				error : function(response) {
					$("#jobName").html(response);
				}
			});
			document.getElementById("search").innerHTML = "";
		}
	</script>

</section>


