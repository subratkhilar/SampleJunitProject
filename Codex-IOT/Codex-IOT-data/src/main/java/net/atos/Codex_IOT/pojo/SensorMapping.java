package net.atos.Codex_IOT.pojo;

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


@Entity
@Table(name="SensorMapping",schema ="operationdb")
@NamedQuery(name="SensorMapping.findAll", query="SELECT s FROM SensorMapping s")
public class SensorMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="sensormapping_Id")	
	private long sensormappingid;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "SENSOR_ID")
	private Sensor sensor;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "USER_ID")
	private User user;

	public long getSensormappingid() {
		return sensormappingid;
	}

	public void setSensormappingid(long sensormappingid) {
		this.sensormappingid = sensormappingid;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SensorMapping [sensormappingid=" + sensormappingid
				+ ", sensor=" + sensor + ", user=" + user + "]";
	}

	
	
	
	
}
