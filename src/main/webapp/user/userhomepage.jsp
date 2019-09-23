<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="hero-wrap js-fullheight">
	<div class="overlay"></div>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
				<form name="form">

					<div class="col-md-12">
						<input type="text" placeholder="Search.." name="input"
							onkeyup="callJobs()">
					</div>
				</form>

			</div>

			<div class="serchResult" id="serch">
					
			</div>
			
			<div class="col-md-12 ftco-animate" id="oneCompany">
					<div class="job-post-item py-4 d-block d-lg-flex align-items-center">
						<div class="one-third mb-4 mb-md-0">
							<div class="job-post-item-header d-flex align-items-center">
								<h2 class="mr-3 text-black">
									<a href="#" id="jobName"></a>
								</h2>
								<div class="badge-wrap">
									<span class="bg-primary text-white badge py-2 px-3">Partime</span>
								</div>
							</div>
							<div class="job-post-item-body d-block d-md-flex">
								<div class="mr-3">
									<span class="icon-layers"></span> <a href="#">Facebook, Inc.</a>
								</div>
								<div>
									<span class="icon-my_location"></span> <span>Western City, UK</span>
								</div>
							</div>
						</div>

						<div
							class="one-forth ml-auto d-flex align-items-center mt-4 md-md-0">
							<div>
								<a href="#"
									class="icon text-center d-flex justify-content-center align-items-center icon mr-2">
									<span class="icon-heart"></span>
								</a>
							</div>
							<a href="job-single.html" class="btn btn-primary py-2">Apply
								Job</a>
						</div>
					</div>
				</div>
			
	</section>

</div>
				
<script>
	function callJobs() {
		var skill = document.form.input.value;
		console.log(skill);
		$("#oneCompany").hide();
		
		$.ajax({
			type : "POST",
			url : "/admin/job-master/search",
			data : JSON.stringify(skill),
			contentType : "application/json;charset=utf-8",
			dataType : "json",
			success : function(result) {

				for (i in result) {
//					console.log(result[i]);
					document.getElementById("jobName").innerHTML = result[i];
					//var y = document.getElementById("jobName").innerHTML;
					//console.log(y);
					
					var x = document.getElementById("oneCompany").innerHTML;
					//console.log(x);
					
						$(".serchResult").append(x);
				
				}
				
			},
			
			error : function(response) {
				//	alert(response);
				$("#amit").html(response);
			}	
		
		});
		document.getElementById("serch").innerHTML = "";
	}

</script>


