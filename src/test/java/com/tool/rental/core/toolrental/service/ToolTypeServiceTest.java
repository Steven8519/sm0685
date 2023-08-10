package com.tool.rental.core.toolrental.service;

import com.tool.rental.core.toolrental.dto.ToolTypeDTO;
import com.tool.rental.core.toolrental.entity.ToolType;
import com.tool.rental.core.toolrental.repository.ToolTypeRepository;
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
public class ToolTypeServiceTest {
    @Mock
    private ToolTypeRepository toolTypeRepository;

    @InjectMocks
    private ToolTypeServiceImpl toolTypeServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testCreateToolType() {
        ToolTypeDTO toolTypeDto = new ToolTypeDTO();
        toolTypeDto.setName("Type");

        ToolType savedToolType = new ToolType();
        when(toolTypeRepository.save(any(ToolType.class))).thenReturn(savedToolType);

        ToolType createdToolType = toolTypeServiceImpl.createToolType(toolTypeDto);

        assertNotNull(createdToolType);
    }
    @Test
    public void testGetToolTypeById() {
        ToolType toolType = new ToolType();
        when(toolTypeRepository.findById(1L)).thenReturn(Optional.of(toolType));

        ToolType retrievedToolType = toolTypeServiceImpl.getToolTypeById(1L);

        assertNotNull(retrievedToolType);
    }
}

