package net.atos.Codex_IOT.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.atos.Codex_IOT.dao.WorkflowDao;
import net.atos.Codex_IOT.pojo.Asset;
import net.atos.Codex_IOT.pojo.Customer;
import net.atos.Codex_IOT.pojo.Project;
import net.atos.Codex_IOT.pojo.Sensor;
import net.atos.Codex_IOT.pojo.Workflow;

@RunWith(MockitoJUnitRunner.class)
public class WorkflowServiceImplTest {
	@Mock
	private WorkflowDao dao;
	@InjectMocks
	private WorkflowService workFlowService = new WorkflowServiceImpl();

	@Test
	public void testSave() {
		Workflow workFlow = new Workflow();
		workFlow.setActive(true);
		workFlow.setCreatedDate(new Date());
		Project project = new Project();
		project.setProjectName("testproject");
		project.setProjectDescription("test Desc");
		project.setActive(true);
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerName("Shaym");
		project.setUpdatedDate(new Date());
		project.setCustomer(customer);
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		workFlow.setCustomer(customer);
		workFlow.setProject(project);
		workFlow.setSensor(sensor);
		when(dao.save(any(Workflow.class))).thenReturn("success");
		// Execute the method being tested
		String result = workFlowService.save(workFlow);
		assertEquals("success", result);
		verify(dao).save(any(Workflow.class));

	}

	@Test
	public void testUpdate() {
		Workflow workFlow = new Workflow();
		workFlow.setActive(true);
		workFlow.setCreatedDate(new Date());
		Project project = new Project();
		project.setProjectName("testproject");
		project.setProjectDescription("test Desc");
		project.setActive(true);
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerName("Shaym");
		project.setUpdatedDate(new Date());
		project.setCustomer(customer);
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		workFlow.setCustomer(customer);
		workFlow.setProject(project);
		workFlow.setSensor(sensor);
		when(dao.update(any(Workflow.class))).thenReturn("success");
		// Execute the method being tested
		String result = workFlowService.update(workFlow);
		assertEquals("success", result);
		verify(dao).update(any(Workflow.class));
	}

	@Test
	public void testGetbyid() {
		Workflow workFlow = new Workflow();
		workFlow.setActive(true);
		workFlow.setCreatedDate(new Date());
		Project project = new Project();
		project.setProjectName("testproject");
		project.setProjectDescription("test Desc");
		project.setActive(true);
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerName("Shaym");
		project.setUpdatedDate(new Date());
		project.setCustomer(customer);
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		workFlow.setCustomer(customer);
		workFlow.setProject(project);
		workFlow.setSensor(sensor);
		long id =1L;
		when(dao.getbyid(id)).thenReturn(workFlow);
		// Execute the method being tested
		Workflow result = workFlowService.getbyid(id);
		
		
	}

	@Test
	public void testGetbyProjectId() {
		List<Workflow> list = new ArrayList<Workflow>();
		Workflow workFlow = new Workflow();
		workFlow.setActive(true);
		workFlow.setCreatedDate(new Date());
		String projectId="pl001";
		Project project = new Project();
		project.setProjectName("testproject");
		project.setProjectDescription("test Desc");
		project.setActive(true);
		project.setProjectId(projectId);
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerName("Shaym");
		project.setUpdatedDate(new Date());
		project.setCustomer(customer);
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		workFlow.setCustomer(customer);
		workFlow.setProject(project);
		workFlow.setSensor(sensor);
		list.add(workFlow);
		when(dao.getbyProjectId(projectId)).thenReturn(list);
		List<Workflow> workFlowList = workFlowService.getbyProjectId(projectId);
		assertNotNull(workFlowList);
		assertEquals(list, workFlowList);
		
	}

	@Test
	public void testGetbyCustomerId() {
		List<Workflow> list = new ArrayList<Workflow>();
		Workflow workFlow = new Workflow();
		workFlow.setActive(true);
		workFlow.setCreatedDate(new Date());
		long customerId =1L;
		String projectId="pl001";
		Project project = new Project();
		project.setProjectName("testproject");
		project.setProjectDescription("test Desc");
		project.setActive(true);
		project.setProjectId(projectId);
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName("Shaym");
		project.setUpdatedDate(new Date());
		project.setCustomer(customer);
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		workFlow.setCustomer(customer);
		workFlow.setProject(project);
		workFlow.setSensor(sensor);
		list.add(workFlow);
		when(dao.getbyUserId(customerId)).thenReturn(list);
		List<Workflow> workFlowList = workFlowService.getbyUserId(customerId);
		assertNotNull(workFlowList);
		assertEquals(list, workFlowList);
	}

	@Test
	public void testAllSensorsforWorkflow() {
		List<Sensor> sensorList = new ArrayList<>();
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		String assetId ="AS001";
		 String eventType="Type1";
		 Asset asset = new Asset();
		 asset.setAssetId(assetId);
		 asset.setActive(true);
		 asset.setAssetDesc("test desc");
		 sensor.setAsset(asset);
		sensorList.add(sensor);
		when(dao.allSensorsforWorkflow(assetId,eventType)).thenReturn(sensorList);
		List<Sensor> resultList = workFlowService.allSensorsforWorkflow(assetId,eventType);
		assertNotNull(resultList);
		assertEquals(sensorList.size(), resultList.size());
	}

}
