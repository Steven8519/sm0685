package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.ToolDTO;
import com.tool.rental.core.toolrental.entity.Tool;
import com.tool.rental.core.toolrental.repository.ToolRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ToolServiceTest {

    @Mock
    private ToolRepository toolRepository;

    @InjectMocks
    private ToolServiceImpl toolServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateTool() {
        ToolDTO toolDto = new ToolDTO();
        toolDto.setToolCode("JAKR");
        toolDto.setToolType("Type");
        toolDto.setBrand("Brand");
        toolDto.setDailyCharge(10.0);

        Tool savedTool = new Tool();
        when(toolRepository.save(any(Tool.class))).thenReturn(savedTool);

        Tool createdTool = toolServiceImpl.createTool(toolDto);

        assertNotNull(createdTool);
    }

    @Test
    public void testGetToolById() {
        Tool tool = new Tool();
        when(toolRepository.findById(1L)).thenReturn(Optional.of(tool));

        Tool retrievedTool = toolServiceImpl.getToolById(1L);

        assertNotNull(retrievedTool);
    }
}
