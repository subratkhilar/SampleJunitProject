package net.atos.Codex_IOT.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
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

import net.atos.Codex_IOT.dao.AssetDao;
import net.atos.Codex_IOT.mapper.AssetMapper;
import net.atos.Codex_IOT.pojo.Asset;
import net.atos.Codex_IOT.pojo.Customer;
import net.atos.Codex_IOT.pojo.Project;

@RunWith(MockitoJUnitRunner.class)
public class AssetServiceImplTest {
	@Mock
	private AssetDao astdao;
	@Mock
	AssetMapper astmaper;

	@InjectMocks
	private AssetService assertService = new AssetServiceImpl();

	@Test
	public void testGetassetList() {
		List<Asset> list = new ArrayList<Asset>();
		Asset asset1 = new Asset();
		asset1.setAssetId("As001");
		asset1.setAssetDesc("test1");
		list.add(asset1);
		when(astdao.getassetList()).thenReturn(list);
		List<Asset> results = assertService.getassetList();
		assertEquals(1, results.size());

	}

	@Test
	public void testGetAssetbyId() {
		Asset asset1 = new Asset();
		asset1.setAssetId("As001");
		asset1.setAssetDesc("test1");

		when(astdao.getAssetbyId("As001")).thenReturn(asset1);
		Asset newAsset = assertService.getAssetbyId("As001");
		// Validation
		assertNotNull(newAsset);
		assertEquals("As001", newAsset.getAssetId());

	}

	@Test
	public void testDeleteAssetbyId() {
		Asset asset = new Asset();
		asset.setAssetId("As001");
		//when(astdao.deleteAssetbyId(asset)).thenReturn(true);
		when(astdao.getAssetbyId("As001")).thenReturn(asset);
		Asset assetid=astdao.getAssetbyId("As001");
		boolean result = assertService.deleteAssetbyId("As001");
		boolean flag =astdao.deleteAssetbyId(assetid);
		System.out.println("result >> " + result);
		 assertFalse(result);
		
		 //assertTrue(flag);

	}
	@Test
	public void testDeleteAssetbyId_failure() {
		Asset asset = new Asset();
		asset.setAssetId("As001");
		when(astdao.deleteAssetbyId(asset)).thenReturn(true);
		boolean result = assertService.deleteAssetbyId("As001");
		 assertFalse(result);
		
		 //assertTrue(flag);

	}
	@Test
	public void testUpdateasset() {
		Asset asset = new Asset();
		asset.setAssetId("As001");
		when(astdao.getAssetbyId("As001")).thenReturn(asset);
		/* when(astdao.updateasset(asset)).thenReturn("");*/
		assertService.updateasset(asset);
		doNothing().when(astdao).updateasset(asset);
	}

	@Test
	public void testAddAsset() {
		Asset asset = new Asset();
		String assetId = "As001";
		asset.setAssetId(assetId);
		// Mockito expectations
		when(astdao.addAsset(any(Asset.class))).thenReturn(asset);
		// Execute the method being tested
		Asset newAsset = assertService.addAsset(asset);
		// Validation
		assertNotNull(newAsset);
		assertEquals(assetId, newAsset.getAssetId());
		verify(astdao).addAsset(any(Asset.class));
	}

	@Test
	public void testGetAssetbyprojId() {
		Asset asset = new Asset();
		asset.setAssetId("As001");
		asset.setAssetDesc("test1");
		asset.setActive(true);
		asset.setAssetIpAddress("162.16.10.2");
		asset.setAssetName("test");
		asset.setAssetProtocol("protocol1");
		asset.setAssetSerialNumber("Ts001");
		asset.setCreatedDate(new Date());
		asset.setUpdatedDate(new Date());
		Project project = new Project();
		project.setProjectId("pr001");
		project.setProjectDescription("CodexIOT");
		project.setProjectLocation("Bangalore");
		asset.setProject(project);
		List<Asset> assetList = new ArrayList<>();
		assetList.add(asset);
		when(astdao.getAssetbyprojId("pr001")).thenReturn(assetList);
		List<Asset> newAssetList = assertService.getAssetbyprojId("pr001");
		assertNotNull(newAssetList);
		assertEquals("As001", newAssetList.get(0).getAssetId());
		assertEquals(assetList, newAssetList);

	}

