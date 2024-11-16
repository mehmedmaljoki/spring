package com.mehmedmaljoki.task;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.mehmedmaljoki.SecurityConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Import(SecurityConfig.class)
@WebMvcTest(TaskController.class) 
class TaskControllerSecondTest {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private TaskService taskService;

    protected MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).apply(springSecurity()).build();
    }

    @Test
    void shouldRejectDeletingReviewsWhenUserIsNotAdmin() throws Exception {
        this.mockMvc.perform(delete("/api/tasks/42").with(csrf())).andExpect(status().isUnauthorized());
    }

    @Test
    void shouldAllowDeletingReviewsWhenUserIsAdmin() throws Exception {
        this.mockMvc
                .perform(
                        delete("/api/tasks/42")
                                .with(
                                        SecurityMockMvcRequestPostProcessors.user("duke").roles("ADMIN", "SUPER_USER"))
                                .with(csrf()))
                .andExpect(status().isOk());
    }
}
