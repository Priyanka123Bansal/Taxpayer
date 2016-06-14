<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">

<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<!-- for pagination -->
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="resources/js/loginValidator.js"></script>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<!-- Fixed navbar -->
		<div class="container">

			<div class="navbar-collapse collapse">
				<ul id="nav-header" class="nav navbar-nav">
					<br />
					<font style="font-size: 20px; color: #337ab7;"> Tax Payee
						Information Web Site</font>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<br />

					<b>Welcome Guest User</b>

				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>


	<div class="col-md-8">
		<div class="col-sm-offset-5 col-sm-8">

			<form id="taxform" action="taxpayer/submit" method="post">

				<div class="form-group">
					<div style="color: Black;">
						Name: <em>*</em>
					</div>
					<input type="text" name="userName" class="form-control" />
				</div>

				<div class="form-group">
					<div style="color: Black;">
						Address: <em>*</em>
					</div>
					<input type="text" name="address" class="form-control" />
				</div>

				<div class="form-group">
					<div style="color: Black;">
						Pan: <em>*</em>
					</div>
					<input type="text" name="pan" class="form-control" />
				</div>

				<div class="form-group">
					<div style="color: Black;">
						DateOfBirth: <em>*</em>
					</div>
					<input type="text" name="dob" class="form-control"
						placeholder="dd-mm-yyyy" />
				</div>

				<div class="form-group">
					<div style="color: Black;">
						Assessment Year: <em>*</em>
					</div>
					<input type="text" name="ayear" class="form-control"
						placeholder="yyyy-yyyy" />
				</div>

				<div class="form-group">
					<div style="color: Black;">
						Income: <em>*</em>
					</div>
					<input type="text" name="income" class="form-control" />
				</div>

				<div class="form-group">
					<div style="color: Black;">
						TDS: <em>*</em>
					</div>
					<input type="text" name="tds" class="form-control" />
				</div>

				<div class="form-group">
					<div style="color: Black;">
						Tax Deducted: <em>*</em>
					</div>
					<input type="text" name="taxdeducted" class="form-control" />
				</div>

				<%
					if (request.getParameter("message") != null) {
				%>
				<div class="form-group">
					<div style="color: Red;"><%=request.getParameter("message")%></div>
				</div>
				<%
					}
				%>
				<div class="form-group">
					<div class="col-md-2"></div>
					<div class="col-md-4">
						<input type="submit" value="save"
							class="btn btn-primary btn-lg btn-block" />
					</div>
					<div class="col-md-4">
						<input type="button" value="cancel"
							class="btn btn-primary btn-lg btn-block" onclick="formReset()" />
					</div>
					<div class="col-md-4"></div>
				</div>


			</form>
		</div>
	</div>

	<script>
		function formReset() {
			document.getElementById("taxform").reset();
		}
	</script>
</body>
</html>
