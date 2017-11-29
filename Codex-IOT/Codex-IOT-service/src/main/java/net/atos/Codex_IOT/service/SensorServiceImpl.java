package net.atos.Codex_IOT.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.atos.Codex_IOT.dao.SensorDao;
import net.atos.Codex_IOT.pojo.Sensor;

@Transactional
@Repository
public class SensorServiceImpl implements SensorService {

	private static final Logger logger = Logger.getLogger(SensorServiceImpl.class);

	@Autowired
	private SensorDao sensordao;

	@Override
	public List<Sensor> getSensor() {
		logger.info("Inside getSensor()");

		return sensordao.getSensors();
	}

	@Override
	public List<Sensor> getSensorByAssetId(String id) {
		logger.info("iniotservice impl");

		return sensordao.getSensorsByAssetId(id);
	}

	@Override
	public List<Sensor> getSensorsByCustomerId(long id) {
		logger.info("Inside getSensorsByCustomerId()");
		return sensordao.getSensorsByCustomerId(id);
	}

	@Override
	public void updateSensorActiveState(String sensorId) {
		logger.info("inside updateSensorActiveState()");

		Sensor sensor = sensordao.getSensorById(sensorId);
		if (sensor.isActive()) {
			sensor.setActive(false);

		} else {
			sensor.setActive(true);
		}
		sensor.setUpdatedDate(new Date());
		sensordao.updateSensor(sensor);

	}

	@Override
	public Sensor saveSensor(Sensor s) {
		logger.info("iniotservice sensor save impl");

		return sensordao.saveSensor(s);
	}

	@Override
	public Sensor getSensorById(String id) {
		logger.info("Inside getSensorById()");
		return sensordao.getSensorById(id);
	}

	@Override
	public String updateSensor(Sensor s) {
		logger.info("Inside updateSensor()");
		return sensordao.updateSensor(s);
	}

	@Override
	public List<Sensor> getallSensorsByCustomerId(long id) {
		logger.info("Inside getallSensorsByCustomerId()");
		return sensordao.getallSensorsByCustomerId(id);
	}

	@Override
	public List<Sensor> getallSensorByAssetId(String id) {
		logger.info("iniotservice impl");
		return sensordao.getallSensorsByAssetId(id);
	}

	@Override
	public List<Sensor> getallSensorCustomerIdTrue(long id) {
		logger.info("Inside getallSensorCustomerIdTrue()");
		return sensordao.getallSensorCustomerIdTrue(id);
	}
}
