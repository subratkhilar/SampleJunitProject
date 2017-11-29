package net.atos.Codex_IOT.service;

import java.util.List;


import net.atos.Codex_IOT.pojo.ProjectMapping;
import net.atos.Codex_IOT.pojo.User;

/**
 * @author a622890
 *
 */
public interface ProjectMapService {

	/**
	 * @param customer_id
	 * @return
	 */
	public List<User> getprojectAdminbycustomer(long customer_id);

	/**
	 * @param p
	 */
	public void saveprojmap(ProjectMapping p);
	
	/**
	 * @param id
	 * @return
	 */
	public List<ProjectMapping> getProjectList(long id);

	/**
	 * @param project_id
	 * @return
	 */
	public List<ProjectMapping> getUser(String project_id);

	/**
	 * @param m
	 * @return
	 */
	public boolean updateProjectMapping(ProjectMapping m);


	
}
