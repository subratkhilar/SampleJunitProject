package net.atos.Codex_IOT.dao;

import java.util.List;

import net.atos.Codex_IOT.pojo.Customer;

public interface CustomerDao {

	public Customer findById(long id);
	
	public List<Customer> findAll();
}
