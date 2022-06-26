<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Student Registration Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-container w3-center">
	
 <div class="w3-card-4 w3-center" style="width:50%">
 
 <header class="w3-container w3-teal">
  <h1>Student Update form</h1>
</header>
	<form:form action="processUpdateForm" method="GET" modelAttribute="student"  >
		<br>
		Full name: <form:input path="fullName"  />
	
		<form:input type="hidden" path="id" />
		
		<br>
		<br>
	
		Country:
		India <form:radiobutton path="country" value="India" />
		Canada <form:radiobutton path="country" value="Canada" />
		USA <form:radiobutton path="country" value="USA" />
		New Zealand <form:radiobutton path="country" value="New Zealand" />

		<br>
		<br>

		Operating Systems:
		
		B.Tech <form:radiobutton path="department" value="B.Tech" />
		B.Arch <form:radiobutton path="department" value="B.Arch" />
		B.Com <form:radiobutton path="department" value="B.Com" />

		<br>
		
<p>
		<input class="w3-button w3-section w3-teal w3-ripple" type="submit" value="Submit" />
</p>
	</form:form></div>
</body>
</html>












