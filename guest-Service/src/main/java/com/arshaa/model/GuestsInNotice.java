package com.arshaa.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GuestsInNotice {

    private String firstName;
    private String id;
    private String BuildingName;
    private String bedId;
    private String personalNumber;
    private String email;
    private double dueAmount;
    private String occupancyType ;
    private String guestStatus ;
   	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="IST")
	//@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date checkInDate = new java.util.Date(System.currentTimeMillis());
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="IST")
    private java.util.Date checkOutDate;
    
    public String getOccupancyType() {
		return occupancyType;
	}
	public void setOccupancyType(String occupancyType) {
		this.occupancyType = occupancyType;
	}

	public String getGuestStatus() {
		return guestStatus;
	}
	public void setGuestStatus(String guestStatus) {
		this.guestStatus = guestStatus;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBuildingName() {
		return BuildingName;
	}
	public void setBuildingName(String buildingName) {
		BuildingName = buildingName;
	}
	public String getBedId() {
		return bedId;
	}
	public void setBedId(String bedId) {
		this.bedId = bedId;
	}
	public String getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}
	public String getEmail() {
		return email;
	}
	public GuestsInNotice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GuestsInNotice(String firstName, String id, String buildingName, String bedId, String personalNumber,
			String email, double dueAmount,String guestStatus , String occupancyType, Date checkInDate, Date checkOutDate) {
		super();
		this.firstName = firstName;
		this.id = id;
		BuildingName = buildingName;
		this.bedId = bedId;
		this.guestStatus = guestStatus ;
		this.personalNumber = personalNumber;
		this.email = email;
		this.dueAmount = dueAmount;
		this.occupancyType = occupancyType;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}
	public java.util.Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(java.util.Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public java.util.Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(java.util.Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
    
    
    
    }