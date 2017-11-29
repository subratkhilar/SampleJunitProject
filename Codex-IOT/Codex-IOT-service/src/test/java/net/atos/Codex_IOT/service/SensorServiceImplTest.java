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

import net.atos.Codex_IOT.dao.SensorDao;
import net.atos.Codex_IOT.pojo.Asset;
import net.atos.Codex_IOT.pojo.Customer;
import net.atos.Codex_IOT.pojo.Project;
import net.atos.Codex_IOT.pojo.Sensor;

@RunWith(MockitoJUnitRunner.class)
public class SensorServiceImplTest {
	@Mock
	private SensorDao sensordao;
	@InjectMocks
	SensorService sensorService = new SensorServiceImpl();

	@Test
	public void testGetSensor() {
		List<Sensor> sensorList = new ArrayList<Sensor>();
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		sensorList.add(sensor);
		when(sensordao.getSensors()).thenReturn(sensorList);
		// Execute the method being tested
		List<Sensor> newSensorList = sensorService.getSensor();
		// Validation
		assertNotNull(newSensorList);
		assertEquals(sensorList.size(), newSensorList.size());
		
	}

	@Test
	public void testGetSensorByAssetId() {
		List<Sensor> sensorList = new ArrayList<Sensor>();
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		sensorList.add(sensor);
		when(sensordao.getSensorsByAssetId("SN001")).thenReturn(sensorList);
		List<Sensor> newSensorList = sensorService.getSensorByAssetId("SN001");
		// Validation
		assertNotNull(newSensorList);
		assertEquals(sensorList.size(), newSensorList.size());
		
		
	}

	@Test
	public void testGetSensorsByCustomerId() {
		long customerId =12L;
		List<Sensor> sensorList = new ArrayList<Sensor>();
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		sensorList.add(sensor);
	/*	Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName("Ram");*/
		
		when(sensordao.getSensorsByCustomerId(customerId)).thenReturn(sensorList);
		List<Sensor> newSensorList = sensorService.getSensorsByCustomerId(customerId);
		// Validation
		assertNotNull(newSensorList);
		assertEquals(sensorList.size(), newSensorList.size());
		
	}
	

	@Test
	public void testUpdateSensorActiveState() {
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		
		String assetId="As001";
		Asset asset = new Asset();
		asset.setAssetId(assetId);
		asset.setAssetDesc("test desc");
		asset.setAssetName("Test asset");
		asset.setActive(true);
		sensor.setAsset(asset);
		when(sensordao.getSensorById("SN001")).thenReturn(sensor);
		when(sensordao.updateSensor(sensor)).thenReturn("success");
		sensorService.updateSensorActiveState("SN001");
	}
	@Test
	public void testUpdateSensorInActiveState() {
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(false);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		
		String assetId="As001";
		Asset asset = new Asset();
		asset.setAssetId(assetId);
		asset.setAssetDesc("test desc");
		asset.setAssetName("Test asset");
		asset.setActive(true);
		sensor.setAsset(asset);
		when(sensordao.getSensorById("SN001")).thenReturn(sensor);
		when(sensordao.updateSensor(sensor)).thenReturn("success");
		sensorService.updateSensorActiveState("SN001");
	}
	@Test
	public void testSaveSensor() {
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		
		String assetId="As001";
		Asset asset = new Asset();
		asset.setAssetId(assetId);
		asset.setAssetDesc("test desc");
		asset.setAssetName("Test asset");
		asset.setActive(true);
		sensor.setAsset(asset);
		when(sensordao.saveSensor(sensor)).thenReturn(sensor);
		// Execute the method being tested
		Sensor result = sensorService.saveSensor(sensor);
		assertEquals("SN001", result.getSensorId());
		verify(sensordao).saveSensor(any(Sensor.class));
	}

	@Test
	public void testGetSensorById() {
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		
		String assetId="As001";
		Asset asset = new Asset();
		asset.setAssetId(assetId);
		asset.setAssetDesc("test desc");
		asset.setAssetName("Test asset");
		asset.setActive(true);
		sensor.setAsset(asset);
		when(sensordao.getSensorById("SN001")).thenReturn(sensor);
		// Execute the method being tested
		Sensor result = sensorService.getSensorById("SN001");
		assertEquals("SN001", result.getSensorId());
		
	}

	@Test
	public void testUpdateSensor() {
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		
		String assetId="As001";
		Asset asset = new Asset();
		asset.setAssetId(assetId);
		asset.setAssetDesc("test desc");
		asset.setAssetName("Test asset");
		asset.setActive(true);
		sensor.setAsset(asset);
		// Mockito expectations
		when(sensordao.updateSensor(any(Sensor.class))).thenReturn("success");
		// Execute the method being tested
		String result = sensorService.updateSensor(sensor);
		assertEquals("success", result);
		verify(sensordao).updateSensor(any(Sensor.class));
	}

	@Test
	public void testGetallSensorsByCustomerId() {
		long customerId =12L;
		List<Sensor> sensorList = new ArrayList<Sensor>();
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		
		String assetId="As001";
		Asset asset = new Asset();
		asset.setAssetId(assetId);
		asset.setAssetDesc("test desc");
		asset.setAssetName("Test asset");
		asset.setActive(true);
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName("Ram");
		sensor.setAsset(asset);
		sensorList.add(sensor);
		
		when(sensordao.getallSensorsByCustomerId(customerId)).thenReturn(sensorList);
		List<Sensor> newSensorList = sensorService.getallSensorsByCustomerId(customerId);
		// Validation
		assertNotNull(newSensorList);
		assertEquals(sensorList.size(), newSensorList.size());
	}

	@Test
	public void testGetallSensorByAssetId() {
		List<Sensor> sensorList = new ArrayList<Sensor>();
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		
		String assetId="As001";
		Asset asset = new Asset();
		asset.setAssetId(assetId);
		asset.setAssetDesc("test desc");
		asset.setAssetName("Test asset");
		asset.setActive(true);
		sensor.setAsset(asset);
		sensorList.add(sensor);
		when(sensordao.getallSensorsByAssetId(assetId)).thenReturn(sensorList);
		List<Sensor> newSensorList = sensorService.getallSensorByAssetId(assetId);
		// Validation
		assertNotNull(newSensorList);
		assertEquals(sensorList.size(), newSensorList.size());
	}

	@Test
	public void testGetallSensorCustomerIdTrue() {
		long customerId =12L;
		List<Sensor> sensorList = new ArrayList<Sensor>();
		Sensor sensor = new Sensor();
		sensor.setSensorId("SN001");
		sensor.setActive(true);
		sensor.setCreatedDate(new Date());
		sensor.setSensorDescription("test desc");
		sensor.setSensorsName("test Sensor");
		sensor.setSensorDatatype("TYPE1");
		sensor.setSensorSerialNumber("SL001");
		sensor.setUpdatedDate(new Date());
		sensorList.add(sensor);
	/*	Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName("Ram");*/
		
		when(sensordao.getallSensorCustomerIdTrue(customerId)).thenReturn(sensorList);
		List<Sensor> newSensorList = sensorService.getallSensorCustomerIdTrue(customerId);
		// Validation
		assertNotNull(newSensorList);
		assertEquals(sensorList.size(), newSensorList.size());
	}

}
