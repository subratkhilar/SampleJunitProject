package net.atos.CodexIotTest.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.atos.CodexIotTest.service.TestMasterDataInputBuilder;

import org.springframework.http.MediaType;
import java.nio.charset.Charset;
import org.junit.Before;
import org.junit.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={net.atos.Codex_IOT.config.SpringBootWebApplication.class,net.atos.Codex_IOT.config.DatabaseConfig.class})
public class WorkFlowControllerTest {
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	@Autowired
	private WebApplicationContext context;
    private MockMvc mockMvc;
    private TestMasterDataInputBuilder testMasterDataInputBuilder=new TestMasterDataInputBuilder() ;
    
   
    @Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}	
    
    @Test
  public void getbyIdTest() throws Exception{
	  this.mockMvc.perform(get("/service_crud_workflow/getDataByWorkflowID/{workflow_id}",59))
		.andExpect(status().is(200));
  }   
    
    @Test
    public void getbyUserIdTest() throws Exception{
  	  this.mockMvc.perform(get("/service_crud_workflow/getWorkflowByUserID/{user_id}",210))
  		.andExpect(status().is(200));
    }   
    
    
    @Test
    public void saveWorkflowTest() throws Exception{
  	 
  	  
  	this.mockMvc.perform(post("/service_crud_workflow/saveWorkflowData").content(this.testMasterDataInputBuilder.saveWorkFlowData())
			.contentType(contentType))
	.andExpect(status().is(200)); 
  	  
  	  
    }   
    
    
    
    @Test
    public void allSensorsforWorkflowTest() throws Exception{
  	  this.mockMvc.perform(get("/service_crud_workflow/getSensorsForWorkflowByAssetID/{asset_id}/{event_type}",103,"notification"))
  		.andExpect(status().is(200));
    }   
    
    

}
