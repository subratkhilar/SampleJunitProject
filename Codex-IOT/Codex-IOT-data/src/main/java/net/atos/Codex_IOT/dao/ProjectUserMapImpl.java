package net.atos.Codex_IOT.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import net.atos.Codex_IOT.pojo.ProjectMapping;
import net.atos.Codex_IOT.pojo.User;


@Transactional
@Repository
public class ProjectUserMapImpl implements ProjectUserMap {
	
	@Autowired
	public SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getprojectAdminbycustomer(long customer_id) {
		
		return sessionFactory.getCurrentSession().createQuery("select u from User u where u.role.roleId = 2 and u.customer.customerId =:customer_id").setParameter("customer_id", customer_id).list();
	}

	@Override
	public void  saveprojmap(ProjectMapping p) {
		
		this.sessionFactory.getCurrentSession().save(p);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectMapping> getProjectList(long id) {
		
		return sessionFactory.getCurrentSession().createQuery("select p from ProjectMapping p where p.user.userId =:id ").setParameter("id", id).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectMapping> getUser(String projectId) {
		return sessionFactory.getCurrentSession().createQuery("select p from ProjectMapping p where p.project.projectId =:id ").setParameter("id",projectId).list();
	}

	@Override
	public ProjectMapping getProjectMappingByProjectId(String projectmappingid) {
		return (ProjectMapping) sessionFactory.getCurrentSession().createQuery("select p from ProjectMapping p where p.project.projectId =:id ").setParameter("id", projectmappingid).uniqueResult();
	}

	@Override
	public boolean updateProjectMapping(ProjectMapping projectMapping) {
		this.sessionFactory.getCurrentSession().update(projectMapping);
		return true;
	}


}
