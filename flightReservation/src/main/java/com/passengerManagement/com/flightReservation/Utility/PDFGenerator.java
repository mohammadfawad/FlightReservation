package com.passengerManagement.com.flightReservation.Utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.passengerManagement.com.flightReservation.Entity.Reservation;

@Component
public class PDFGenerator {
	
	private static final Logger pdfLOGGER =LoggerFactory.getLogger(PDFGenerator.class);
	
	public void generateItinerary(Reservation reservation, String filePath) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			document.add(this.generateTable(reservation));
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			PDFGenerator.pdfLOGGER.info("Method:generateItinerary()->PDF Exception!"+e.toString());
			e.printStackTrace();
		}
	}
	
	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable pdfPTable = new PdfPTable(12);
		PdfPCell pdfCell;

		pdfCell = new PdfPCell(new Phrase("CheckIn Completed"));
		pdfCell.setColspan(12);
		pdfPTable.addCell(pdfCell);
		
		pdfCell = new PdfPCell(new Phrase("Reservation Details"));
		pdfCell.setColspan(12);
		pdfPTable.addCell(pdfCell);
		pdfPTable.addCell("Reservation ID");
		pdfPTable.addCell(reservation.getReservationId().toString());
		pdfPTable.addCell("CheckIn Status");
		pdfPTable.addCell(reservation.getReservationCheckedIn().toString());
		pdfPTable.addCell("Number of Bags");
		if(reservation.getReservationNumberOfBags()== null) {
			reservation.setReservationNumberOfBags(0);
			}
		pdfPTable.addCell(reservation.getReservationNumberOfBags().toString());
		pdfPTable.addCell("Date of Reservation");
		pdfPTable.addCell(reservation.getCreated().toString());
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		
		pdfCell = new PdfPCell(new Phrase("Passenger Details"));
		pdfCell.setColspan(12);
		pdfPTable.addCell(pdfCell);
		pdfPTable.addCell("PassengerId");
		pdfPTable.addCell(reservation.getReservationPassengerId().getPassengerId().toString());
		pdfPTable.addCell("FirstName");
		pdfPTable.addCell(reservation.getReservationPassengerId().getPassengerFirstName());
		pdfPTable.addCell("LastName");
		pdfPTable.addCell(reservation.getReservationPassengerId().getPassengerLastName());
		pdfPTable.addCell("MiddleName");
		pdfPTable.addCell(reservation.getReservationPassengerId().getPassengerMiddleName());
		pdfPTable.addCell("Email");
		pdfPTable.addCell(reservation.getReservationPassengerId().getPassengerEmail());
		pdfPTable.addCell("Phone");
		pdfPTable.addCell(reservation.getReservationPassengerId().getPassengerPhone());
		
		pdfCell = new PdfPCell(new Phrase("Flight Details"));
		pdfCell.setColspan(12);
		pdfPTable.addCell(pdfCell);
		pdfPTable.addCell("FlightNumber");
		pdfPTable.addCell(reservation.getReservationFlightId().getFlightNumber().toString());
		pdfPTable.addCell("OperatingAirlines");
		pdfPTable.addCell(reservation.getReservationFlightId().getOperatingAirlines().toString());
		pdfPTable.addCell("DepartureCity");
		pdfPTable.addCell(reservation.getReservationFlightId().getDepartureCity().toString());
		pdfPTable.addCell("ArrivalCity");
		pdfPTable.addCell(reservation.getReservationFlightId().getArrivalCity().toString());
		pdfPTable.addCell("DateOfDeparture");
		pdfPTable.addCell(reservation.getReservationFlightId().getDateOfDeparture().toString());
		pdfPTable.addCell("EstimatedDepartureTime");
		pdfPTable.addCell(reservation.getReservationFlightId().getEstimatedDepartureTime().toString());
		
		pdfCell = new PdfPCell(new Phrase("CheckIn 4 hours before Estimated Flight Departure Time \n Extra Bags will be charged heavily according to International Rates!"));
		pdfCell.setColspan(12);
		pdfPTable.addCell(pdfCell);
		
		return pdfPTable;
	}
}
