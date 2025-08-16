package main.entity;

import jakarta.persistence.*;

@Entity
public class BSTResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inputNumbers;
    private String inOrderTraversal;
    private String preOrderTraversal;
    private String postOrderTraversal;

    public BSTResult() {}

    public BSTResult(String inputNumbers, String inOrderTraversal,
                     String preOrderTraversal, String postOrderTraversal) {
        this.inputNumbers = inputNumbers;
        this.inOrderTraversal = inOrderTraversal;
        this.preOrderTraversal = preOrderTraversal;
        this.postOrderTraversal = postOrderTraversal;
    }

    public Long getId() { return id; }

    public String getInputNumbers() { return inputNumbers; }
    public void setInputNumbers(String inputNumbers) { this.inputNumbers = inputNumbers; }

    public String getInOrderTraversal() { return inOrderTraversal; }
    public void setInOrderTraversal(String inOrderTraversal) { this.inOrderTraversal = inOrderTraversal; }

    public String getPreOrderTraversal() { return preOrderTraversal; }
    public void setPreOrderTraversal(String preOrderTraversal) { this.preOrderTraversal = preOrderTraversal; }

    public String getPostOrderTraversal() { return postOrderTraversal; }
    public void setPostOrderTraversal(String postOrderTraversal) { this.postOrderTraversal = postOrderTraversal; }
}