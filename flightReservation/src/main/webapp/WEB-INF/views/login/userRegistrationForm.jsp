<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserRegisterationForm</title>
</head>
<body>
	<div align="center">
		<form action="registerUser" method="post">
			<table>
				<thead>
					<tr>
						<th></th>
						<th><h2>User Registration Form</h2></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>User FirstName</td>
						<td><input id="userFirstName" name="userFirstName" type="text" /></td>
					</tr>
					<tr>
						<td>User LastName</td>
						<td><input id="userLastName" name="userLastName" type="text" /></td>
					</tr>
					<tr>
						<td>User Email</td>
						<td><input id="userEmail" name="userEmail" type="email" /></td>
					</tr>
					<tr>
						<td>User Password</td>
						<td><input id="userPassword" name="userPassword" type="password" /></td>
					</tr>
					<tr>
						<td>Confirm Password</td>
						<td><input id="confirmPassword" name="confirmPassword" type="password" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input id="submit" name="submit" type="submit"  value="register"/></td>
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