package net.atos.Codex_IOT.dao;

import java.util.List;

import javax.transaction.Transactional;

import net.atos.Codex_IOT.pojo.SensorMapping;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class SensorMappingDaoImpl implements SensorMappingDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SensorMapping> getSensorList(long id) {
		return sessionFactory.getCurrentSession().createQuery("select p from SensorMapping p where p.user.userId =:id ").setParameter("id", id).list();
	}

	@Override
	public void savesensormap(SensorMapping p) {
		this.sessionFactory.getCurrentSession().save(p);
	}

}
