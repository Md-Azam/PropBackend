package Models;

public class Availableroom {
 
	private String buildingName ;
	private String floorName ;
	private String roomName ;
	
	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public Availableroom(String buildingName, String floorName, String roomName) {
		super();
		this.buildingName = buildingName;
		this.floorName = floorName;
		this.roomName = roomName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Availableroom() {
		// TODO Auto-generated constructor stub
	}

}
