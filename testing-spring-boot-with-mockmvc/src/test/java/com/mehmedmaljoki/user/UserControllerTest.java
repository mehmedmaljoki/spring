package com.mehmedmaljoki.user;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mehmedmaljoki.SecurityConfig;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;

@Import(SecurityConfig.class)
@WebMvcTest(UserController.class) // add only UserController to the context
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // another way of injecting mvc and having full control over the context
//    creating the mockMvc instance on our own
//    @Autowired
//    private WebApplicationContext context;
//
//    @BeforeEach
//    void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(springSecurity()).build();
//    }

    // another way usnig standalone setup
//    @BeforeEach
//    void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController(null)).build();
//    }

    @MockBean
    private UserService userService;

    @Test
    void shouldReturnCreatedMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    void shouldReturnListOfUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(List.of(new User("mehmed", "mehmed@spring.io")));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/users")
                        .header("X-Foo", "Mehmed"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("mehmed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("mehmed@spring.io"));

    }

    @Test
    void shouldReturnAllUsersForUnauthenticatedUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(List.of(new User("mehmed", "mehmed@spring.io")));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("mehmed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("mehmed@spring.io"));
    }

    @Test
    void shouldReturn404WhenUserIsNotFound() throws Exception {
        when(userService.getUserByUsername("mehmed"))
                .thenThrow(new UserNotFoundException("mehmed is not found"));

        this.mockMvc.perform(get("/api/users/mehmed")).andExpect(status().isNotFound());
    }

    @Test
    void shouldAllowCreationForUnauthenticatedUsers() throws Exception {
        this.mockMvc
                .perform(
                        post("/api/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"username\": \"mehmed\", \"email\":\"mehmed@spring.io\"}")
                                .with(csrf()))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.containsString("mehmed")));

        verify(userService).storeNewUser(any(User.class));
    }
}
