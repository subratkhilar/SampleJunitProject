package net.atos.Codex_IOT.dao;

import java.util.List;

import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.pojo.Temperature;

/**
 * @author a631080
 *
 */
public interface TemperatureDao {

	public List<Temperature> getData();
	
	public List<Temperature> getDataByID(String id);
	
	public String saveTemperature(Temperature t);
}
