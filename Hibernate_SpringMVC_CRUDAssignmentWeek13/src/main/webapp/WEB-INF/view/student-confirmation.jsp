<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>Student Confirmation Page</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-container w3-center">

 <div class="w3-card-4 w3-center" style="width:40%" align="center">
	 
<header class="w3-container w3-teal">
  <h4>The student is confirmed: ${student.fullName}</h4>
</header>

	<ul>
		<c:forEach var="temp1" items="${student.department}">
		</c:forEach>
	</ul>
 Department:  ${student.department}	
	<ul>
		<c:forEach var="temp" items="${student.country}">	

		</c:forEach>
	</ul>
	Country:  ${student.country}
	</div>
</body>

</html>







