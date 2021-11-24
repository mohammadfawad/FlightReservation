package com.passengerManagement.com.flightReservation.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@MappedSuperclass //common fields are in class and @MappedSuperclass repeated code is included in it. 
//child classes will extend it and common code will be excluded from child classes. for example; class below.
public class SuperAbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
