package net.atos.Codex_IOT.pojo;

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
 * @author a634945
 *
 */
@Entity
@Table(name = "workflow",schema = "operationdb")
@NamedQuery(name="Workflow.findAll", query="SELECT s FROM Workflow s")
public class Workflow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "workflow_id")
	private long workflowId;
	
	@Column(name="event_type")
	private String eventType;
	
	@Column(name ="upper_limit")
	private int upperLimit;
	
	@Column(name ="lower_limit")
	private int lowerLimit;
	
	@Column(name ="no_Of_Occurrences")
	private int noOfOccurrences;
	
	@Column(name="media_type")
	private String meadiaType;
	
	@Column(name="media_value")
	private String mediaValue;
	
	@Column(name="created_Date")
	private Date createdDate;
	
	@Column(name="updated_Date")
	private Date updatedDate;
	
	@Column(name="is_Active")
	private boolean isActive;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "project_id")
	private Project project;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "asset_id")
	private Asset asset;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "customer_id")
	private Customer customer;	
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="sensor_id")
	private Sensor sensor;


	public long getWorkflowId() {
		return workflowId;
	}


	public void setWorkflowId(long workflowId) {
		this.workflowId = workflowId;
	}


	public String getEventType() {
		return eventType;
	}


	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


	public int getUpperLimit() {
		return upperLimit;
	}


	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}


	public int getLowerLimit() {
		return lowerLimit;
	}


	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}


	public int getNoOfOccurrences() {
		return noOfOccurrences;
	}


	public void setNoOfOccurrences(int noOfOccurrences) {
		this.noOfOccurrences = noOfOccurrences;
	}


	public String getMeadiaType() {
		return meadiaType;
	}


	public void setMeadiaType(String meadiaType) {
		this.meadiaType = meadiaType;
	}


	public String getMediaValue() {
		return mediaValue;
	}


	public void setMediaValue(String mediaValue) {
		this.mediaValue = mediaValue;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public Asset getAsset() {
		return asset;
	}


	public void setAsset(Asset asset) {
		this.asset = asset;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Sensor getSensor() {
		return sensor;
	}


	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	
	
	
}
