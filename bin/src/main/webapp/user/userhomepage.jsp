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

			<div class="row" data-name="">
				<a href="#" id="amit">"${variable}"</a>
				
					<div class="col-md-12 ftco-animate">
						<div
							class="job-post-item py-4 d-block d-lg-flex align-items-center">
							<div class="one-third mb-4 mb-md-0">
								<div class="job-post-item-header d-flex align-items-center">
									<h2 class="mr-3 text-black">
										
									</h2>
									<div class="badge-wrap">
										<span class="bg-primary text-white badge py-2 px-3">Partime</span>
									</div>
								</div>
								<div class="job-post-item-body d-block d-md-flex">
									<div class="mr-3">
										<span class="icon-layers"></span> <a href="#">Facebook,
											Inc.</a>
									</div>
									<div>
										<span class="icon-my_location"></span> <span>Western
											City, UK</span>
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
								<!-- end -->
			</div>

		</div>
	</section>

</div>
<script>
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
			//	alert(result);
				$("#amit").html(result);
			},
			error : function(response) {
			//	alert(response);
				$("#amit").html(response);
			}
		});
	}
</script>

<script>
	/* var request;  
	 function callJobs()  
	 {  
	 var v=document.form.input.value;  
	 var url="/admin/job-master/search";  
	
	 if(window.XMLHttpRequest){  
	 request=new XMLHttpRequest();  
	 }  
	 else if(window.ActiveXObject){  
	 request=new ActiveXObject("Microsoft.XMLHTTP");  
	 }  
	
	 try  
	 {  
	 request.onreadystatechange=getInfo;  
	 request.open("GET",url,true);  
	 request.send(v);  
	 }  
	 catch(e)  
	 {  
	 alert("Unable to connect to server");  
	 }  
	 }  
	
	 function getInfo(){  
	 if(request.readyState==4){  
	 var val=request.responseText;  
	 document.getElementById('amit').innerHTML=val;  
	 }  
	 }  */
</script>
