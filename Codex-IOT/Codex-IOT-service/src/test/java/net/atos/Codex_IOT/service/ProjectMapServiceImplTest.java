package net.atos.Codex_IOT.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

import net.atos.Codex_IOT.dao.ProjectDao;
import net.atos.Codex_IOT.dao.ProjectUserMap;
import net.atos.Codex_IOT.dao.ProjectUserMapImpl;
import net.atos.Codex_IOT.pojo.Asset;
import net.atos.Codex_IOT.pojo.Customer;
import net.atos.Codex_IOT.pojo.Project;
import net.atos.Codex_IOT.pojo.ProjectMapping;
import net.atos.Codex_IOT.pojo.Role;
import net.atos.Codex_IOT.pojo.User;

@RunWith(MockitoJUnitRunner.class)
public class ProjectMapServiceImplTest {
	@Mock
	private ProjectUserMap projectMappingDao;

	@Mock
	private ProjectDao projectDao;
	
	@InjectMocks
	private ProjectMapService projectMappingService = new ProjectMapServiceImpl();

	@Test
	public void testGetprojectAdminbycustomer() {
		long customerId = 1L;
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setUserId(12L);
		user.setPassword("123");
		user.setFirstname("Amit");
		user.setLastname("Kumar");
		user.setUsername("Amit123");
		user.setDeviceToken("123");
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName("Shaym");
		user.setCustomer(customer);
		Role role = new Role();
		role.setRoleId(2);
		role.setRolename("admin");
		user.setRole(role);
		userList.add(user);
		
		when(projectMappingDao.getprojectAdminbycustomer(customerId)).thenReturn(userList);
		List<User> results = projectMappingService.getprojectAdminbycustomer(customerId);
		// Validation
		assertNotNull(results);
		assertEquals(1, results.size());
	}

	@Test
	public void testSaveprojmap() {
		ProjectMapping projectMapp = new ProjectMapping();
		projectMapp.setProjectmappingid(1L);
		Project project = new Project();
		project.setProjectName("testproject");
		project.setProjectDescription("test Desc");
		project.setActive(true);
		projectMapp.setProject(project);
		User user = new User();
		user.setUserId(12L);
		user.setPassword("123");
		user.setFirstname("Amit");
		user.setLastname("Kumar");
		user.setUsername("Amit123");
		user.setDeviceToken("123");
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerName("Shaym");
		projectMapp.setUser(user);
		projectMappingService.saveprojmap(projectMapp);
		doNothing().when(projectMappingDao).saveprojmap(projectMapp);

		verify(projectMappingDao).saveprojmap(any(ProjectMapping.class));
	}

	@Test
	public void testGetProjectList() {
		List<ProjectMapping> projList = new ArrayList<>();
		ProjectMapping projectMapp = new ProjectMapping();
		projectMapp.setProjectmappingid(1L);
		Project project = new Project();
		project.setProjectName("testproject");
		project.setProjectDescription("test Desc");
		project.setActive(true);
		projectMapp.setProject(project);
		User user = new User();
		user.setUserId(12L);
		user.setPassword("123");
		user.setFirstname("Amit");
		user.setLastname("Kumar");
		user.setUsername("Amit123");
		user.setDeviceToken("123");
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerName("Shaym");
		projectMapp.setUser(user);
		projList.add(projectMapp);
		when(projectMappingDao.getProjectList(12L)).thenReturn(projList);
		List<ProjectMapping> resultpmList = projectMappingService.getProjectList(12L);
		assertNotNull(resultpmList);
		assertEquals(1, resultpmList.size());
	}

	@Test
	public void testGetUser() {
		List<ProjectMapping> projList = new ArrayList<>();
		ProjectMapping projectMapp = new ProjectMapping();
		projectMapp.setProjectmappingid(1L);
		Project project = new Project();
		project.setProjectName("testproject");
		project.setProjectId("Pl001");
		project.setProjectDescription("test Desc");
		project.setActive(true);
		projectMapp.setProject(project);
		User user = new User();
		user.setUserId(12L);
		user.setPassword("123");
		user.setFirstname("Amit");
		user.setLastname("Kumar");
		user.setUsername("Amit123");
		user.setDeviceToken("123");
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerName("Shaym");
		projectMapp.setUser(user);
		projList.add(projectMapp);
		when(projectMappingDao.getUser("Pl001")).thenReturn(projList);
		List<ProjectMapping> resultpmList = projectMappingService.getUser("Pl001");
		assertNotNull(resultpmList);
		assertEquals(1, resultpmList.size());
	}

	@Test
	public void testUpdateProjectMapping() {
		ProjectMapping projectMapp = new ProjectMapping();
		projectMapp.setProjectmappingid(1L);
		Project project = new Project();
		project.setProjectName("testproject");
		project.setProjectId("Pl001");
		project.setProjectDescription("test Desc");
		project.setActive(true);
		projectMapp.setProject(project);
		User user = new User();
		user.setUserId(12L);
		user.setPassword("123");
		user.setFirstname("Amit");
		user.setLastname("Kumar");
		user.setUsername("Amit123");
		user.setDeviceToken("123");
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerName("Shaym");
		projectMapp.setUser(user);
		
		//when(astdao.deleteAssetbyId(asset)).thenReturn(true);
		when(projectMappingDao.updateProjectMapping(projectMapp)).thenReturn(true);
	
		boolean result = projectMappingService.updateProjectMapping(projectMapp);
	
		// assertFalse(result);
	}

}
