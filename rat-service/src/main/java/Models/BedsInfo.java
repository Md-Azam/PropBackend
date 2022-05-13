package Models;

import common.Guest;

public class BedsInfo {
	private boolean bedStatus;
	private String guestId;
	private double defaultRent;
	private boolean ac;
	private int roomId;
	private int floorId;
	private int buildingId;
	private String bedName;
	private String bedId;
	private String buildingName;
	private int bedNum;
	public BedsInfo(boolean bedStatus, String guestId, double defaultRent, boolean ac, int roomId, int floorId,
			int buildingId, String bedName, String bedId, String buildingName, int bedNum, double securityDeposit,
			String guestName, Guest guest, String guestStatus) {
		super();
		this.bedStatus = bedStatus;
		this.guestId = guestId;
		this.defaultRent = defaultRent;
		this.ac = ac;
		this.roomId = roomId;
		this.floorId = floorId;
		this.buildingId = buildingId;
		this.bedName = bedName;
		this.bedId = bedId;
		this.buildingName = buildingName;
		this.bedNum = bedNum;
		this.securityDeposit = securityDeposit;
		this.guestName = guestName;
		this.guest = guest;
		this.guestStatus = guestStatus;
	}
	private double securityDeposit;
	private String guestName;
	private Guest guest;
    private String guestStatus;
	public boolean isBedStatus() {
		return bedStatus;
	}
	public void setBedStatus(boolean bedStatus) {
		this.bedStatus = bedStatus;
	}
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public double getDefaultRent() {
		return defaultRent;
	}
	public void setDefaultRent(double defaultRent) {
		this.defaultRent = defaultRent;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getFloorId() {
		return floorId;
	}
	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}
	public int getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	public String getBedName() {
		return bedName;
	}
	public void setBedName(String bedName) {
		this.bedName = bedName;
	}
	public String getBedId() {
		return bedId;
	}
	public void setBedId(String bedId) {
		this.bedId = bedId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public int getBedNum() {
		return bedNum;
	}
	public void setBedNum(int bedNum) {
		this.bedNum = bedNum;
	}
	public double getSecurityDeposit() {
		return securityDeposit;
	}
	public void setSecurityDeposit(double securityDeposit) {
		this.securityDeposit = securityDeposit;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public String getGuestStatus() {
		return guestStatus;
	}
	public void setGuestStatus(String guestStatus) {
		this.guestStatus = guestStatus;
	}
	public BedsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	
}
