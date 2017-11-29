package net.atos.Codex_IOT.model;

public class SensorMapModel {
	
	private long sensormappingid;
	
	private String sensorId;
	
	private long userId;

	public long getSensormappingid() {
		return sensormappingid;
	}

	public void setSensormappingid(long sensormappingid) {
		this.sensormappingid = sensormappingid;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SensorMapModel [sensormappingid=" + sensormappingid + ", sensorId=" + sensorId + ", userId=" + userId
				+ "]";
	}
	
	
	
	

}
