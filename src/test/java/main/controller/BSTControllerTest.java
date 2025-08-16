package main.controller;

import main.entity.BSTResult;
import main.repository.BSTRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BSTControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BSTRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void testProcessNumbersEndpoint() throws Exception {
        mockMvc.perform(post("/api/process-numbers")
                .contentType("application/json")
                .content("{\"numbers\":\"5,3,7\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.inputNumbers").value("5,3,7"))
                .andExpect(jsonPath("$.inOrderTraversal").value("3,5,7"))
                .andExpect(jsonPath("$.preOrderTraversal").value("5,3,7"))
                .andExpect(jsonPath("$.postOrderTraversal").value("3,7,5"));
    }

    @Test
    void testPreviousTreesEndpoint() throws Exception {
        repository.save(new BSTResult("1,2,3", "1,2,3", "2,1,3", "1,3,2"));

        mockMvc.perform(get("/api/previous-trees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].inputNumbers").value("1,2,3"))
                .andExpect(jsonPath("$[0].inOrderTraversal").value("1,2,3"))
                .andExpect(jsonPath("$[0].preOrderTraversal").value("2,1,3"))
                .andExpect(jsonPath("$[0].postOrderTraversal").value("1,3,2"));
    }
}