package net.atos.Codex_IOT.dao;

import java.util.List;
import java.util.ListIterator;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author a622890
 *
 */
@SuppressWarnings("unchecked")
@Transactional
@Repository
public class DashboardDaoImpl implements DashboardDao {

	private static final Logger logger = Logger.getLogger(DashboardDaoImpl.class); // Apache
	// logger

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public int getNoOfProjects(String customerId) {
		logger.info("inside getNoOfProjects()");
		List<String> list = getProjectList(customerId);
		int noOfProjects = list.size();
		logger.info("Number of Projects:" + noOfProjects);

		return noOfProjects;
	}

	private List<String> getProjectList(String customerId) {
		logger.info("inside getProjectList()");
		return sessionfactory.getCurrentSession()
				.createQuery("select p.projectId from Project p where p.customer.customerId= :customerId")
				.setParameter("customerId", Long.parseLong(customerId)).list();

	}

	private List<String> getAssetList(String projectId) {
		logger.info("inside getAssetList()");
		return sessionfactory.getCurrentSession()
				.createQuery("select a.assetId from Asset a where a.project.projectId= :projectId")
				.setParameter("projectId", projectId).list();

	}

	private List<String> getSensorList(String assetId) {
		logger.info("inside getSensorList()");
		return sessionfactory.getCurrentSession()
				.createQuery("select s.sensorId from Sensor s where s.asset.assetId= :assetId")
				.setParameter("assetId", assetId).list();

	}

	@Override
	public int getNoOfAssets(String customerId) {
		logger.info("inside getNoOfAssets()");
		int noOfAssets = 0;

		List<String> projectList = getProjectList(customerId);
		ListIterator<String> projectListIterator = projectList.listIterator();

		while (projectListIterator.hasNext()) {

			String currentProjectId = projectListIterator.next();

			List<String> assetList = this.getAssetList(currentProjectId);
			noOfAssets = noOfAssets + assetList.size();
		}

		return noOfAssets;
	}

	@Override
	public int getNoOfSensors(String customerId) {
		logger.info("inside getNoOfSensors()");
		int noOfSensors = 0;

		List<String> projectList = this.getProjectList(customerId);
		ListIterator<String> projectListIterator = projectList.listIterator();

		while (projectListIterator.hasNext()) {

			String currentProjectId = projectListIterator.next();

			List<String> assetList = this.getAssetList(String.valueOf(currentProjectId));

			ListIterator<String> assetListIterator = assetList.listIterator();
			while (assetListIterator.hasNext()) {
				String currentAssetId = assetListIterator.next();

				List<String> sensorList = this.getSensorList(currentAssetId);
				noOfSensors = noOfSensors + sensorList.size();
			}
		}

		return noOfSensors;
	}

	@Override
	public int getNoOfAssetsForProject(String projectId) {
		logger.info("inside getNoOfAssetsForProject()");
		return this.getAssetList(projectId).size();
	}

	@Override
	public int getNoOfSensorsForProject(String projectId) {
		logger.info("inside getNoOfSensorsForProject()");
		int noOfSensors = 0;

		List<String> assetIdList = this.getAssetList(projectId);
		ListIterator assetIdListIterator = assetIdList.listIterator();

		while (assetIdListIterator.hasNext()) {
			String currentAssetId = (String) assetIdListIterator.next();

			List<String> sensorList = this.getSensorList(String.valueOf(currentAssetId));
			noOfSensors = noOfSensors + sensorList.size();
		}

		return noOfSensors;
	}

	@Override
	public int getNoOfAssetsByProjectId(String projectId) {
		logger.info("inside getNoOfAssetByProjectId()");
		return this.getAssetList(projectId).size();
	}

	@Override
	public int getNoOfSensorsByAssetId(String assetId) {
		logger.info("inside getNoOfSensorsByAssetId()");
		return this.getSensorList(assetId).size();
	}

	
	
}
