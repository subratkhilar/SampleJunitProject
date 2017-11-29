package net.atos.CodexIotTest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
public class SensorControllerTest {
	
	
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
    public void getSensorsDataTest() throws Exception{
        this.mockMvc.perform(get("/sensor/get"))
		.andExpect(status().is(200));
    }
    
    @Test
    public void getSensorByIdTest() throws Exception{
        this.mockMvc.perform(get("/sensor/getbyid/{sensor_id}",1))
		.andExpect(status().is(200));
    }

    @Test
    public void getSensorByAssetIdTest() throws Exception{
        this.mockMvc.perform(get("/sensor/getbyassetid/{asset_id}",103))
		.andExpect(status().is(200));
    }
    
    @Test
    public void getallSensorByAssetIdTest() throws Exception{
        this.mockMvc.perform(get("/sensor/getallsensorbyassetid/{asset_id}",104))
		.andExpect(status().is(200));
    }
    
    
    @Test
    public void getSensorByCustomerIdTest() throws Exception{
        this.mockMvc.perform(get("/sensor/getbycustomerid/{customer_id}",4))
		.andExpect(status().is(200));
    }
    
    @Test
    public void saveSensorTest() throws Exception{
  
        this.mockMvc.perform(post("/sensor/save").content(this.testMasterDataInputBuilder.saveSensor())
				.contentType(contentType))
		.andExpect(status().is(200));
    }
    
    @Test
    public void updateSensorTest() throws Exception{
  
        this.mockMvc.perform(put("/sensor/update/{sensor_id}",1).content(this.testMasterDataInputBuilder.updateSensor())
				.contentType(contentType))
		.andExpect(status().is(200));
    }
    
    @Test
    public void deleteSensorTest() throws Exception{
        this.mockMvc.perform(delete("/sensor/delete/{sensor_id}",1))
		.andExpect(status().is(200));
    }
    
    @Test
    public void updateSensorActiveStateTest() throws Exception{
        this.mockMvc.perform(get("/sensor/updateActiveState/{sensorId}",1))
		.andExpect(status().is(200));
    }
    
    @Test
    public void getallbycustomerIdTest() throws Exception{
        this.mockMvc.perform(get("/sensor/getallbycustomerid/{customer_id}",4))
		.andExpect(status().is(200));
    }
    
    @Test
    public void getallSensorByCustomerIdTest() throws Exception{
        this.mockMvc.perform(get("/sensor/getallsensorbycustomerid/{customer_id}",4))
		.andExpect(status().is(200));
    }
    
    @Test
    public void getallSensorCustomerIdTrueTest() throws Exception{
        this.mockMvc.perform(get("/sensor/getallsensorbycustomeridTrue/{customer_id}",4))
		.andExpect(status().is(200));
    }

}
