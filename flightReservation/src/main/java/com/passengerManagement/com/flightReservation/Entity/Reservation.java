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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@NamedQueries({ @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
		@NamedQuery(name = "Reservation.findByReservationId", query = "SELECT r FROM Reservation r WHERE r.reservationId = :reservationId"),
		@NamedQuery(name = "Reservation.findByReservationCheckedIn", query = "SELECT r FROM Reservation r WHERE r.reservationCheckedIn = :reservationCheckedIn"),
		@NamedQuery(name = "Reservation.findByReservationNumberOfBags", query = "SELECT r FROM Reservation r WHERE r.reservationNumberOfBags = :reservationNumberOfBags"),
		@NamedQuery(name = "Reservation.findByCreated", query = "SELECT r FROM Reservation r WHERE r.created = :created") })
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer reservationId;
	private Boolean reservationCheckedIn;
	private Integer reservationNumberOfBags;
	@Basic(optional = false)
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@JoinColumn(name = "reservationPassengerId", referencedColumnName = "passengerId")
	@OneToOne
	private Passenger reservationPassengerId;
	@JoinColumn(name = "reservationFlightId", referencedColumnName = "flightId")
	@OneToOne
	private Flight reservationFlightId;

	public Reservation() {
	}

	public Reservation(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Reservation(Integer reservationId, Date created) {
		this.reservationId = reservationId;
		this.created = created;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Boolean getReservationCheckedIn() {
		return reservationCheckedIn;
	}

	public void setReservationCheckedIn(Boolean reservationCheckedIn) {
		this.reservationCheckedIn = reservationCheckedIn;
	}

	public Integer getReservationNumberOfBags() {
		return reservationNumberOfBags;
	}

	public void setReservationNumberOfBags(Integer reservationNumberOfBags) {
		this.reservationNumberOfBags = reservationNumberOfBags;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Passenger getReservationPassengerId() {
		return reservationPassengerId;
	}

	public void setReservationPassengerId(Passenger reservationPassengerId) {
		this.reservationPassengerId = reservationPassengerId;
	}

	public Flight getReservationFlightId() {
		return reservationFlightId;
	}

	public void setReservationFlightId(Flight reservationFlightId) {
		this.reservationFlightId = reservationFlightId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (reservationId != null ? reservationId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Reservation)) {
			return false;
		}
		Reservation other = (Reservation) object;
		if ((this.reservationId == null && other.reservationId != null)
				|| (this.reservationId != null && !this.reservationId.equals(other.reservationId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [reservationId=");
		builder.append(reservationId);
		builder.append(", reservationCheckedIn=");
		builder.append(reservationCheckedIn);
		builder.append(", reservationNumberOfBags=");
		builder.append(reservationNumberOfBags);
		builder.append(", created=");
		builder.append(created);
		builder.append(", reservationPassengerId=");
		builder.append(reservationPassengerId.getPassengerId());
		builder.append(", reservationFlightId=");
		builder.append(reservationFlightId.getFlightId());
		builder.append("]");
		return builder.toString();
	}

}
