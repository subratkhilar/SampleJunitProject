package net.atos.CodexIotTest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import net.atos.CodexIotTest.service.TestMasterDataInputBuilder;
import net.atos.Codex_IOT.controller.AssetController;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;



/**
 * @author a638054
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { net.atos.Codex_IOT.config.SpringBootWebApplication.class,
		net.atos.Codex_IOT.config.DatabaseConfig.class })
public class AssetControllerTest {

	@SuppressWarnings("unused")
	private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Autowired
	private AssetController AssetController;
	TestMasterDataInputBuilder testMasterDataInputBuilder = new TestMasterDataInputBuilder();

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@Before
	public void setup() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

	}
	/// getAssetbyId/{assetId}

	@Test
	public void testAllAsset() throws Exception {

		this.mockMvc.perform(get("/Asset/allasset")).andExpect(status().is(200));

	}

	@Test
	public void testAssetById() throws Exception {

		this.mockMvc.perform(get("/Asset/getAssetbyId/{assetId}", 100)).andExpect(status().is(200));

	}

	@Test
	public void testAssetByprojId() throws Exception {

		this.mockMvc.perform(get("/Asset/getAssetbyprojId/{projectId}", 11)).andExpect(status().is(200));

	}

	@Test
	public void testAssetByProjId() throws Exception {

		this.mockMvc.perform(get("/Asset/getallAssetbyprojId/{projectId}", 11)).andExpect(status().is(200));

	}

	@Test
	public void testAssetByCustId() throws Exception {

		this.mockMvc.perform(get("/Asset/getallassetbycustid/{customerId}", 1)).andExpect(status().is(200));

	}

	@Test
	public void testUpdateActiveState() throws Exception {

		this.mockMvc.perform(get("/Asset/updateActiveState/{assetId}", 100)).andExpect(status().is(200));

	}

	
	@Test
	public void testAssetByCustomerid() throws Exception {

		this.mockMvc.perform(get("/Asset/getallassetbycustomerid/{customerId}", 1)).andExpect(status().is(200));

	}

	
	@Test
	public void testDeleteAssetById() throws Exception {
		this.mockMvc.perform(delete("/Asset/deleteAssetbyId/{assetId}", 100)).andExpect(status().is(200));
	}

	
	@Test
	public void testAddAsset() throws Exception {

		this.mockMvc.perform(
				post("/Asset/addAsset").content(this.testMasterDataInputBuilder.addAsset()).contentType(contentType))
				.andExpect(status().is(201));

	}

	
	@Test
	public void testUpdateAsset() throws Exception {

		this.mockMvc.perform(post("/Asset/updateAsset").content(this.testMasterDataInputBuilder.updateAsset())
				.contentType(contentType)).andExpect(status().is(200));

	}

}
