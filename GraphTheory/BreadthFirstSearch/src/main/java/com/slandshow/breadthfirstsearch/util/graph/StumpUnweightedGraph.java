package com.slandshow.breadthfirstsearch.util.graph;

import java.util.Arrays;
import java.util.List;

public class StumpUnweightedGraph<T> {
    private Node<T> root;

    public StumpUnweightedGraph() {
        this.root = null;
    }

    public StumpUnweightedGraph(Node<T> root) {
        this.root = root;
    }

    public void add(Node<T> parentNode, Node<T>... nodes) {
        Arrays.stream(nodes).forEach(
                childNode -> {
                    childNode.setParent(parentNode);
                    parentNode.addChild(childNode);
                });
    }

    public void printTree() {
        searchEachNode(root);
    }

    private void searchEachNode(Node<T> parent) {
        if (parent != null && parent.getChildren() != null) {
            System.out.print("Parent: " + parent + " ->");
            System.out.print(" [ ");
            parent.getChildren().forEach(child ->
                    System.out.print(" Child: " + child + ",")
            );
            System.out.println(" ]\n");
            childDeepLevelSearch(parent.getChildren());
        }
    }

    private void childDeepLevelSearch(List<Node<T>> children) {
        children.forEach(this::searchEachNode);
    }

    public T getNodeValue(Node<T> node) {
        return node.getValue();
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }
}
