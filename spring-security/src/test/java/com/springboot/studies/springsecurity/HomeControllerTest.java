package com.springboot.studies.springsecurity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {

    // @Autowired
    // private TestRestTemplate template;

    @Autowired
    private MockMvc mockMvc;

    // @Test
    // public void hello_ok() throws Exception {
    // ResponseEntity<String> response = template.withBasicAuth("teste",
    // "password").getForEntity("/", String.class);
    // assertThat(response.getBody()).isEqualTo(null);
    // }

    @Test
    @DisplayName("Should authenticate user")
    @WithMockUser
    void helloOk() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world user"));
    }

    @Test
    @DisplayName("Should fail to authenticate user")
    void helloUnauthorized() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }
}
