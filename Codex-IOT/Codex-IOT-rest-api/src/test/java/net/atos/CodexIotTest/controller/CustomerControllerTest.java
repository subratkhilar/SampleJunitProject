package net.atos.CodexIotTest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import net.atos.Codex_IOT.controller.CustomerController;;



/**
 * @author a638054
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { net.atos.Codex_IOT.config.SpringBootWebApplication.class,
		net.atos.Codex_IOT.config.DatabaseConfig.class })
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.properties")
public class CustomerControllerTest {

	@SuppressWarnings("unused")
	private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Autowired
	private CustomerController CustomerController;
	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setup() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

	}

	@Test
	public void testCustomerById() throws Exception {

		this.mockMvc.perform(get("/customer/getCustomerbyId/{customer_id}", 5)).andExpect(status().is(200));

	}

	@Test
	public void testAllCustomerList() throws Exception {

		this.mockMvc.perform(get("/customer/getallCustomerList")).andExpect(status().is(200));

	}
}
