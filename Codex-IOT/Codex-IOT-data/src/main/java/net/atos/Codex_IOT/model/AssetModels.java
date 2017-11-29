package net.atos.Codex_IOT.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author a634945
 *
 */
public class AssetModels {
 
	private String assetId ;
	
	@NotNull(message="Asset serial number should not be null.")
	@NotEmpty(message="Asset serial number not be empty.")
	private String assetSerialNumber;

	@NotNull(message="Asset name should not be null.")
	@NotEmpty(message="Asset name should not be empty.")
	private String assetName;

	@NotNull(message="Asset description should not be null.")
	@NotEmpty(message="Asset description should not be empty.")
	private String assetDesc;

	@NotNull(message="Asset ip address should not be null.")
	@NotEmpty(message="Asset ip address should not be empty.")
	private String assetIpAddress;
	
	@NotNull(message="Asset protocol address should not be null.")
	@NotEmpty(message="Asset protocol address should not be empty.")
	private String assetProtocol;
	
	
	private String projectId;


	private Date  createdDate;


	private Date updatedDate;
	

	private boolean isActive;
	
	/**
	 * @return the assetId
	 */
	public String getAssetId() {
		return assetId;
	}

	/**
	 * @param string the assetId to set
	 */
	public void setAssetId(String string) {
		this.assetId = string;
	}

	/**
	 * @return the assetSerialNumber
	 */
	public String getAssetSerialNumber() {
		return assetSerialNumber;
	}

	/**
	 * @param assetSerialNumber the assetSerialNumber to set
	 */
	public void setAssetSerialNumber(String assetSerialNumber) {
		this.assetSerialNumber = assetSerialNumber;
	}

	/**
	 * @return the assetName
	 */
	public String getAssetName() {
		return assetName;
	}

	/**
	 * @param assetName the assetName to set
	 */
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	/**
	 * @return the assetDesc
	 */
	public String getAssetDesc() {
		return assetDesc;
	}

	/**
	 * @param assetDesc the assetDesc to set
	 */
	public void setAssetDesc(String assetDesc) {
		this.assetDesc = assetDesc;
	}

	/**
	 * @return the assetIpAddress
	 */
	public String getAssetIpAddress() {
		return assetIpAddress;
	}

	/**
	 * @param assetIpAddress the assetIpAddress to set
	 */
	public void setAssetIpAddress(String assetIpAddress) {
		this.assetIpAddress = assetIpAddress;
	}

	/**
	 * @return the assetProtocol
	 */
	public String getAssetProtocol() {
		return assetProtocol;
	}

	/**
	 * @param assetProtocol the assetProtocol to set
	 */
	public void setAssetProtocol(String assetProtocol) {
		this.assetProtocol = assetProtocol;
	}

	/**
	 * @return the createdDate
	 */

	

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
		
	
	/**
	 * @return
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return
	 */
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssetModel [assetId=" + assetId + ", assetSerialNumber="
				+ assetSerialNumber + ", assetName=" + assetName
				+ ", assetDesc=" + assetDesc + ", assetIpAddress="
				+ assetIpAddress + ", assetProtocol=" + assetProtocol
				 + ", projectId=" + projectId + "]";
	}



}
