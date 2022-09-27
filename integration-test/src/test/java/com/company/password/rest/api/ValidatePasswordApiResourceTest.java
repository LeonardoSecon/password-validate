package com.company.password.rest.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ValidatePasswordApiResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void validatePasswordTrueAndThenStatus200()
            throws Exception {
        String password = "AbTp9!fok";
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/validate/validate-password")
                        .contentType(MediaType.TEXT_PLAIN)
                .content(password))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }


}
