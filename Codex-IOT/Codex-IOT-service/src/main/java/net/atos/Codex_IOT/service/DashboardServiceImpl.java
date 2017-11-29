package net.atos.Codex_IOT.service;



import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.atos.Codex_IOT.dao.CustomerDao;
import net.atos.Codex_IOT.dao.DashboardDao;
import net.atos.Codex_IOT.pojo.Customer;

/**
 * @author a622890
 *
 */
@Transactional
@Repository
public class DashboardServiceImpl implements DashboardService {

	private static final Logger logger = Logger.getLogger(DashboardServiceImpl.class); // Apache
	// logger

	@Autowired
	DashboardDao dashboardDao;

	@Autowired
	CustomerDao customerDao;

	@Override
	public int getNoOfProjects(String customerId) {
		logger.info("inside getNoOfProjects()");
		this.isCustomerIdValid(customerId);
		return dashboardDao.getNoOfProjects(customerId);
	}

	@Override
	public int getNoOfAssets(String customerId) {
		logger.info("inside getNoOfAssets()");
		this.isCustomerIdValid(customerId);
		return dashboardDao.getNoOfAssets(customerId);
	}

	@Override
	public int getNoOfSensors(String customerId) {
		logger.info("inside getNoOfSensors()");
		this.isCustomerIdValid(customerId);
		return dashboardDao.getNoOfSensors(customerId);
	}

	private boolean isCustomerIdValid(String customerId) {
		logger.info("inside isCustomerIdValid()");
		
		Customer customer= customerDao.findById(Long.parseLong(customerId));
		if(null==customer){
			throw new NullPointerException("Customer Id not found");
		}
		return true;
	}

	@Override
	public int getNoOfAssetsByProjectId(String projectId) {
		logger.info("inside getNoOfAssetByProjectId()");
		return dashboardDao.getNoOfAssetsByProjectId(projectId);
	}

	@Override
	public int getNoOfSensorsByAssetId(String assetId) {
		logger.info("inside getNoOfSensorsByAssetId()");
		return dashboardDao.getNoOfSensorsByAssetId(assetId);
	}
	
	
}
