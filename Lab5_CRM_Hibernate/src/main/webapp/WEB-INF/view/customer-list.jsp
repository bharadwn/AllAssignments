<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Customer List</title>

	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body  class="w3-light-grey"> 
	<!-- 	<div class="w3-card-4 w3-center" style="width: 80%" align="center">
 -->
 
 <!-- Page Container -->
	<div class="w3-content w3-margin-top" style="max-width: 1400px;">

		<!-- The Grid -->
		<div class="w3-row-padding">


			<div class="w3-row ">
				<div class="w3-col w3-container m8 l9">
					<header class="w3-container w3-teal w3-center">
						<h2>CUSTOMER RELATIONSHIP MANAGEMENT</h2>
					</header>
					<hr />

					<div>
						<input type="button" value="Add Customer"
							onclick="window.location.href='showForm'; return false;" />
					</div>
					<br /> <br />

					<div class="w3-center" align="center" style="width: 80%">

						<!-- 		<div class="w3-row">  <div class="w3-col w3-container m8 l9">   -->

						<table class="w3-table-all w3-round w3-center ">
							<tr>
								<!-- <th>Sl.No</th> -->
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Choose Action</th>
							</tr>
							<tr>
								<!-- loop over and print our students -->
								<c:forEach var="custTemp" items="${customers}">

									<!-- construct an "update" link with student id -->
									<c:url var="updateLink" value="/updateForm">
										<c:param name="custid" value="${custTemp.id}" />
									</c:url>

									<!-- construct an "delete" link with student id -->
									<c:url var="deleteLink" value="/delete">
										<c:param name="custid" value="${custTemp.id}" />
									</c:url>

									<tr>
										<%-- <td>${studTemp.id}</td> --%>
										<td>${custTemp.firstName}</td>
										<td>${custTemp.lastName}</td>
										<td>${custTemp.email}</td>
										<td>
											<!-- display the update link --> <a
											class="w3-button w3-border w3-border-white w3-round w3-teal "
											href="${updateLink}"
											onclick="window.location.href='updateForm/${custTemp.id}'; return false;">Update</a>

											<a
											class="w3-button w3-border w3-border-white w3-round w3-teal"
											href="${deleteLink}"
											onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>

										</td>
									</tr>
								</c:forEach>
						</table>
					</div>
				</div>
			</div>


			<!-- End Grid -->
		</div>

		<!-- End Page Container -->
	</div>

	<footer class="w3-container w3-teal w3-center w3-margin-top">
		<p>
			Powered by <a href="https://www.w3schools.com/w3css/default.asp"
				target="_blank">w3.css</a>
		</p>
	</footer>
</body>
</html>