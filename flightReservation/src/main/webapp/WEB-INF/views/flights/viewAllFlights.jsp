<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Available Flights</title>
</head>
<body>
	<div align="center">
		<h1 align="center" style="color: #353535 ;">The Flight Reservation Web App</h1><br>
		<table  border="0" style=" colorbackground-color:#292929; color: #353535 ; margin-left:auto; margin-right:auto;">
				<thead>
					<tr>
						<th colspan="10" align="center">
							<h5>List Of Available Flights</h5>
						</th>
					</tr>
					<tr align="center">
						<td>flightId</td>
						<td>flightNumber</td>
						<td>operatingAirlines</td>
						<td>departureCity</td>
						<td>arrivalCity</td>
						<td>dateOfDeparture</td>
						<td>estimatedDepartureTime</td>
						<td>Update</td>
						<td>Delete</td>
						<td>Reserve</td>
					</tr>
				</thead>
					<tbody>
						<c:forEach items="${viewAllFlights}" var="flight">
							<tr align="center">
								<td>${flight.flightId}</td>
								<td>${flight.flightNumber}</td>
								<td>${flight.operatingAirlines}</td>
								<td>${flight.departureCity}</td>
								<td>${flight.arrivalCity}</td>
								<td>${flight.dateOfDeparture}</td>
								<td>${flight.estimatedDepartureTime}</td>
								<td><a href="updateFlight?flightId=${flight.flightId}">update</a></td>
								<td><a href="deleteFlight?flightId=${flight.flightId}">delete</a></td>
								<td><a href="flightReservationForm?flightId=${flight.flightId}">reserve</a></td>
							</tr>
						</c:forEach>
					</tbody>
				<tfoot align="center">
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
		<h3 align="center" style="color: #353535 ;"><h3>Add User and Search available Flights</h3></h3><br>
		<a href="userRegistrationForm"><h3>Create User</h3></a><br>
		<a href="loginShow"><h3>Login</h3></a><br>
		<a href="searchAgian"><h3>findFlights</h3></a><br>
	</div>
</body>
</html>