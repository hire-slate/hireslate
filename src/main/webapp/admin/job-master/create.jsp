<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.hireslate.model.JobTypeMasterEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.hireslate.controller.JobTypeMasterController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
    <section class="content-header">
    <h1>
    	Job Master      
    </h1>
     
    </section>
    <!-- Main content -->
    <section class="content">
    
      <div class="row">
        <!-- left column -->
        <div class="col-md-12">
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Create New Job</h3>
            </div>
    
            <form role="form" action="/admin/job-master/create" method = "post">
              <div class="box-body">
              
              <div class="row">
              
              <div class="col-md-4">
                <div class="form-group">
                  <label for="skillName">Job Title</label>
                  <input type="text" class="form-control" name="skillName" placeholder="Enter Job Name">
                </div>
              <!-- /.box-body -->
            </div>

            <div class="col-md-3">
                <div class="form-group">
                  <label for="skillName">Job Type</label>

                </div>
              <!-- /.box-body -->
            </div>
            <div class="col-md-1">
                <div class="form-group">
                  <label for="skillName">Vacancy</label>
                  <input type="text" class="form-control" name="skillName" placeholder="Select Job Type">
                </div>
              <!-- /.box-body -->
            </div>
            <div class="col-md-2">
                <div class="form-group">
                <label>Opening Date:</label>

                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input type="text" class="form-control pull-right" id="date" name="openDate">
                </div>
              </div>
		
              
              <!-- /.box-body -->
            </div>

            <div class="col-md-2">
              

              <div class="form-group">
                <label>Closing Date:</label>

                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input type="text" class="form-control pull-right" id="date" name="closeDate">
                </div>
              </div>
            </div>
            
          </div>
          <div class = "row">
            <div class="col-md-6">
              <div class="form-group">
                  <label for="skillName">Job Description</label>
                  <textarea name="editor1"></textarea>
                <script>
                       CKEDITOR.replace( 'editor1')
                </script>  
                  
            </div>
          
            </div>
              <div class="col-md-6">
              <div class="form-group">
                  <label for="skillName">Job Benefits</label>
                  <textarea name="editor2"></textarea>
                <script>
                       CKEDITOR.replace( 'editor2')
                </script>  
          
          </div>
        </div>
        </div>
              <div class="form-group">
                <button type="submit" class="btn btn-primary">Create</button>
                <button type="button" class="btn btn-danger">Cancel</button>
              </div>
              
              
            </form>

          </div>
          <!-- /.box -->

          <!-- Form Element sizes -->
          <!-- /.box -->

          <!-- /.box -->

          <!-- Input addon -->
          
          <!-- /.box -->	

        </div>
        <!--/.col (left) -->
        <!-- right column -->
        <!--/.col (right) -->
      </div>
      <!-- /.row -->
    </section>
    <script>

$(function () {
    //Initialize Select2 Elements
    $('.select2').select2()
})
</script>    
      
    

