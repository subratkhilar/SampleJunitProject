package net.atos.Codex_IOT.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.atos.Codex_IOT.pojo.Project;
import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.pojo.Temperature;

/**
 * @author a631080
 *
 */
@Transactional
@Repository
public class TemperatureDaoImpl implements TemperatureDao {


	@Autowired
	private SessionFactory sessionfactory;

	
	
	public List<Temperature> getData() {
		
		return (List<Temperature>) sessionfactory.getCurrentSession().createQuery("select b from Temperature b").list();
		
	}
	
	
	
	public List<Temperature> getDataByID(String id) {
		
		return (List<Temperature>) sessionfactory.getCurrentSession().createQuery("select b from Temperature b where b.sensor.sensorId= :id").setParameter("id",id).list();
		
	}

		public String saveTemperature(Temperature t){
		
		sessionfactory.getCurrentSession().save(t);
				return "success";
		
	}
	
}
