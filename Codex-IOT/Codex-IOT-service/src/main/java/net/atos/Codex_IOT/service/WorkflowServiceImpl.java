package net.atos.Codex_IOT.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.atos.Codex_IOT.dao.WorkflowDao;
import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.pojo.Workflow;

/**
 * @author a634945
 *
 */
@Transactional
@Repository
public class WorkflowServiceImpl implements WorkflowService {

	@Autowired
	private WorkflowDao dao;
	
	@Override
	public String save(Workflow w) {
		return dao.save(w);
	}

	@Override
	public String update(Workflow w){
		return dao.update(w);
	}
	
	@Override
	public Workflow getbyid(long id){
		return dao.getbyid(id);
	}
	
	@Override
	public List<Workflow> getbyProjectId(String id){
		return dao.getbyProjectId(id);
	}
	
	@Override
	public List<Workflow> getbyUserId(long userId){
		return dao.getbyUserId(userId);
	}


	@Override
	public List<Sensor> allSensorsforWorkflow(String assetId, String eventType) {
		return dao.allSensorsforWorkflow(assetId, eventType);
	}
	
	
}
