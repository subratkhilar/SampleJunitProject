package net.atos.Codex_IOT.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ValueGenerationType;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

public class LiveDataModel {
	
	
	private int id;
	
	
	private int temperature;
	
	private Date date;
	
	private String kpiid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}


	 

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getKpiid() {
		return kpiid;
	}

	public void setKpiid(String kpiid) {
		this.kpiid = kpiid;
	}

	
	
	
}
