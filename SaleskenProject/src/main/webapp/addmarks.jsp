
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./Base.jsp"%>
<title>Edit Marks</title>
</head>
<body style="background-color: #eee8ec">
	<div class="container mt-3" border=5px solid>
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1>Enter Subject RollNumber & Marks</h1>
				<form action="add-marks" method="post">
					<div class="form-group">
						<label>Roll Number</label> <input type="number"
							class="form-control" name="roll">
					</div>

					<div class="form-group">
						<label>Choose Semester</label> 
						 <select class="form-control" name="id">
  							  <option value="1">First</option>
   							 <option value="2">Second</option>
 						 </select>
					</div>
					
					<div class="form-group">
						<label>English-Marks</label> <input type="number"
							class="form-control" name="english">
					</div>
					
					<div class="form-group">
						<label>Maths-Marks</label> <input type="number"
							class="form-control" name="maths">
					</div>

					<div class="form-group">
						<label>Science-Marks</label> <input type="number"
							class="form-control" name="science">
					</div>
					<div class="container text-center">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>
			</div>

		</div>

	</div>
</body>
</html>