package com.tool.rental.core.toolrental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tool.rental.core.toolrental.entity.Tool;
import com.tool.rental.core.toolrental.service.ToolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(ToolController.class)
public class ToolControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ToolService toolService;

    @Test
    public void testGetAllTools() throws Exception {
        Tool tool = new Tool();
        tool.setToolCode("JAKR");
        tool.setToolType("Type1");
        // Set other fields

        List<Tool> toolList = Collections.singletonList(tool);

        doReturn(toolList).when(toolService).getAllTools();

        mockMvc.perform(get("/tools"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].toolCode").value("JAKR"))
                .andExpect(jsonPath("$[0].toolType").value("Type1"));
    }
}
