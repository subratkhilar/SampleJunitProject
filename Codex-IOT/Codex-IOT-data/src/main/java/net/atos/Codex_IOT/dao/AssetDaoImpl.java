package net.atos.Codex_IOT.dao;

import java.util.List;

import javax.transaction.Transactional;

import net.atos.Codex_IOT.pojo.Asset;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author a622693
 *
 */

@Transactional
@Repository
@EnableTransactionManagement
public class AssetDaoImpl implements AssetDao {
	
	private static final Logger logger = Logger.getLogger(UserDaoImp.class); // Apache
	// logger


	@Autowired
	private SessionFactory sessionfactory;

	
	
	/**
	 * 
	 */
	public AssetDaoImpl() {
		logger.info("in asset service impl");
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getassetList() {
		logger.info("in getting list of  asset");

		return sessionfactory.getCurrentSession().createQuery("SELECT u FROM Asset u where u.isActive = true order by u.createdDate desc").list();

	}



	@Override
	public Asset getAssetbyId(String assetId) {
		logger.info("in add asset dao impl");
		return (Asset) sessionfactory.getCurrentSession().createQuery("SELECT u FROM Asset u where u.assetId=:assetId").setParameter("assetId", assetId).uniqueResult();
	}



	@Override
	public boolean deleteAssetbyId(Asset asset) {
		logger.info("in deleting asset list by id");
		sessionfactory.getCurrentSession().createQuery("update Asset a set isActive = false where a.assetId=:id").setParameter("id",asset.getAssetId()).executeUpdate();
		sessionfactory.getCurrentSession().createQuery("update Sensor s set isActive = false where s.asset.assetId=:id").setParameter("id",asset.getAssetId()).executeUpdate();
		return true;
	}



	@Override
	public void updateasset(Asset asset) {
		logger.info("in update asset dao impl");
		sessionfactory.getCurrentSession().saveOrUpdate(asset);
		
	}



	@Override
	public Asset addAsset(Asset asset) {
		logger.info("This is Project Dao Impl");
				if(sessionfactory.getCurrentSession().save(asset)!=null)
			return asset;
		return null;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAssetbyprojId(String projectId) {
		logger.info("in  geeting from asset dao");
		return sessionfactory.getCurrentSession().createQuery("select c from Asset c where c.project.projectId= :projectId and c.isActive = true order by c.createdDate desc").setParameter("projectId", projectId).list();

	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getallassetbycustomerid(long customerId) {
		return sessionfactory.getCurrentSession().createQuery("select a from Asset a inner join a.project as p where p.customer.customerId =:customerId and a.isActive = true order by a.updatedDate desc").setParameter("customerId", customerId).list();
		}



	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getallassetbycustid(long customerId) {
		return sessionfactory.getCurrentSession().createQuery("select a from Asset a inner join a.project as p where p.customer.customerId =:customerId order by a.updatedDate desc").setParameter("customerId", customerId).list();
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getallAssetbyprojId(String projectId) {
		logger.info("in  geeting from asset dao");
		return sessionfactory.getCurrentSession().createQuery("select c from Asset c where c.project.projectId= :projectId order by c.createdDate desc").setParameter("projectId", projectId).list();
	}

	

	

}
