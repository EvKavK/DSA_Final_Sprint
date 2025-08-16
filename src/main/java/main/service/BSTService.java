package main.service;

import main.entity.BSTResult;
import main.repository.BSTRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BSTService {

    private final BSTRepository repository;

    public BSTService(BSTRepository repository) {
        this.repository = repository;
    }

    public BSTResult processNumbers(String numbers) {
        BinarySearchTree bst = new BinarySearchTree();
        for (String token : numbers.split(",")) {
            try {
                bst.insert(Integer.parseInt(token.trim()));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + token);
            }
        }

        String inOrder = joinList(bst.inOrderTraversal());
        String preOrder = joinList(bst.preOrderTraversal());
        String postOrder = joinList(bst.postOrderTraversal());

        BSTResult result = new BSTResult(numbers, inOrder, preOrder, postOrder);
        repository.save(result);
        return result;
    }

    private String joinList(List<Integer> list) {
        return list.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    public List<BSTResult> getAllResults() {
        return repository.findAll();
    }
}
