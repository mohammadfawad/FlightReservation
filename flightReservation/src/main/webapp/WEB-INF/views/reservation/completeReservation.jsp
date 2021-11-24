<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Completed Reservations</title>
</head>
<body>
	<div align="center">
		<h1 align="center" style="color: #353535 ;">The Flight Reservation Web App</h1><br>
		<table  border="0" style=" colorbackground-color:#292929; color: #353535 ; margin-left:auto; margin-right:auto;">
				<thead>
					<tr>
						<th colspan="10" align="center">
							<h5>List Of Reserved Seats</h5>
						</th>
					</tr>
					<tr align="center">
						<td>reservationId</td>
						<td>reservationCheckedIn</td>
						<td>reservationNumberOfBags</td>
						<td>created</td>
						<td>reservationPassengerId</td>
						<td>reservationFlightId</td>
						
						<td>Update</td>
						<td>Delete</td>
						
					</tr>
				</thead>
					<tbody>
							<tr align="center">
								<td>${completedReservations.reservationId}</td>
								<td>${completedReservations.reservationCheckedIn}</td>
								<td>${completedReservations.reservationNumberOfBags}</td>
								<td>${completedReservations.created}</td>
								<td>${completedReservations.reservationPassengerId.passengerId}</td>
								<td>${completedReservations.reservationFlightId.flightId}</td>
								
								<td><a href="updateReservation?reservationId=${completedReservations.reservationId}">update</a></td>
								<td><a href="deleteReservation?reservationId=${completedReservations.reservationId}">delete</a></td>
							</tr>
						
					</tbody>
				<tfoot align="center">
					<tr>
						<td colspan="10" align="center"><i>${alert}</i></td>
					</tr>
					<tr>
						<td colspan="10" align="center"><h6>@Copyrights Reserved</h6></td>
					</tr>
					
					<tr>
						<td colspan="10" align="center"><h6><hr></h6></td>
					</tr>
				</tfoot>
			</table>
	</div>
	<div align="center" style="color: #353535 ;">
		<h3 align="center" style="color: #353535 ;">Add User and Search available Flights</h3><br>
		<a href="userRegistrationForm"><h3>Create User</h3></a><br>
		<a href="loginShow"><h3>Login</h3></a><br>
		<a href="searchAgian"><h3>findFlights</h3></a><br>
		
	</div>
</body>
</html>