package net.atos.Codex_IOT.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.atos.Codex_IOT.dao.UserDao;
import net.atos.Codex_IOT.mapper.Mapper;
import net.atos.Codex_IOT.model.UserData;
import net.atos.Codex_IOT.pojo.Asset;
import net.atos.Codex_IOT.pojo.Customer;
import net.atos.Codex_IOT.pojo.Role;
import net.atos.Codex_IOT.pojo.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImpTest {
	@Mock
	private UserDao userDao;

	@Mock
	private Mapper mapper;
	@InjectMocks
	private UserService userService = new UserServiceImp();

	@Test
	public void testUserServiceImp() {
		
    }
	

	@Test
	public void testGetValidateUser() {
		User user = new User();
		user.setUserId(123L);
		Customer customer = new Customer();
		customer.setCustomerId(21L);
		customer.setCustomerName("Shaym");
		user.setCustomer(customer);
		when(userDao.validateUser(user)).thenReturn(user);
		User result = userService.getValidateUser(user);
		// Validation
		assertNotNull(result);
		assertEquals(123L, result.getUserId());
	}

	@Test
	public void testGetUserByID() {
		long id =1L;
		User user = new User();
		user.setUserId(id);
		Customer customer = new Customer();
		customer.setCustomerId(21L);
		customer.setCustomerName("Shaym");
		user.setCustomer(customer);
		when(userDao.getUserById(id)).thenReturn(user);
		User result = userService.getUserByID(id);
		// Validation
		assertNotNull(result);
		assertEquals(id, result.getUserId());
		
	}

	@Test
	public void testAddUser() {
		UserData userData = new UserData();
		userData.setUserId(1L);
		userData.setUsername("ram");
		userData.setFirstname("Shyam");
		userData.setLastname("K");
		when(mapper.mapUserToUserModel(userDao.addUser(mapper.mapUserModelToUserPojo(userData)))).thenReturn(userData);
		UserData result = userService.addUser(userData);
		// Validation
		assertNotNull(result);
		//assertEquals(id, result.getUserId());
		//verify(mapper).addUser(any(Asset.class));
	}

	@Test
	public void testGetUserbyId() {
		long id =1L;
		User user = new User();
		user.setUserId(id);
		Customer customer = new Customer();
		customer.setCustomerId(21L);
		customer.setCustomerName("Shaym");
		user.setCustomer(customer);
		when(userDao.getUserbyId(id)).thenReturn(user);
		User result = userService.getUserbyId(id);
		// Validation
		assertNotNull(result);
		assertEquals(id, result.getUserId());
	}

	@Test
	public void testDeleteUsrbyId() {
		
		long id =1L;
		User user = new User();
		user.setUserId(id);
		Customer customer = new Customer();
		customer.setCustomerId(21L);
		customer.setCustomerName("Shaym");
		user.setCustomer(customer);
		when(userDao.getUserById(id)).thenReturn(user);
		when(userDao.deleteUsrbyId(user)).thenReturn(true);
		boolean result = userService.deleteUsrbyId(id);
		// Validation
		assertNotNull(result);
		
	}

	@Test
	public void testGetusersData() {
		List<User> userList = new ArrayList<User>();
		long id =1L;
		User user = new User();
		user.setUserId(id);
		Customer customer = new Customer();
		customer.setCustomerId(21L);
		customer.setCustomerName("Shaym");
		user.setCustomer(customer);
		userList.add(user);
		when(userDao.getusersData()).thenReturn(userList);
	
		List<User> results = userService.getusersData();
		assertNotNull(results);
		assertEquals(userList.size(), results.size());
	}

	@Test
	public void testUpdateuser() {
		long id =1L;
		User user = new User();
		user.setUserId(id);
		Customer customer = new Customer();
		customer.setCustomerId(21L);
		customer.setCustomerName("Shaym");
		user.setCustomer(customer);
		doNothing().when(userDao).updateuser(user);
		//when(userDao.getusersData()).thenReturn(userList);
		userService.updateuser(user);
		
	}

	@Test
	public void testSaveDeviceIdForSpecificUser() {
		long id =1L;
		User user = new User();
		user.setUserId(id);
		Customer customer = new Customer();
		customer.setCustomerId(21L);
		customer.setCustomerName("Shaym");
		user.setCustomer(customer);
		when(userDao.saveDeviceIdForSpecificUser(user)).thenReturn(true);
		boolean result = userService.saveDeviceIdForSpecificUser(user);
		// Validation
		assertNotNull(result);
	}

	@Test
	public void testGetRolebyid() {
		long roleId =1L;
		Role role = new Role();
		role.setRoleId(roleId);
		role.setRolename("admin");
		role.setRoletype("Type1");
		User user = new User();
		user.setUserId(1L);
		user.setRole(role);
		Customer customer = new Customer();
		customer.setCustomerId(21L);
		customer.setCustomerName("Shaym");
		user.setCustomer(customer);
	
		//role.addUser(user);
		when(userDao.getRolebyid(roleId)).thenReturn(role);
		Role result = userService.getRolebyid(roleId);
		// Validation
		assertNotNull(result);
		assertEquals(roleId, result.getRoleId());
	}

}
