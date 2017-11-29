package net.atos.Codex_IOT.service;

import java.util.List;

import net.atos.Codex_IOT.model.ProjectDto;
import net.atos.Codex_IOT.pojo.Project;
import net.atos.Codex_IOT.pojo.ProjectMapping;
import net.atos.Codex_IOT.pojo.User;

/**
 * @author a622890
 *
 */
public interface ProjectService {

	/**
	 * @param p
	 */
	public void save(Project p);
	
	/**
	 * @param p
	 */
	public void update(Project p);
	
	/**
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * @return
	 */
	public List<Project> get();
	
	/**
	 * @param id
	 * @return
	 */
	public Project findProjectById(String id);
	
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
	 * @param projectId
	 * @return
	 */
	public ProjectDto findProjectDetails(String projectId);

	/**
	 * @param projectId
	 */
	public void updateProjectActiveState(String projectId);
}
