<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>flightReservationForm</title>
</head>
<body>
	<h1>flightReservationForm</h1>
	<div align="center">
	<form action="completeReservation" method="post">
		<h1 align="center" style="color: #353535 ;">The Flight Reservation Web App</h1><br>
		<table  border="0" style=" colorbackground-color:#292929; color: #353535 ; margin-left:auto; margin-right:auto;">
				<thead>
					<tr>
						<th colspan="10" align="center">
							<h5>flightReservationForm</h5>
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
							<tr align="center">
								<td>${reserveFlight.flightId}</td>
								<td>${reserveFlight.flightNumber}</td>
								<td>${reserveFlight.operatingAirlines}</td>
								<td>${reserveFlight.departureCity}</td>
								<td>${reserveFlight.arrivalCity}</td>
								<td>${reserveFlight.dateOfDeparture}</td>
								<td>${reserveFlight.estimatedDepartureTime}</td>
								<td><a href="updateFlight?flightId=${reserveFlight.flightId}">update</a></td>
								<td><a href="deleteFlight?flightId=${reserveFlight.flightId}">delete</a></td>
								<td><a href="flightReservationForm?flightId=${reserveFlight.flightId}">reserve</a></td>
							</tr>
							<tr>
								<td colspan="5" align="center"><h5>Pessenger Details</h5></td>
								<td colspan="5"align="center"><h5>Card details</h5></td>
							</tr>
							<tr>
								<td>passengerFirstName <input id="passengerFirstName" name="passengerFirstName" type="text"/></td>
								<td>passengerLastName <input id="passengerLastName" name="passengerLastName" type="text"/></td>
								<td>passengerEmail <input id="passengerEmail" name="passengerEmail" type="text"/></td>
								<td>passengerPhone <input id="passengerPhone" name="passengerPhone" type="text"/></td>
								
								<td>NameOnCard <input id="nameOnCard" name="nameOnCard" type="text"/></td>
								<td>CardNo <input id="cardNo" name="cardNo" type="text"/></td>
								<td>ExpiryDate <input id="expiryDate" name="expiryDate" type="text"/></td>
								<td>SecurityCode <input id="securityCode" name="securityCode" type="text"/></td>								
							</tr>
							<tr>
								<td><input id="flightId" name="flightId" value="${reserveFlight.flightId}"  type="hidden"/></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><input id="confirm" name="confirm" value="confirm" type="submit"/></td>
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
		</form>
	</div>
	<div align="center" style="color: #353535 ;">
		<h3 align="center" style="color: #353535 ;">Add User and Search available Flights</h3><br>
		<a href="userRegistrationForm"><h3>Create User</h3></a><br>
		<a href="loginShow"><h3>Login</h3></a><br>
		<a href="searchAgian"><h3>findFlights</h3></a><br>
	</div>
</body>
</html>