package net.atos.Codex_IOT.dao;

import java.util.List;

import net.atos.Codex_IOT.pojo.Sensor;



public interface SensorDao {
	
	public List<Sensor> getSensors();
	
	public List<Sensor> getSensorsByAssetId(String assetId);
	
	public List<Sensor> getSensorsByCustomerId(long customerId);

	public Sensor getSensorById(String id);
	
	public Sensor saveSensor(Sensor sensor);

	public String updateSensor(Sensor sensor);

	public List<Sensor> getallSensorsByCustomerId(long customerId);

	public List<Sensor> getallSensorsByAssetId(String assetId);

	public List<Sensor> getallSensorCustomerIdTrue(long customerId);
}
