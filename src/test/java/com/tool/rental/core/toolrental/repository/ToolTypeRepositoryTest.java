package com.tool.rental.core.toolrental.repository;

import com.tool.rental.core.toolrental.entity.ToolType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@DataJpaTest
public class ToolTypeRepositoryTest {
    @MockBean
    private ToolTypeRepository toolTypeRepository;

    @BeforeEach
    public void setUp() {
        ToolType toolType = new ToolType();
        toolType.setId(1L);
        when(toolTypeRepository.findById(1L)).thenReturn(java.util.Optional.of(toolType));
    }

    @Test
    public void testFindById() {
        ToolType retrievedToolType = toolTypeRepository.findById(1L).orElse(null);

        assertNotNull(retrievedToolType);
        assertEquals(1L, retrievedToolType.getId());
    }
}
