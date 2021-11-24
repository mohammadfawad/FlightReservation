<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Flight reservation Application</title>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
<style>
body, html {
  height: 100%;
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.hero-image {
  background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("images/bannera.png");
  height: 50%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

.hero-text {
  text-align: center;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
}

.hero-text button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 10px 25px;
  color: black;
  background-color: #ddd;
  text-align: center;
  cursor: pointer;
}

.hero-text button:hover {
  background-color: #555;
  color: white;
}
</style>
</head>
<body style="background: #7fb3d5" >
		<div class="hero-image">
		  	<div class="hero-text">
		   		<h1 style="font-size:50px">Flight Reservation System</h1>
		    	<p><hr></p>
		    	<button disabled="disabled">WebApplication</button>
	  		</div> 
	  	</div>
		<div align="center">
			<hr>
			<table>
			<thead>
				<tr>
					<td colspan="3" align="center"><h2>Flight Reservation System</h2></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2">
						<img alt="image" src="images/allUser.png" height="400px" width="500px" style="border-bottom-left-radius: 15px; border-bottom-right-radius: 15px; border-top-right-radius: 15px; border-top-left-radius: 15px;">
					</td>
					<td>
						<a href="userRegistrationForm">
						<img alt="image" src="images/usertie.png" height="64px" width="64px" style="border-bottom-left-radius: 50px; border-bottom-right-radius: 50px; border-top-right-radius: 50px; border-top-left-radius: 50px;">
						<h3>Register</h3>
						</a><br>
						<a href="loginShow">
						<img alt="image" src="images/userLogin.png" height="64px" width="64px" style="border-bottom-left-radius: 50px; border-bottom-right-radius: 50px; border-top-right-radius: 50px; border-top-left-radius: 50px;">
						<h3>Login</h3>
						</a>
					</td>
				</tr>
			</tbody>
			<tfoot></tfoot>
		</table>
		</div>
</body>
</html>