package net.atos.Codex_IOT.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.pojo.Workflow;

/**
 * @author a634945
 *
 */
@Repository
public class WorkflowDaoImpl implements WorkflowDao {

	@Autowired 
	private SessionFactory sessionfactory;

	@Override
	public String save(Workflow w) {

		if (sessionfactory.getCurrentSession().save(w)!=null)
			return "success";
		else 
			return "failure";
	}

	@Override
	public String update(Workflow w) {

		sessionfactory.getCurrentSession().saveOrUpdate(w);
		return "success";
		}


	@Override
	public Workflow getbyid(long id){
		return sessionfactory.getCurrentSession().get(Workflow.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Workflow> getbyProjectId(String id){
		return sessionfactory.getCurrentSession().createQuery("select w from Workflow w  where w.project.projectId =:id").setParameter("id",id).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Workflow> getbyUserId(long userId){
		return sessionfactory.getCurrentSession().createQuery("select w from Workflow w where w.user.userId =:userId").setParameter("userId",userId).list();
	}


	@Override
	public List<Sensor> allSensorsforWorkflow(String assetId, String eventType) {
		List<Sensor> sensorsForWorkflow=new ArrayList<Sensor>();
		List<Sensor> sensors = this.getAllActiveSensors(assetId);
		for (Sensor sensor : sensors) {
			if (!this.isSensorAssignedToWorkflow(sensor, eventType)) {
				sensorsForWorkflow.add(sensor);
			}
		}

		return sensorsForWorkflow;
	}

	/**
	 * @param assetId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Sensor> getAllActiveSensors(String assetId) {
		return sessionfactory.getCurrentSession()
				.createQuery("SELECT s FROM Sensor s where s.asset.assetId = :assetId and s.isActive = true")
				.setParameter("assetId", assetId).list();
	}

	/**
	 * @param sensor
	 * @param eventType
	 * @return
	 */
	private boolean isSensorAssignedToWorkflow(Sensor sensor, String eventType) {
		Long noOfWorkflow = (Long) sessionfactory.getCurrentSession()
				.createQuery(
						"SELECT count(1) FROM Workflow w where w.sensor.sensorId = :sensorId and w.eventType= :eventType")
				.setParameter("sensorId", sensor.getSensorId()).setParameter("eventType", eventType).uniqueResult();
		
		return noOfWorkflow == 0? false:true;

		
	}

}
