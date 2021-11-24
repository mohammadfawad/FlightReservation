<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewAllRegisteredUsers</title>
</head>
<body>
	<div align="center">
		<h1 align="center" style="color: #353535 ;">The Flight Reservation Web App</h1><br>
		<table  border="0" style=" colorbackground-color:#292929; color: #353535 ; margin-left:auto; margin-right:auto;">
				<thead>
					<tr>
						<th colspan="6" align="center">
							<h5>List Of All Users</h5>
						</th>
					</tr>
					<tr align="center">
						<td>userId</td>
						<td>userFirstName</td>
						<td>userLastName</td>
						<td>UserEmail</td>
						<td>UserPassword</td>
						<td>Update</td>
						<td>Delete</td>
					</tr>
				</thead>
					<tbody>
						<c:forEach items="${listOfAllUsers}" var="user">
							<tr align="center">
								<td>${user.userId}</td>
								<td>${user.userFirstName}</td>
								<td>${user.userLastName}</td>
								<td>${user.userEmail}</td>
								<td>${user.userPassword}</td>
								<td><a href="updateUser?userId=${user.userId}">update</a></td>
								<td><a href="deleteUser?userId=${user.userId}">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				<tfoot align="center">
					<tr>
						<td colspan="6" align="center"><h6>@Copyrights Reserved</h6></td>
					</tr>
					
					<tr>
						<td colspan="6" align="center"><h6><hr></h6></td>
					</tr>
				</tfoot>
			</table>
	</div>
	<div align="center" style="color: #353535 ;">
		<h3 align="center" style="color: #353535 ;"><h3>Add User</h3><br>
		<a href="userRegistrationForm"><h3>Create User</h3></a><br>
		<a href="loginShow"><h3>Login</h3></a><br>
	</div>
	
</body>
</html>