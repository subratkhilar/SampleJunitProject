package net.atos.Codex_IOT.pojo;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the sensors database table.
 * 
 */
@Entity
@Table(name="sensors",schema = "operationdb")
@NamedQuery(name="Sensor.findAll", query="SELECT s FROM Sensor s")
public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sensor_id")
	private String sensorId;

	
	@Column(name="sensor_serial_number")
	private String sensorSerialNumber;


	@Column(name="sensors_name")
	private String sensorsName;

	@Column(name="sensor_description")
	private String sensorDescription;

	@Column(name="sensor_tag")
	private String sensorTag;
	
	@Column(name="sensor_datatype")
	private String sensorDatatype;

	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name ="created_date")
	private Date createdDate;
	
	@Column(name ="upated_date")
	private Date updatedDate;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "asset_id")
	private Asset asset;


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


	public Asset getAsset() {
		return asset;
	}


	public void setAsset(Asset asset) {
		this.asset = asset;
	}


	@Override
	public String toString() {
		return "Sensor [sensorId=" + sensorId + ", sensorSerialNumber=" + sensorSerialNumber + ", sensorsName="
				+ sensorsName + ", sensorDescription=" + sensorDescription + ", sensorTag=" + sensorTag
				+ ", sensorDatatype=" + sensorDatatype + ", isActive=" + isActive + ", asset=" + asset + "]";
	}

	
	
	
	

	


}