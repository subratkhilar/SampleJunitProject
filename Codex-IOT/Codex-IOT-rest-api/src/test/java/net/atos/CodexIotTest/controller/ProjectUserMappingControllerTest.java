package net.atos.CodexIotTest.controller;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes={net.atos.Codex_IOT.config.SpringBootWebApplication.class,net.atos.Codex_IOT.config.DatabaseConfig.class})
public class ProjectUserMappingControllerTest {
	
	
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
    public void saveProjectmapTest() throws Exception{
  
        this.mockMvc.perform(post("/projectusermap/saveprojmap").content(this.testMasterDataInputBuilder.saveProjectmap())
				.contentType(contentType))
		.andExpect(status().is(200));
    }
    
    
    
    @Test
    public void getprojectAdminbycustomerTest() throws Exception{
        this.mockMvc.perform(get("/projectusermap/getprojectAdminbycustomer/{customer_id}",2))
		.andExpect(status().is(200));
    }
    
    
    @Test
    public void getProjectbyUserIdTest() throws Exception{
        this.mockMvc.perform(get("/projectusermap/getProjectbyUser/{user_id}",210))
		.andExpect(status().is(200));
    }
    
    
    
    @Test
    public void getProjectbyUserProjectIdTest() throws Exception{
        this.mockMvc.perform(get("/projectusermap/getUserbyProject/{project_id}",11))
		.andExpect(status().is(200));
    }
    
    
    @Test
    public void updateProjectMapTest() throws Exception{
  
        this.mockMvc.perform(put("/projectusermap/updateProjectMap").content(this.testMasterDataInputBuilder.updateProjectMap())
				.contentType(contentType))
		.andExpect(status().is(200));
    }
    

}
