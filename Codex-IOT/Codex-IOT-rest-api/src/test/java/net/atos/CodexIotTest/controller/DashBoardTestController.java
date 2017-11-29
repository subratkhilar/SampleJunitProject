package net.atos.CodexIotTest.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import java.nio.charset.Charset;
import org.junit.Before;
import org.junit.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={net.atos.Codex_IOT.config.SpringBootWebApplication.class,net.atos.Codex_IOT.config.DatabaseConfig.class})
public class DashBoardTestController {

	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	@Autowired
	private WebApplicationContext context;
    private MockMvc mockMvc;
    
   
    @Before
	public void setup() {
		
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}	
    
    
    
    @Test
	public void getNoOfPrjojectsByCustIdTest() throws Exception {
		this.mockMvc.perform(get("/dashboard/getNoOfProjects/{customerId}",4))
		.andExpect(status().is(200));
	}  
	
    @Test
	public void getNoOfAssetsByCustIdTest() throws Exception {
		this.mockMvc.perform(get("/dashboard/getNoOfAssets/{customerId}",4))
		.andExpect(status().is(200));
	}  
    
    @Test
	public void getNoOfSensorsByCustIdTest() throws Exception {
		this.mockMvc.perform(get("/dashboard/getNoOfSensors/{customerId}",4))
		.andExpect(status().is(200));
	}  
   
    
    @Test
	public void getNoOfAssetsByProjIdTest() throws Exception {
		this.mockMvc.perform(get("/dashboard/getNoOfAssetsByProjectId/{projectId}",4))
		.andExpect(status().is(200));
	}  
    
    @Test
	public void getNoOfSensorsByAssetIdTest() throws Exception {
		this.mockMvc.perform(get("/dashboard/getNoOfSensorsByAssetId/{assetId}",4))
		.andExpect(status().is(200));
	}  
    
	
}
