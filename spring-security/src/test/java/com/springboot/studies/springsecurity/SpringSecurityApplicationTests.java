package com.springboot.studies.springsecurity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SpringSecurityApplicationTests {

	@Autowired
  	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test 
	@DisplayName("When endpoint is called without authentication, it should return 401")
	void whenEndpointIsCalledWithoutAuthenticationItShouldReturn401() throws Exception {
		mockMvc.perform(get("/"))
		.andExpect(status().isUnauthorized());
	}
	
	@Test 
	@DisplayName("When endpoint is called with authentication, it should return 200")
	void whenEndpointIsCalledWithAuthenticationItShouldReturn200()
	{

	}

	@Test
	@DisplayName("When endpoint is called with authentication but wrong password, it should return 403 Forbidden")
	@WithMockUser(authorities = "wrong")
	void whenEndpointIsCalledWithAuthenticationButWrongPasswordItShouldReturn403Forbidden() throws Exception {
		mockMvc.perform(get("/admin"))
		.andExpect(status().isForbidden());
    }

}
