package net.atos.Codex_IOT.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.atos.Codex_IOT.dao.CustomerDao;
import net.atos.Codex_IOT.pojo.Asset;
import net.atos.Codex_IOT.pojo.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
	@Mock
	CustomerDao dao;
	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();

	@Test
	public void testFindById() {
		Customer customer = new Customer();
		customer.setCustomerId(1001L);
		customer.setCustomerName("Amit");
		customer.setActive(true);
		customer.setCustomerLocation("BLR");
		when(dao.findById(1001L)).thenReturn(customer);
		Customer newCustomer = customerService.findById(1001L);
		// Validation
		assertNotNull(newCustomer);
		assertEquals(1001L, newCustomer.getCustomerId());

		// fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<Customer> list = new ArrayList<Customer>();
		Customer customer = new Customer();
		customer.setCustomerId(1001L);
		customer.setCustomerName("Amit");
		customer.setActive(true);
		customer.setCustomerLocation("BLR");
		list.add(customer);
		when(dao.findAll()).thenReturn(list);
		List<Customer> results = customerService.findAll();
		assertNotNull(results);
		assertEquals(1001L, results.get(0).getCustomerId());
		assertEquals(1, results.size());
		// fail("Not yet implemented");
	}

}
