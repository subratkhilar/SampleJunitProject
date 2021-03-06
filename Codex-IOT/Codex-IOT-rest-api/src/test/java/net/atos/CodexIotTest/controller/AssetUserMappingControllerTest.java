package net.atos.CodexIotTest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import org.springframework.web.context.WebApplicationContext;

import net.atos.CodexIotTest.service.TestMasterDataInputBuilder;
import net.atos.Codex_IOT.controller.AssetUserMappingController;

/**
 * @author a638054
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { net.atos.Codex_IOT.config.SpringBootWebApplication.class,
		net.atos.Codex_IOT.config.DatabaseConfig.class })
public class AssetUserMappingControllerTest {

	@SuppressWarnings("unused")
	private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Autowired
	private AssetUserMappingController AssetUserMappingController;
	TestMasterDataInputBuilder testMasterDataInputBuilder = new TestMasterDataInputBuilder();

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@Before
	public void setup() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

	}


	@Test
	public void getAssetByUserID() throws Exception {

		this.mockMvc.perform(get("/assetusermap/getAssetbyUserID/{user_id}", 210)).andExpect(status().is(200));

	}

	@Test
	public void testSaveAssetmap() throws Exception {

		this.mockMvc.perform(post("/assetusermap/saveAssetmap").content(this.testMasterDataInputBuilder.saveAssetmap())
				.contentType(contentType)).andExpect(status().is(200));
	}

}
