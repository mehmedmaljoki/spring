package com.mehmedmaljoki.testingspringbootwithmockmvc;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class TestingSpringBootWithMockmvcApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldAllowDeletingReviewsWhenUserIsAdmin() throws Exception {
        this.mockMvc
                .perform(
                        delete("/api/tasks/42")
                                .with(
                                        SecurityMockMvcRequestPostProcessors.user("mehmed").roles("ADMIN", "SUPER_USER"))
                                .with(csrf()))
                .andExpect(status().isOk());
    }
}
