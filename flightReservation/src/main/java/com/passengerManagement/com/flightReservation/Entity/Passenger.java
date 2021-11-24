/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.passengerManagement.com.flightReservation.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author spring
 */
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(catalog = "flightreservation", schema = "")
@NamedQueries({ @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p"),
		@NamedQuery(name = "Passenger.findByPassengerId", query = "SELECT p FROM Passenger p WHERE p.passengerId = :passengerId"),
		@NamedQuery(name = "Passenger.findByPassengerFirstName", query = "SELECT p FROM Passenger p WHERE p.passengerFirstName = :passengerFirstName"),
		@NamedQuery(name = "Passenger.findByPassengerLastName", query = "SELECT p FROM Passenger p WHERE p.passengerLastName = :passengerLastName"),
		@NamedQuery(name = "Passenger.findByPassengerMiddleName", query = "SELECT p FROM Passenger p WHERE p.passengerMiddleName = :passengerMiddleName"),
		@NamedQuery(name = "Passenger.findByPassengerEmail", query = "SELECT p FROM Passenger p WHERE p.passengerEmail = :passengerEmail"),
		@NamedQuery(name = "Passenger.findByPassengerPhone", query = "SELECT p FROM Passenger p WHERE p.passengerPhone = :passengerPhone") })
public class Passenger implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer passengerId;
	@Column(length = 256)
	private String passengerFirstName;
	@Column(length = 256)
	private String passengerLastName;
	@Column(length = 256)
	private String passengerMiddleName;
	@Column(length = 50)
	private String passengerEmail;
	@Column(length = 15)
	private String passengerPhone;
	//@OneToMany(mappedBy = "reservationPassengerId")
	//private Collection<Reservation> reservationCollection;

	public Passenger() {
	}

	public Passenger(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerFirstName() {
		return passengerFirstName;
	}

	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	public String getPassengerLastName() {
		return passengerLastName;
	}

	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}

	public String getPassengerMiddleName() {
		return passengerMiddleName;
	}

	public void setPassengerMiddleName(String passengerMiddleName) {
		this.passengerMiddleName = passengerMiddleName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public String getPassengerPhone() {
		return passengerPhone;
	}

	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
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
		hash += (passengerId != null ? passengerId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Passenger)) {
			return false;
		}
		Passenger other = (Passenger) object;
		if ((this.passengerId == null && other.passengerId != null)
				|| (this.passengerId != null && !this.passengerId.equals(other.passengerId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Passenger [passengerId=");
		builder.append(passengerId);
		builder.append(", passengerFirstName=");
		builder.append(passengerFirstName);
		builder.append(", passengerLastName=");
		builder.append(passengerLastName);
		builder.append(", passengerMiddleName=");
		builder.append(passengerMiddleName);
		builder.append(", passengerEmail=");
		builder.append(passengerEmail);
		builder.append(", passengerPhone=");
		builder.append(passengerPhone);
		builder.append(", reservationCollection=");
		//builder.append(reservationCollection);
		builder.append("]");
		return builder.toString();
	}

}
