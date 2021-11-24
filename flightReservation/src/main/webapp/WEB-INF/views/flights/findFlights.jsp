<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find Flights</title>
</head>
<body>
	<div align="center">
		<form action="findFlights" method="post">
				<table>
					<thead>
						<tr>
							<th></th>
							<th><h2>find Flights</h2></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>From Where</td>
							<td><input id="departureCity" name="departureCity" type="text" /></td>
						</tr>
						<tr>
							<td>To Destination</td>
							<td><input id="arrivalCity" name="arrivalCity" type="text" /></td>
						</tr>
						<tr>
							<td>Departure Date</td>
							<td><input id="dateOfDeparture" name="dateOfDeparture" type="text" placeholder="dd.mm.yyyy"/></td>
						</tr>
						<tr>
							<td></td>
							<td><input id="submit" name="submit" type="submit"  value="search"/></td>
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
							<td><a href="viewAllFlights"><h3>viewAllFlights</h3></a></td><br>
						</tr>
					</tfoot>
				</table>
			</form>
	</div>
</body>
</html>