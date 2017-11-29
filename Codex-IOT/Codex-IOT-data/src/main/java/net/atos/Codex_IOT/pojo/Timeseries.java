package net.atos.Codex_IOT.pojo;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the timeseries database table.
 * 
 */
@Entity
@Table(name="timeseries",schema = "operationdb")
@NamedQuery(name="Timeseries.findAll", query="SELECT t FROM Timeseries t")
public class Timeseries implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="timeseries_id")
	private long timeseriesId;

	private String date;

	private String waterlevel;

	//bi-directional many-to-one association to Sensor
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="sensor_id")
	private Sensor sensor;

	public Timeseries() {
	}

	public long getTimeseriesId() {
		return this.timeseriesId;
	}

	public void setTimeseriesId(long timeseriesId) {
		this.timeseriesId = timeseriesId;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWaterlevel() {
		return this.waterlevel;
	}

	public void setWaterlevel(String waterlevel) {
		this.waterlevel = waterlevel;
	}

	public Sensor getSensor() {
		return this.sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

}