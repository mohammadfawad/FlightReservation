/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.passengerManagement.com.flightReservation.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author spring
 */
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(catalog = "flightreservation", schema = "")
@NamedQueries({ @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f"),
		@NamedQuery(name = "Flight.findByFlightId", query = "SELECT f FROM Flight f WHERE f.flightId = :flightId"),
		@NamedQuery(name = "Flight.findByFlightNumber", query = "SELECT f FROM Flight f WHERE f.flightNumber = :flightNumber"),
		@NamedQuery(name = "Flight.findByOperatingAirlines", query = "SELECT f FROM Flight f WHERE f.operatingAirlines = :operatingAirlines"),
		@NamedQuery(name = "Flight.findByDepartureCity", query = "SELECT f FROM Flight f WHERE f.departureCity = :departureCity"),
		@NamedQuery(name = "Flight.findByArrivalCity", query = "SELECT f FROM Flight f WHERE f.arrivalCity = :arrivalCity"),
		@NamedQuery(name = "Flight.findByDateOfDeparture", query = "SELECT f FROM Flight f WHERE f.dateOfDeparture = :dateOfDeparture"),
		@NamedQuery(name = "Flight.findByEstimatedDepartureTime", query = "SELECT f FROM Flight f WHERE f.estimatedDepartureTime = :estimatedDepartureTime") })
public class Flight implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer flightId;
	@Basic(optional = false)
	@Column(nullable = false, length = 20)
	private String flightNumber;
	@Basic(optional = false)
	@Column(nullable = false, length = 20)
	private String operatingAirlines;
	@Basic(optional = false)
	@Column(nullable = false, length = 20)
	private String departureCity;
	@Basic(optional = false)
	@Column(nullable = false, length = 20)
	private String arrivalCity;
	@Basic(optional = false)
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfDeparture;
	@Basic(optional = false)
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date estimatedDepartureTime;
	//@OneToMany(mappedBy = "reservationFlightId")
	//private Collection<Reservation> reservationCollection;

	public Flight() {
	}

	public Flight(Integer flightId) {
		this.flightId = flightId;
	}

	public Flight(Integer flightId, String flightNumber, String operatingAirlines, String departureCity,
			String arrivalCity, Date dateOfDeparture, Date estimatedDepartureTime) {
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.operatingAirlines = operatingAirlines;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.dateOfDeparture = dateOfDeparture;
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingAirlines() {
		return operatingAirlines;
	}

	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Date getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(Date estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

//	public Collection<Reservation> getReservationCollection() {
//		return reservationCollection;
//	}
//
//	public void setReservationCollection(Collection<Reservation> reservationCollection) {
//		this.reservationCollection = reservationCollection;
//	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (flightId != null ? flightId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Flight)) {
			return false;
		}
		Flight other = (Flight) object;
		if ((this.flightId == null && other.flightId != null)
				|| (this.flightId != null && !this.flightId.equals(other.flightId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Flight [flightId=");
		builder.append(flightId);
		builder.append(", flightNumber=");
		builder.append(flightNumber);
		builder.append(", operatingAirlines=");
		builder.append(operatingAirlines);
		builder.append(", departureCity=");
		builder.append(departureCity);
		builder.append(", arrivalCity=");
		builder.append(arrivalCity);
		builder.append(", dateOfDeparture=");
		builder.append(dateOfDeparture);
		builder.append(", estimatedDepartureTime=");
		builder.append(estimatedDepartureTime);
		builder.append(", reservationCollection=");
		//builder.append(reservationCollection);
		builder.append("]");
		return builder.toString();
	}

}
