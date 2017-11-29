package net.atos.Codex_IOT.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.atos.Codex_IOT.pojo.Sensor;

@Transactional
@Repository
public class SensorDaoImpl implements SensorDao {

	private static final Logger logger = Logger.getLogger(SensorDaoImpl.class); // Apache
	// logger

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Sensor> getSensors() {
		logger.info("in dao sensor");

		return sessionFactory.getCurrentSession()

				.createQuery("SELECT s FROM Sensor s where s.isActive = true order by s.createdDate desc").list();


	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sensor> getSensorsByAssetId(String id) {
		logger.info("inside getSensorsByAssetId()");

		return sessionFactory.getCurrentSession()
				.createQuery(
						"SELECT s FROM Sensor s where s.asset.assetId =:id and s.isActive = true order by s.updatedDate desc")
				.setParameter("id", id).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sensor> getSensorsByCustomerId(long id) {
		logger.info("inside getSensorsByCustomerId()");
		return sessionFactory.getCurrentSession()
				.createQuery(
						"SELECT s FROM Sensor s inner join s.asset as a inner join a.project as p where p.customer.customerId =:id and s.isActive = true order by s.updatedDate desc")
				.setParameter("id", id).list();
	}

	@Override
	public Sensor saveSensor(Sensor s) {
		logger.info("inside saveSensor()");
		if (sessionFactory.getCurrentSession().save(s) != null) {
			return s;
		}
		return null;
	}

	@Override
	public Sensor getSensorById(String id) {

		logger.info("inside getSensorById()");
		return (Sensor) sessionFactory.getCurrentSession().createQuery("select s from Sensor s where s.sensorId =:id ")
				.setParameter("id", id).uniqueResult();

	}

	@Override
	public String updateSensor(Sensor s) {
		logger.info("inside updateSensor()");
		sessionFactory.getCurrentSession().saveOrUpdate(s);
		return "success";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sensor> getallSensorsByCustomerId(long id) {
		logger.info("inside getallSensorsByCustomerId()");
		return sessionFactory.getCurrentSession()
				.createQuery(
						"SELECT s FROM Sensor s inner join s.asset as a inner join a.project as p where p.customer.customerId =:id order by s.updatedDate desc")
				.setParameter("id", id).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sensor> getallSensorsByAssetId(String id) {
		logger.info("inside getallSensorsByAssetId()");

		return sessionFactory.getCurrentSession().createQuery("SELECT s FROM Sensor s where s.asset.assetId =:id")
				.setParameter("id", id).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sensor> getallSensorCustomerIdTrue(long id) {
		logger.info("inside getallSensorCustomerIdTrue()");
		return sessionFactory.getCurrentSession()
				.createQuery(
						"SELECT s FROM Sensor s inner join s.asset as a inner join a.project as p where p.customer.customerId =:id and s.isActive = true order by s.updatedDate desc")
				.setParameter("id", id).list();
	}

}
