package net.atos.Codex_IOT.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Asset",schema = "operationdb")
@NamedQuery(name="Asset.findAll", query="SELECT a FROM Asset a")
public class Asset implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="asset_id")
	private String assetId ;
	
	@Column(name ="asset_Serial_Number")
	private String assetSerialNumber;
	
	@Column(name ="asset_Name")
	private String assetName;
	
	@Column(name ="asset_Desc")
	private String assetDesc;
	
	@Column(name ="asset_Ip_Address")
	private String assetIpAddress;
	
	@Column(name ="asset_Protocol")
	private String assetProtocol;
	
	@Column(name ="created_Date")
	private Date  createdDate;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name ="is_Active")
	private boolean isActive;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJECT_ID")
	private Project project;


	
	/**
	 * @return
	 */
	public String getAssetId() {
		return assetId;
	}


	/**
	 * @param assetId
	 */
	public void setAssetId(String assetId) {
		this.assetId = assetId;
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
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}


	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}


	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	
		
	
}
