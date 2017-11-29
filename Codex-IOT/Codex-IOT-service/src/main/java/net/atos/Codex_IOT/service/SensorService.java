package net.atos.Codex_IOT.service;

import java.util.List;

import net.atos.Codex_IOT.pojo.Sensor;







import org.springframework.stereotype.Service;


@Service
public interface SensorService {
	
	
	
	public List<Sensor> getSensor();

	public List<Sensor> getSensorByAssetId(String id);
	
	public List<Sensor> getSensorsByCustomerId(long customerid);
	
	public Sensor getSensorById(String id);
	
	public Sensor saveSensor(Sensor sensor);
	
	public String updateSensor(Sensor sensor);
	
	public void updateSensorActiveState(String sensorId);

	public List<Sensor> getallSensorsByCustomerId(long customerid);

	public List<Sensor> getallSensorByAssetId(String assetId);

	public List<Sensor> getallSensorCustomerIdTrue(long customerId);
}
