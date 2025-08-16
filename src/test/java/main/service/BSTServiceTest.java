package main.service;

import main.entity.BSTResult;
import main.repository.BSTRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BSTServiceTest {

    private BSTService service;
    private BSTRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(BSTRepository.class);
        service = new BSTService(repository);
    }

    @Test
    void testProcessNumbersCreatesCorrectInOrder() {
        String input = "5,3,7";
        BSTResult result = service.processNumbers(input);

        assertEquals("5,3,7", result.getInputNumbers());
        assertEquals("3,5,7", result.getInOrderTraversal());

        verify(repository, times(1)).save(any(BSTResult.class));
    }

    @Test
    void testInvalidNumbersAreIgnored() {
        String input = "10,abc,2";
        BSTResult result = service.processNumbers(input);

        assertEquals("10,abc,2", result.getInputNumbers());
        assertEquals("2,10", result.getInOrderTraversal());

        verify(repository, times(1)).save(any(BSTResult.class));
    }

    @Test
    void testGetAllResultsCallsRepository() {
        service.getAllResults();
        verify(repository, times(1)).findAll();
    }
}