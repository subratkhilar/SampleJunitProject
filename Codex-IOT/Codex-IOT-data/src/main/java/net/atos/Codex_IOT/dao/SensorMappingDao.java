package net.atos.Codex_IOT.dao;

import java.util.List;

import net.atos.Codex_IOT.pojo.SensorMapping;

public interface SensorMappingDao {

	List<SensorMapping> getSensorList(long id);

	void savesensormap(SensorMapping p);



}
