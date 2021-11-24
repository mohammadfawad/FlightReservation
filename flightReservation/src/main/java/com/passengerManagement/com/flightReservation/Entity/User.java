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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author spring
 */
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(catalog = "flightreservation", schema = "", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "userEmail" }) })
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
		@NamedQuery(name = "User.findByUserFirstName", query = "SELECT u FROM User u WHERE u.userFirstName = :userFirstName"),
		@NamedQuery(name = "User.findByUserLastName", query = "SELECT u FROM User u WHERE u.userLastName = :userLastName"),
		@NamedQuery(name = "User.findByUserEmail", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail"),
		@NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.userPassword = :userPassword") })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer userId;
	@Column(length = 20)
	private String userFirstName;
	@Column(length = 20)
	private String userLastName;
	@Column(length = 20)
	private String userEmail;
	@Column(length = 256)
	private String userPassword;

	public User() {
	}

	public User(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userId != null ? userId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.userId == null && other.userId != null)
				|| (this.userId != null && !this.userId.equals(other.userId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", userFirstName=");
		builder.append(userFirstName);
		builder.append(", userLastName=");
		builder.append(userLastName);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append(", userPassword=");
		builder.append(userPassword);
		builder.append("]");
		return builder.toString();
	}

}
