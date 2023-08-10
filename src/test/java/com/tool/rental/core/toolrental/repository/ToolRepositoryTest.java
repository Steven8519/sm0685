package com.tool.rental.core.toolrental.repository;

import com.tool.rental.core.toolrental.entity.Tool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@DataJpaTest
class ToolRepositoryTest {
    @MockBean
    private ToolRepository toolRepository;

    @BeforeEach
    public void setUp() {
        Tool tool = new Tool();
        tool.setId(1L);
        when(toolRepository.findById(1L)).thenReturn(java.util.Optional.of(tool));
    }

    @Test
    public void testFindById() {
        Tool retrievedTool = toolRepository.findById(1L).orElse(null);

        assertNotNull(retrievedTool);
        assertEquals(1L, retrievedTool.getId());
    }
}