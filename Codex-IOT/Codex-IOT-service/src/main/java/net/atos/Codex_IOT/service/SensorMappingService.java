package net.atos.Codex_IOT.service;

import java.util.List;

import net.atos.Codex_IOT.pojo.SensorMapping;

public interface SensorMappingService {

	List<SensorMapping> getSensorList(long user_id);

	void savesensormap(SensorMapping p);

}
