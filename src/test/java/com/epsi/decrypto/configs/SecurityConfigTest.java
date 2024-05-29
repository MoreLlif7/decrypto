package com.epsi.decrypto.configs;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPublicEndpoint() throws Exception {
        mockMvc.perform(get("/api/public/test"))
               .andExpect(status().isOk());
    }

    @Test
    public void testAuthenticatedEndpointWithoutAuth() throws Exception {
        mockMvc.perform(get("/api/private/test"))
               .andExpect(status().isUnauthorized());
    }

    private RequestBuilder get(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Test
    @WithMockUser
    public void testAuthenticatedEndpointWithAuth() throws Exception {
        mockMvc.perform(get("/api/private/test"))
               .andExpect(status().isOk());
    }
}
