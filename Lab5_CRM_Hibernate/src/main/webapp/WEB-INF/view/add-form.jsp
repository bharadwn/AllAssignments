<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>

<title>Customer Relationship Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<!-- 
<body class="w3-container w3-center" align="center">
	
<div class="w3-card-4 w3-center" style="width:50%"> 
-->
<body class="w3-container w3-center w3-light-grey">
	<div class="w3-container w3-card-4  w3-margin w3-cell-middle w3-center"	style="width: 60%">

		<header class="w3-container w3-teal">
			<h1>Customer Registration form</h1>
		</header>
		<br>
		
		<form:form action="processForm" modelAttribute="customer" class="w3-container  w3-margin">

			<div class="w3-row w3-section">
				<div class="w3-col" style="width: 150px">First name:</div>
				<div class="w3-rest">

					<form:input class="w3-input w3-border" placeholder="First Name" path="firstName" />

				</div>
			</div>

			<br />

			<div class="w3-row w3-section">
				<div class="w3-col" style="width: 150px">Last name:</div>
				<div class="w3-rest">

					<form:input class="w3-input w3-border" placeholder="Last Name" path="lastName" />

				</div>
			</div>

			<br />

			<div class="w3-row w3-section">
				<div class="w3-col" style="width: 150px">Email:</div>
				<div class="w3-rest">

					<form:input class="w3-input w3-border" placeholder="Email" path="email" />

				</div>
			</div>

			<br />
			<p>
				<input class="w3-button w3-section w3-teal w3-ripple" type="submit"	value="Submit" />
			</p>
		</form:form>
		<div>
			<a href="<%=request.getContextPath()%>/list">Back to the List</a>
		</div>
	</div>	
</body>
</html>












