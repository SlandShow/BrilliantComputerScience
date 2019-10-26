package com.slandshow.breadthfirstsearch.util.bfs;

import com.slandshow.breadthfirstsearch.util.graph.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearch<T> {

    private Queue<Node<T>> queue;

    public BreadthFirstSearch() {
        queue = new ArrayDeque<>();
    }

    public void search(Node<T> start) {
        queue.add(start);
        start.setVisited(true);

        while (!queue.isEmpty()) {
            Node<T> next = queue.remove();
            System.out.print(next + "\t");
            next.getChildren().forEach(neighbour -> {
                if (neighbour != null && !neighbour.isVisited()) {
                    queue.add(neighbour);
                    neighbour.setVisited(true);
                }
            });
        }
    }

}
