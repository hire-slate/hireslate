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
							placeholder="Search" value="" onkeyup="callJobs()">
					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="searchresult" id="search"></div>

	<div id="oneCompany" class="row" style="margin: auto">
		<div class="col-md-2"></div>
		<div class="col-md-8 col-sm-6 col-xs-12">

			<div class="box" style="">
				<div class="row" style="position: relative">
					<!-- 	
		        	<div class="co-md-2">
		        		<img src="${pageContext.request.contextPath}/resources/dist/img/Logo-Design1.jpg"/>
					</div>
					 -->
					<div class="col-md-8" style="margin-left: 10px">
						<label id="jobName" style="font-size: larger"></label> <span
							class="info-box-text" id="companyName"></span> <span
							class="info-box-text" id="cityName"></span> <span
							class="info-box-text" id="jobTypeName"></span>
					</div>
					<div class="col-md-3" style="margin: auto; height: 100%; border: solid" >
						<button class="btn btn-primary" style="">Apply Job</button>
					
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<script>
		$("#oneCompany").hide();
		callJobs();
		function callJobs() {
			var skill = document.form.input.value;
			console.log(skill);

			$.ajax({
				type : "POST",
				url : "/admin/job-master/search",
				data : JSON.stringify(skill),
				contentType : "application/json;charset=utf-8",
				dataType : "json",
				success : function(result) {

					for (i = 0; i < result.length; i++) {
						//console.log(result[i]);
						var x = $("#oneCompany").clone();
						x.removeAttr("id");
						x.addClass("oneCompany");
						x.find("#jobName").html(result[i]);
						i++;
						x.find("#companyName").html(result[i]);
						i++;
						x.find("#cityName").html(result[i]);
						i++;
						x.find("#jobTypeName").html(result[i]);
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


