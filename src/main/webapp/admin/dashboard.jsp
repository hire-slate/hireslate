<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="content">

	<input type= "hidden" id="companyId" value="${sessionScope.companyId}"/> 
<div class="box hid" >
		<div class="box-body" >
		
				<div class="row">
						<div class= "col-md-12 jobTitle">
    					</div>
				</div>
				<div class="row">
						<div class="col-md-12 jobType">
						</div>
				</div>
				<div class="row">
						<div class= "col-md-12 jobClosingDate">
						</div>
				</div>
				<div class="row">
						<div class="col-md-12 jobVacancy">
						</div>
				</div>
		</div>
	</div>
	
</section>


<script>

var companyId = $("#companyId").val();
//$(".sho").show();
//$(".hid").hide();
$(document).ready(function(){
		$.ajax({
			type : 'POST',
			url : '/admin/job-master/searchByCompany',
			data: companyId,
			dataType: 'text',
			contentType : 'application/json; charset=utf-8',
			success: function(result){
						//console.log(result);
						var arr = $.parseJSON(result);
						var x = $(".box").clone();
						//x.removeClass("hid");
						//x.addClass("sho");
						x.find(".jobTitle").append(arr[0][0]);
						x.find(".jobType").html(arr[0][1]);
						x.find(".jobClosingDate").html(arr[0][2]);
						x.find(".jobVacancy").html(arr[0][3]);
						$(".content").append(x);
					}
		});
		
		//$(".hid:second").css('display','flex');
	})
	
</script>