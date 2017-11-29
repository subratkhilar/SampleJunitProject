package net.atos.Codex_IOT.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.pojo.Workflow;

/**
 * @author a634945
 *
 */
@Service
public interface WorkflowService {

	/**
	 * @param w
	 * @return
	 */
	public String save(Workflow w);
	
	/**
	 * @param id
	 * @return
	 */
	public Workflow getbyid(long id);

	/**
	 * @param w
	 * @return
	 */
	public String update(Workflow w);
	
	/**
	 * @param id
	 * @return
	 */
	public List<Workflow> getbyProjectId(String id);
	
	/**
	 * @param id
	 * @return
	 */
	public List<Workflow> getbyUserId(long userId);
	
	/**
	 * @param assetId
	 * @param eventType
	 * @return
	 */
	public List<Sensor> allSensorsforWorkflow(String assetId, String eventType);
}
