<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


	<div class="container">
		<div class="row">
			<div class="offset-s3 col s8">

				<form class="center-align" action="OperatorController" method="post">
					<div class="row">
						<h3 class="center-align col s6">Call routing System</h3>
					</div>



					<div class="row">
						<div class="col s6">
							
							<font color="red">${msg}</font> <br> <input id="textbox"
								type="text" name="operatorName" placeholder="Name">
						</div>
					</div>
					<div class="row">
						<div class="col s2">
							<p>
					      <input name="group1" value="English" type="radio" id="test1" checked="checked" />
					      <label for="test1">English</label>
					    </p>
					    <p>
					      <input name="group1" type="radio" value="Hindi" id="test2" />
					      <label for="test2">Hindi</label>
					    </p>
						</div>
					</div>
					<div class="row">
							<div class="col s1">
							<input type="submit" class="waves-effect waves-light btn"
								value="add">
						</div>
					</div>
				</form>
			</div>
			</div>
		</div>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
	<script src="./app.js"></script>
</body>
</html>