package com.slandshow.breadthfirstsearch.util.graph;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {
    private T value;
    private Node<T> parent;
    private List<Node<T>> children;
    private boolean isVisited;

    public Node(T value) {
        this.value = value;
        this.children = new LinkedList<>();
        this.isVisited = false;
    }

    public void addChildren(List<Node<T>> children) {
        children.forEach(child -> child.setParent(this));
        this.children.addAll(children);
    }

    public void addChild(Node<T> node) {
        this.children.add(node);
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isVisited() {
        return this.isVisited;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) {
            return false;
        }
        Node another = (Node) obj;
        return this == another || this.value.equals((another.getValue()));
    }
}