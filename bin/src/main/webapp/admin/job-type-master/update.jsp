<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <section class="content-header">
      <h1>
        Job Type Master
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
              <h3 class="box-title">Update Job Type</h3>
            </div>
    
            <form role="form" action="/admin/job-type-master/update" method = "post">
              <div class="box-body">
              <div class="col-md-6">
                <div class="form-group">
                  <input type="hidden" name="jobTypeId" value="${jobTypeById.jobTypeId}">
                  <label for="skillName">Job Type Name</label>
                  <input type="text" class="form-control" name="jobTypeName" placeholder="Enter Job Type" value="${jobTypeById.jobTypeName }">
                </div>
              <!-- /.box-body -->

              <div class="form-group">
                <button type="submit" class="btn btn-primary">Update</button>
                <button type="button" class="btn btn-danger">Cancel</button>
              </div>
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
    