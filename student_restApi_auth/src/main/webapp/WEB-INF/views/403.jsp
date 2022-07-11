<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HTTP Status 403 - Access denied</h1>
	<h2>${msg}</h2>

	<div>


		<a class="w3-button w3-border w3-border-teal w3-right w3-white"
			href="<%=request.getContextPath()%>/logout"
			onclick="if (!(confirm('Are you sure you want to logout?'))) return false">${principalU}
			-Logout</a>

	</div>
	<div>
		<a href="<%=request.getContextPath()%>/list">Back to the MainPage</a>
	</div>

</body>
</html>