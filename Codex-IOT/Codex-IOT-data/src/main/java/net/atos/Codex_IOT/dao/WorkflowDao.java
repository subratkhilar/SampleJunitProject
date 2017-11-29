package net.atos.Codex_IOT.dao;

import java.util.List;

import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.pojo.Workflow;




 /**
 * @author a634945
 *
 */

public interface WorkflowDao {

	/**
	 * @param w
	 * @return
	 */
	public String save(Workflow w);
	
	/**
	 * @param w
	 * @return
	 */
	public String update(Workflow w);
	
	/**
	 * @param id
	 * @return
	 */
	public Workflow getbyid(long id);
	
	/**
	 * @param id
	 * @return
	 */
	public List<Workflow> getbyProjectId(String id);
	
	/**
	 * @param id
	 * @return
	 */
	public List<Workflow> getbyUserId(long id);

	/**
	 * @param assetId
	 * @param eventType
	 * @return
	 */
	public List<Sensor> allSensorsforWorkflow(String assetId, String eventType);
}
