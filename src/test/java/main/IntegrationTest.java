package main;

import main.entity.BSTResult;
import main.repository.BSTRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IntegrationTest {

    @Autowired
    private BSTRepository repository;

    @Test
    void testRepositorySavesAndFindsData() {
        // Provide all four fields now
        BSTResult saved = repository.save(new BSTResult(
                "1,3,2",
                "1,2,3",
                "1,3,2",
                "3,2,1"
        ));

        BSTResult found = repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("BSTResult not found"));

        assertEquals("1,2,3", found.getInOrderTraversal());
        assertEquals("1,3,2", found.getPreOrderTraversal());
        assertEquals("3,2,1", found.getPostOrderTraversal());
        assertEquals("1,3,2", found.getInputNumbers());
    }
}