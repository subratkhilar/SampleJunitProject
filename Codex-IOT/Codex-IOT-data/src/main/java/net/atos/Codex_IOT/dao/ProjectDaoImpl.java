package net.atos.Codex_IOT.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.atos.Codex_IOT.pojo.Project;



/**
 * @author a622890
 *
 */
@Transactional
@Repository
public class ProjectDaoImpl implements ProjectDao {

	/**
	 * 
	 */
	@Autowired
	public SessionFactory sessionFactory;
	
	
	
	
	@Override
	public String saveProject(Project p){
		
		sessionFactory.getCurrentSession().save(p);
		return "success";
		
	}
	
	@Override
	public String updateProject(Project p){
		sessionFactory.getCurrentSession().saveOrUpdate(p);
		return "success";
	}
	
	@Override
	public String deleteProject(String id) {
		sessionFactory.getCurrentSession().createQuery("update Project p set isActive = false where p.projectId=:id").setParameter("id", id).executeUpdate();
		sessionFactory.getCurrentSession().createQuery("update Asset a set isActive = false where a.project.projectId =:id").setParameter("id", id).executeUpdate();
		if(sessionFactory.getCurrentSession().createQuery("update Sensor s set s.isActive = false where s.asset.assetId IN(select a.assetId from Asset a where a.isActive = false)").executeUpdate()!=0)
		return "success";
		else
		return "failure";
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Project> findByCustomerId(long id){
		

		return (List<Project>)sessionFactory.getCurrentSession().createQuery("select c from Project c where c.customer.customerId = :id and c.isActive = true order by c.createdDate desc").setParameter("id", id).list();


	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Project> findAllByCustomerId(long id){
		

		return (List<Project>)sessionFactory.getCurrentSession().createQuery("select c from Project c where c.customer.customerId = :id order by c.createdDate desc").setParameter("id", id).list();


	}
	
	@Override
	public Project findProjectById(String id){
		return sessionFactory.getCurrentSession().get(Project.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
    public List<Project> findAll(){
		

		return (List<Project>)sessionFactory.getCurrentSession().createQuery("select c from Project c where c.isActive = true order by c.createdDate desc").list();


	}

	
	
}
