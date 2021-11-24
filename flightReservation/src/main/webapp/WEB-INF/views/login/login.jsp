<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
	<div align="center">
		<form action="login" method="post">
				<table>
					<thead>
						<tr>
							<th></th>
							<th><h2>User Login Form</h2></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>User Email</td>
							<td><input id="userEmail" name="userEmail" type="email" /></td>
						</tr>
						<tr>
							<td>User Password</td>
							<td><input id="userPassword" name="userPassword" type="password" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input id="submit" name="submit" type="submit"  value="login"/></td>
						</tr>
					</tbody>
					<tfoot>
					<tr>
						<td></td>
						<td><i>${alert}</i></td>
					</tr>
						<tr>
							<td></td>
							<td><a href="viewAllRegisteredUsers"><h3>ViewAllRegisteredUsers</h3></a></td><br>
						</tr>
					</tfoot>
				</table>
			</form>
	</div>
</body>
</html>