package net.atos.CodexIotTest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import net.atos.Codex_IOT.controller.ProjectController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={net.atos.Codex_IOT.config.SpringBootWebApplication.class,net.atos.Codex_IOT.config.DatabaseConfig.class})
public class ProjectControllerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
	
	@Autowired
	private WebApplicationContext context;
    private MockMvc mockMvc;
    private TestMasterDataInputBuilder testMasterDataInputBuilder=new TestMasterDataInputBuilder() ;
    
    @Autowired
    ProjectController projectController;
    
   
    @Before
	public void setup() {
		
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		projectController.deleteProject("113");
	}	
    
    
    
    @Test
    public void getProjectTest() throws Exception{
        this.mockMvc.perform(get("/project/get"))
		.andExpect(status().is(200));
    }

    
    
    @Test
   	public void getProjectByCustomerIdTest() throws Exception {
   		this.mockMvc.perform(get("/project/getbycustomer/{customer_id}",5))
   		.andExpect(status().is(200));
   	}  
    
    
    
   
    @Test
    public void getAllProjectByCustomerIdTest() throws Exception{
        this.mockMvc.perform(get("/project/getallbycustomer/{customer_id}",5))
		.andExpect(status().is(200));
    }
    
    
    @Test
    public void getProjectByIdTest() throws Exception{
        this.mockMvc.perform(get("/project/getbyid/{project_id}",11))
		.andExpect(status().is(200));
    }
    
    
    @Test
    public void saveProjectTest() throws Exception{
  
        this.mockMvc.perform(post("/project/save").content(this.testMasterDataInputBuilder.saveProject())
				.contentType(contentType))
		.andExpect(status().is(200));
    }
    
    
    @Test
    public void updateProjectTest() throws Exception{
  
        this.mockMvc.perform(put("/project/update/{project_id}",11).content(this.testMasterDataInputBuilder.updateProject())
				.contentType(contentType))
		.andExpect(status().is(200));
    }
    
    
    @Test
    public void deleteProjectTest() throws Exception{
        this.mockMvc.perform(delete("/project/delete/{project_id}",11))
		.andExpect(status().is(200));
    }
    
    
    @Test
    public void getProjectDetailsByIdTest() throws Exception{
        this.mockMvc.perform(get("/project/getProjectDetails/{project_id}",11))
		.andExpect(status().is(200));
    }
    
    
    
    @Test
    public void updateSensorActiveStateTest() throws Exception{
        this.mockMvc.perform(get("/project/updateActiveState/{projectId}",11))
		.andExpect(status().is(200));
    }
   
    
}
