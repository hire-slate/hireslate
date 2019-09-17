<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<section class="content-header">
      <h1>
        Stream Master
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
              <h3 class="box-title">Create New Stream</h3>
            </div>
    
            <form role="form" action="/admin/stream-master/create" method = "post">
              <div class="box-body">
              <div class="col-md-8">
                <div class="form-group">
                  <label for="streamName">Stream Name</label>
                  <input type="text" class="form-control" name="streamName" placeholder="Enter Stream">
                </div>
              <!-- /.box-body -->
				</div>
				<div class="col-md-4">
					<div class="form-group">
                  		<label for="courseId">Course Name</label>
                  		<select class="form-control select2" name="courseId">
                  			<c:forEach items="${courses}" var="variable">
                  				<option value="${variable.courseId}">${variable.courseName}</option>
                  			</c:forEach>
                		</select>	
                  	</div>
				</div>
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
    
    <script>

    $(document).ready(function () {
        $('.select2').select2();
    });


    </script>