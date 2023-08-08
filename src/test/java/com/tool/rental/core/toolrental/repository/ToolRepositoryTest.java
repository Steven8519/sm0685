package com.tool.rental.core.toolrental.repository;

import com.tool.rental.core.toolrental.entity.Tool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@SpringJUnitConfig
@ActiveProfiles("test")
class ToolRepositoryTest {
    @Autowired
    private ToolRepository toolRepository;

    private Tool tool;

    @BeforeEach
    public void setUp() {
        Tool tool = new Tool();
        tool.setToolType("Hammer");
        tool.setToolCode("HAM123");
        tool.setToolBrand("ExampleBrand");

        this.tool = toolRepository.save(tool);
    }

    @AfterEach
    public void tearDown() {
        toolRepository.deleteAll();
    }

    @Test
    void testSavedToolAttributes() {
        Tool retrievedTool = toolRepository.findById(tool.getId()).orElse(null);

        assertNotNull(retrievedTool);
        assertEquals("Hammer", retrievedTool.getToolType());
        assertEquals("HAM123", retrievedTool.getToolCode());
        assertEquals("ExampleBrand", retrievedTool.getToolBrand());
    }

    @Test
    public void testRetrieveAllTools() {
        Tool hammer = new Tool();
        hammer.setToolCode("LMH452");
        hammer.setToolType("Hammer");
        hammer.setToolBrand("Black & Decker");
        toolRepository.saveAll(List.of(hammer));

        List<Tool> tools = toolRepository.findAll();

        assertEquals(2, tools.size());
        assertTrue(tools.stream().anyMatch(tool -> tool.getToolCode().equals("LMH452")));
    }
}