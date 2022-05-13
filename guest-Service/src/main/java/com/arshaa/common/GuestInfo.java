package com.arshaa.common;

public class GuestInfo {

	private String email ;
	 private String GuestName ;
	// private String lastName ;
	 private String BuildingName ;
	 private String personalNumber ;
	 private String bedId ;
	 private String occupancyType ;
	 private String id ;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGuestName() {
		return GuestName;
	}
	public void setGuestName(String guestName) {
		GuestName = guestName;
	}
	public String getBuildingName() {
		return BuildingName;
	}
	public void setBuildingName(String buildingName) {
		BuildingName = buildingName;
	}
	public String getPersonalNumber() {
		return personalNumber;
	}
	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}
	public String getBedId() {
		return bedId;
	}
	public void setBedId(String bedId) {
		this.bedId = bedId;
	}
	public String getOccupancyType() {
		return occupancyType;
	}
	public void setOccupancyType(String occupancyType) {
		this.occupancyType = occupancyType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public GuestInfo(String email, String guestName, String buildingName, String personalNumber, String bedId,
			String occupancyType, String id) {
		super();
		this.email = email;
		GuestName = guestName;
		BuildingName = buildingName;
		this.personalNumber = personalNumber;
		this.bedId = bedId;
		this.occupancyType = occupancyType;
		this.id = id;
	}
	public GuestInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	
}
