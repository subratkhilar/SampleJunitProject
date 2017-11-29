package net.atos.Codex_IOT.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * @author a622693
 *
 */


@Entity
@Table(name="Event",schema ="eventdb")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	
	private static final long serialVersionUID = 2L;
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name ="event_Id")	
private long eventId;

@Column(name ="event_Type")
private String eventtype;

@Column(name ="severity")
private String severity;

@Column(name ="event_Description")
private String eventdesc;

@Column(name ="created_Date")
private Date  createdDate;

@Column(name ="status")
private String status;

@ManyToOne
@JsonIgnore
@JoinColumn(name = "PROJECT_ID")
private Project project;

@ManyToOne
@JsonIgnore
@JoinColumn(name = "CUSTOMER_ID")
private Customer customer;	

@JsonIgnore
@ManyToOne
@JoinColumn(name="sensor_id")
private Sensor sensor;

@JsonIgnore
@ManyToOne
@JoinColumn(name ="asset_id")
private Asset asset ;

/**
 * 
 */
public Event() {
	super();
}

/**
 * @return the eventId
 */
public long getEventId() {
	return eventId;
}

/**
 * @param eventId the eventId to set
 */
public void setEventId(long eventId) {
	this.eventId = eventId;
}

/**
 * @return the eventname
 */


/**
 * @return the sensor
 */
public Sensor getSensor() {
	return sensor;
}

public String getEventtype() {
	return eventtype;
}

public void setEventtype(String eventtype) {
	this.eventtype = eventtype;
}

/**
 * @param sensor the sensor to set
 */
public void setSensor(Sensor sensor) {
	this.sensor = sensor;
}

/**
 * @return the eventdesc
 */
public String getEventdesc() {
	return eventdesc;
}

/**
 * @param eventdesc the eventdesc to set
 */
public void setEventdesc(String eventdesc) {
	this.eventdesc = eventdesc;
}

/**
 * @return the createdDate
 */
public Date getCreatedDate() {
	return createdDate;
}

/**
 * @param createdDate the createdDate to set
 */
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}

/**
 * @return the severity
 */
public String getSeverity() {
	return severity;
}

/**
 * @param severity the severity to set
 */
public void setSeverity(String severity) {
	this.severity = severity;
}

/**
 * @return the project
 */
public Project getProject() {
	return project;
}

/**
 * @param project the project to set
 */
public void setProject(Project project) {
	this.project = project;
}

/**
 * @return the customer
 */
public Customer getCustomer() {
	return customer;
}

/**
 * @param customer the customer to set
 */
public void setCustomer(Customer customer) {
	this.customer = customer;
}

/**
 * @return the assetId
 */


public String getStatus() {
	return status;
}

public Asset getAsset() {
	return asset;
}

public void setAsset(Asset asset) {
	this.asset = asset;
}

public void setStatus(String status) {
	this.status = status;
}


}
