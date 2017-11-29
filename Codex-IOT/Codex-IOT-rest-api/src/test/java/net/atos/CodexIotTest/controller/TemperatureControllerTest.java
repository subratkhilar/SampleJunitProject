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
public class TemperatureControllerTest {

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
    public void getTemperatureByIdTest() throws Exception{
        this.mockMvc.perform(get("/temperature/get/{sensor_id}",1))
		.andExpect(status().is(200));
    }
    
    
    @Test
    public void getTemperatureTest() throws Exception{
        this.mockMvc.perform(get("/temperature/get"))
		.andExpect(status().is(200));
    }
    
	
    @Test
    public void saveTemperatureTest() throws Exception{
        
    	
			this.mockMvc.perform(post("/temperature/save/{sensor_id}",6).content(this.testMasterDataInputBuilder.saveTemperature())
					.contentType(contentType))
			.andExpect(status().is(200));   	
    }
    
    
	
}
