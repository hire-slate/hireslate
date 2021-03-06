<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section class="content-header">
      <h1>
		Course Master
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
              <h3 class="box-title">Create New Course</h3>
            </div>
    
            <form role="form" action="/admin/course-master/create" method = "post">
              <div class="box-body">
              <div class="col-md-6">
                <div class="form-group">
                  <label for="skillName">Course Name</label>
                  <input type="text" class="form-control" name="courseName" placeholder="Enter Course">
                </div>
              <!-- /.box-body -->

              <div class="form-group">
                <button type="submit" class="btn btn-primary">Create</button>
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
    