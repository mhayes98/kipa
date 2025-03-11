package com.kipa.kipa.ControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserAlbumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    String testTagsEndpointRequestBody = """
                            {
                                "id": {
                                    "userID": "123",
                                    "albumID": "456"
                                },
                                "status": "Owned",
                                "tags": ["Signed"],
                                "notes": "Mid - 4/5"
                            }
                            """;

    @Test
    public void testTagsEndpoint() throws Exception {
        mockMvc.perform(post("/tag") // Simulate a POST request
                .contentType(MediaType.APPLICATION_JSON)
                .content(testTagsEndpointRequestBody))
                .andExpect(status().isOk()) // Check that it returns HTTP 200
                .andExpect(jsonPath("$.message").value("Success")); // Verify JSON response
    }
}
