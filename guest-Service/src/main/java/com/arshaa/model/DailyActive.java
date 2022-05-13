package com.arshaa.model;

public class DailyActive {

	

    private String firstName;
    private String id;
    private String BuildingName;
    private String bedId;
    private String personalNumber;
    private String email;
    private double dueAmount;
    private String occupancyType ;
    private String guestStatus ;
    
	public DailyActive(String firstName, String id, String buildingName, String bedId, String personalNumber,
			String email, double dueAmount, String occupancyType, String guestStatus) {
		super();
		this.firstName = firstName;
		this.id = id;
		BuildingName = buildingName;
		this.bedId = bedId;
		this.personalNumber = personalNumber;
		this.email = email;
		this.dueAmount = dueAmount;
		this.occupancyType = occupancyType;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

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

	public DailyActive() {
		// TODO Auto-generated constructor stub
	}

}
