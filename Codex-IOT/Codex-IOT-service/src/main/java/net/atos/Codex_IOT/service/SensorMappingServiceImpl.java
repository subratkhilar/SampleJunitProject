package net.atos.Codex_IOT.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.Codex_IOT.dao.SensorMappingDao;
import net.atos.Codex_IOT.pojo.SensorMapping;

@Service
@Transactional
public class SensorMappingServiceImpl implements SensorMappingService {

	@Autowired
	private SensorMappingDao sensmapdao;
	
	@Override
	public List<SensorMapping> getSensorList(long id) {
		
		return sensmapdao.getSensorList(id);
	}

	@Override
	public void savesensormap(SensorMapping p) {
		 sensmapdao.savesensormap(p);
		
	}

}
