package main.controller;

import main.entity.BSTResult;
import main.service.BSTService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BSTController {

    private final BSTService service;

    public BSTController(BSTService service) {
        this.service = service;
    }

    @PostMapping("/process-numbers")
    public BSTResult processNumbers(@RequestBody Map<String, String> payload) {
        String numbers = payload.get("numbers");
        return service.processNumbers(numbers);
    }

    @GetMapping("/previous-trees")
    public List<BSTResult> previousTrees() {
        return service.getAllResults();
    }
}