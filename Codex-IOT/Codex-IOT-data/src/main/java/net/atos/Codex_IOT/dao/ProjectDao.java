package net.atos.Codex_IOT.dao;

import java.util.List;

import net.atos.Codex_IOT.pojo.Project;


/**
 * @author a622890
 *
 */
public interface ProjectDao {
	
	/**
	 * @param p
	 * @return
	 */
	public String saveProject(Project p);

	/**
	 * @param p
	 * @return
	 */
	public String updateProject(Project p);
	
	/**
	 * @param id
	 * @return
	 */
	public String deleteProject(String id);
	
	/**
	 * @param id
	 * @return
	 */
	public List<Project> findByCustomerId(long id);
	
	/**
	 * @param id
	 * @return
	 */
	public List<Project> findAllByCustomerId(long id);
	
	/**
	 * @param id
	 * @return
	 */
	public Project findProjectById(String id);
	
	/**
	 * @return
	 */
	public List<Project> findAll();


}
