package main.service;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private TreeNode root;

    private static class TreeNode {
        int value;
        TreeNode left, right;
        TreeNode(int value) { this.value = value; }
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (value < node.value) node.left = insertRecursive(node.left, value);
        else if (value > node.value) node.right = insertRecursive(node.right, value);
        return node;
    }

    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        traverseInOrder(root, result);
        return result;
    }

    private void traverseInOrder(TreeNode node, List<Integer> result) {
        if (node != null) {
            traverseInOrder(node.left, result);
            result.add(node.value);
            traverseInOrder(node.right, result);
        }
    }

    public List<Integer> preOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        traversePreOrder(root, result);
        return result;
    }

    private void traversePreOrder(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            traversePreOrder(node.left, result);
            traversePreOrder(node.right, result);
        }
    }

    public List<Integer> postOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        traversePostOrder(root, result);
        return result;
    }

    private void traversePostOrder(TreeNode node, List<Integer> result) {
        if (node != null) {
            traversePostOrder(node.left, result);
            traversePostOrder(node.right, result);
            result.add(node.value);
        }
    }
}