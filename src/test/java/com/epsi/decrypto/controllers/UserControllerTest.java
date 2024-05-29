package com.epsi.decrypto.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epsi.decrypto.entites.Users;
import com.epsi.decrypto.services.UserService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private Users user;

    @BeforeEach
    public void setUp() {
        user = new Users();
        user.setId(1L);
        user.setName("Test User");
    }

    @Test
    public void testCreateUser() throws Exception {
        when(userService.createUser(any(Users.class))).thenReturn(user);

        mockMvc.perform(post("/api/public/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(user.getId()))
                .andExpect(jsonPath("$.name").value(user.getName()));
        
        verify(userService, times(1)).createUser(any(Users.class));
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<Users> users = Arrays.asList(user);
        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/api/public/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(user.getId()))
                .andExpect(jsonPath("$[0].name").value(user.getName()));

        verify(userService, times(1)).getAllUsers();
    }
}
