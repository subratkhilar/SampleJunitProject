package net.atos.Codex_IOT.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Date;


/**
 * The persistent class for the temperature database table.
 * 
 */
/**
 * @author a631080
 *
 */
@Entity
@Table(name = "temperature",schema = "operationdb")
@NamedQuery(name="Temperature.findAll", query="SELECT t FROM Temperature t")
public class Temperature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="temp_id")
	private long tempId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int temperature;

	//uni-directional many-to-one association to Sensor
	@ManyToOne(fetch = FetchType.EAGER ,targetEntity = Sensor.class, cascade = CascadeType.ALL )
	@JsonIgnore
	@JoinColumn(name="sensor_id")
	private Sensor sensor;

	public Temperature() {
	}	

	public Date getDate() {
		return this.date;
	}

	public long getTempId() {
		return tempId;
	}

	public void setTempId(long tempId) {
		this.tempId = tempId;
	}

	public void setDate(Date date) {
		this.date = date;
	}	
	
	public Sensor getSensor() {
		return this.sensor;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

}