	@Test
	public void testUpdateAssetActiveState() {
		Asset asset = new Asset();
		asset.setAssetId("As001");
		when(astdao.getAssetbyId("As001")).thenReturn(asset);
		assertService.updateAssetActiveState("As001");
		doNothing().when(astdao).updateasset(asset);

	}
	@Test
	public void testUpdateAssetActiveState_Active() {
		Asset asset = new Asset();
		asset.setAssetId("As001");
		asset.setActive(true);
		when(astdao.getAssetbyId("As001")).thenReturn(asset);
		assertService.updateAssetActiveState("As001");
		doNothing().when(astdao).updateasset(asset);

	}
	@Test
	public void testGetallassetbycustomerid() {
		Asset asset = new Asset();
		asset.setAssetId("As001");
		asset.setAssetDesc("test1");
		asset.setActive(true);
		asset.setAssetIpAddress("162.16.10.2");
		asset.setAssetName("test");
		asset.setAssetProtocol("protocol1");
		asset.setAssetSerialNumber("Ts001");
		asset.setCreatedDate(new Date());
		asset.setUpdatedDate(new Date());
		Project project = new Project();
		project.setProjectId("pr001");
		project.setProjectDescription("CodexIOT");
		project.setProjectLocation("Bangalore");
		Customer customer = new Customer();
		customer.setCustomerId(1001L);
		customer.setCustomerName("Hari");
		customer.setCustomerNumbere(1);
		customer.setActive(true);
		project.setCustomer(customer);
		asset.setProject(project);
		List<Asset> assetList = new ArrayList<>();
		assetList.add(asset);
		when(astdao.getallassetbycustomerid(1001L)).thenReturn(assetList);
		List<Asset> newAssetList = assertService.getallassetbycustomerid(1001L);
		assertNotNull(newAssetList);
		assertEquals("As001", newAssetList.get(0).getAssetId());
		assertEquals(assetList, newAssetList);
	}

	@Test
	public void testGetallassetbycustid() {
		Asset asset = new Asset();
		asset.setAssetId("As001");
		asset.setAssetDesc("test1");
		asset.setActive(true);
		asset.setAssetIpAddress("162.16.10.2");
		asset.setAssetName("test");
		asset.setAssetProtocol("protocol1");
		asset.setAssetSerialNumber("Ts001");
		asset.setCreatedDate(new Date());
		asset.setUpdatedDate(new Date());
		Project project = new Project();
		project.setProjectId("pr001");
		project.setProjectDescription("CodexIOT");
		project.setProjectLocation("Bangalore");
		Customer customer = new Customer();
		customer.setCustomerId(1001L);
		customer.setCustomerName("Hari");
		customer.setCustomerNumbere(1);
		customer.setActive(true);
		project.setCustomer(customer);
		asset.setProject(project);
		List<Asset> assetList = new ArrayList<>();
		assetList.add(asset);
		when(astdao.getallassetbycustid(1001L)).thenReturn(assetList);
		List<Asset> newAssetList = assertService.getallassetbycustid(1001L);
		assertNotNull(newAssetList);
		assertEquals("As001", newAssetList.get(0).getAssetId());
		assertEquals(assetList, newAssetList);
	}

	@Test
	public void testGetallAssetbyprojId() {
		Asset asset = new Asset();
		asset.setAssetId("As001");
		asset.setAssetDesc("test1");
		asset.setActive(true);
		asset.setAssetIpAddress("162.16.10.2");
		asset.setAssetName("test");
		asset.setAssetProtocol("protocol1");
		asset.setAssetSerialNumber("Ts001");
		asset.setCreatedDate(new Date());
		asset.setUpdatedDate(new Date());
		Project project = new Project();
		project.setProjectId("pr001");
		project.setProjectDescription("CodexIOT");
		project.setProjectLocation("Bangalore");
		asset.setProject(project);
		List<Asset> assetList = new ArrayList<>();
		assetList.add(asset);
		when(astdao.getallAssetbyprojId("pr001")).thenReturn(assetList);
		List<Asset> newAssetList = assertService.getallAssetbyprojId("pr001");
		assertNotNull(newAssetList);
		assertEquals("As001", newAssetList.get(0).getAssetId());
		assertEquals(assetList, newAssetList);
	}

}
