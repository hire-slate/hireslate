<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="content"></section>
<input type="hidden" id="companyId" value="${sessionScope.companyId}" />

<div class="col-md-6 hid" style="display: none">
	<div class="box box-default collapsed-box">
		<div class="box-header with-border">
			<h2 class="box-title"></h2>
			
			<div class="box-tools pull-right" style="padding: 10px">
				<a href="#" id="link" style="padding-left: 10px">View Applicants</a>
				<button type="button" class="btn btn-box-tool" data-toggle="collapse" data-parent=".collapsed-box">
					<i class="fa fa-plus"></i>
				</button>
				
			</div>
		</div>
		<div class="collapse">
		<div class="box-body">

			<div class="row">

				<div class="col-md-3">
					<div class="box-title" style="padding-left: 10px">
						<b>Job Type: </b>
					</div>
				</div>
				<div class="col-md-9 jobType"></div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="box-title" style="padding-left: 10px">
						<b>Closing Date: </b>
					</div>
				</div>
				<div class="col-md-9 jobClosingDate"></div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="box-title" style="padding-left: 10px">
						<b>Vacancy: </b>
					</div>
				</div>
				<div class="col-md-9 jobVacancy"></div>
			</div>
			<div class="row">
				<div class="col-md-12">
					
				</div>
			</div>
		</div>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
</div>



<script>
var companyId = $("#companyId").val();
var today = new Date();
$(document).ready(function(){
		$.ajax({
			type : 'POST',
			url : '/admin/job-master/searchByCompany',
			data: companyId,
			dataType: 'text',
			contentType : 'application/json; charset=utf-8',
			success: function(result){
						var arr = $.parseJSON(result);
					
						for(y in arr){
							var x = $(".hid").clone();
							x.removeClass("hid");
							x.css("display","flex");
							x.find("h2.box-title").css("padding","10px");
							x.find("#link").attr("href","/admin/applicantsfor/"+arr[y]["Job_Id"]);
							x.find("h2.box-title").append(arr[y]["Job_Title"]);
							x.find(".jobType").append(arr[y]["Job_Type_Name"]);
							var date = new Date(arr[y]["Job_Closing_date"]);
							closingDays = Math.floor((date - today)/(60*24*60*1000));
							x.find(".jobClosingDate").append(date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getFullYear());
							x.find(".jobVacancy").append(arr[y]["Job_Vacancy"]);
							x.find(".collapse").attr("id","boxData"+y+"");
							x.find(".btn-box-tool").attr("href","#boxData"+y+"");
							$(".content").append(x);
						}
					}
		});

				
	})
	
</script>