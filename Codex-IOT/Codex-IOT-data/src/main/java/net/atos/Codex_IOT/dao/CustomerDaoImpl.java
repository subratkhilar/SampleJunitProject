package net.atos.Codex_IOT.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.atos.Codex_IOT.pojo.Customer;


@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	public Customer findById(long id) {
		
		return (Customer)sessionFactory.getCurrentSession().createQuery("select c from Customer c where c.customerId = :id ").setParameter("id", id).uniqueResult();
	}
	
	public List<Customer> findAll() {
		
		return (List<Customer>)sessionFactory.getCurrentSession().createQuery("select c from Customer c").list();
	}
	
}
