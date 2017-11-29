package net.atos.Codex_IOT.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.atos.Codex_IOT.pojo.Customer;

public class ProjectDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String projectId;

	private String projectName;

	private String projectDescription;

	private String projectLocation;

	private String longitude;

	private String latitude;

	private Date createdDate;

	private Date updatedDate;

	private boolean isActive;

	private int noOfAssets;

	private int noOfSensors;
	@JsonIgnore
	private Customer customer;

	

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectLocation() {
		return projectLocation;
	}

	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getNoOfAssets() {
		return noOfAssets;
	}

	public void setNoOfAssets(int noOfAssets) {
		this.noOfAssets = noOfAssets;
	}

	public int getNoOfSensors() {
		return noOfSensors;
	}

	public void setNoOfSensors(int noOfSensors) {
		this.noOfSensors = noOfSensors;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
