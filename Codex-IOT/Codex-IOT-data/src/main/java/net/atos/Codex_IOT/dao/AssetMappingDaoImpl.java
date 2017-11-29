package net.atos.Codex_IOT.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.atos.Codex_IOT.pojo.AssetMapping;

/**
 * @author a634945
 *
 */
@Transactional
@Repository
public class AssetMappingDaoImpl implements AssetMappingDao {

	/**
	 * 
	 */
	@Autowired
	public SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AssetMapping> getAssetList(long id) {
		
		return sessionFactory.getCurrentSession().createQuery("select p from AssetMapping p where p.user.userId =:id ").setParameter("id", id).list();
	}

	@Override
	public void saveprojmap(AssetMapping p) {
		this.sessionFactory.getCurrentSession().save(p);
		
	}
	
	
	

}
