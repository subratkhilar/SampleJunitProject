package net.atos.Codex_IOT.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SensorModels {
	
private String sensorId;
	
	@NotNull(message="Sensor serial number should not be null.")
	@NotEmpty(message="Sensor serial number should not be empty.")
	private String sensorSerialNumber;

	@NotNull(message="Sensor name should not be null.")
	@NotEmpty(message="Sensor name should not be empty.")
	private String sensorsName;

	@NotNull(message="Sensor Description should not be null.")
	@NotEmpty(message="Sensor Description should not be empty.")
	private String sensorDescription;

	@NotNull(message="Sensor tag should not be null.")
	@NotEmpty(message="Sensor tag should not be empty.")
	private String sensorTag;

	@NotNull(message="Sensor datatype should not be null.")
	@NotEmpty(message="Sensor datatype should not be empty.")
	private String sensorDatatype;

	

	private boolean isActive;
	
	
	private Date createdDate;
	
	
	private Date updatedDate;
	

	private String assetId;

	
	
	
	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getSensorSerialNumber() {
		return sensorSerialNumber;
	}

	public void setSensorSerialNumber(String sensorSerialNumber) {
		this.sensorSerialNumber = sensorSerialNumber;
	}

	public String getSensorsName() {
		return sensorsName;
	}

	public void setSensorsName(String sensorsName) {
		this.sensorsName = sensorsName;
	}

	public String getSensorDescription() {
		return sensorDescription;
	}

	public void setSensorDescription(String sensorDescription) {
		this.sensorDescription = sensorDescription;
	}

	public String getSensorTag() {
		return sensorTag;
	}

	public void setSensorTag(String sensorTag) {
		this.sensorTag = sensorTag;
	}

	public String getSensorDatatype() {
		return sensorDatatype;
	}

	public void setSensorDatatype(String sensorDatatype) {
		this.sensorDatatype = sensorDatatype;
	}


	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "SensorModels [sensorId=" + sensorId + ", sensorSerialNumber=" + sensorSerialNumber + ", sensorsName="
				+ sensorsName + ", sensorDescription=" + sensorDescription + ", sensorTag=" + sensorTag
				+ ", sensorDatatype=" + sensorDatatype + ", isActive=" + isActive + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", assetId=" + assetId + "]";
	}
	
	
}
