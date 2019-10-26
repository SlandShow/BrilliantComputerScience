package com.slandshow.breadthfirstsearch;

import com.slandshow.breadthfirstsearch.util.bfs.BreadthFirstSearch;
import com.slandshow.breadthfirstsearch.util.graph.Node;
import com.slandshow.breadthfirstsearch.util.graph.StumpUnweightedGraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BreadthFirstSearchApplicationTests {

    private BreadthFirstSearch<String> breadthFirstSearch;
    private StumpUnweightedGraph<String> graph;
    private Node<String> root;

    @Before
    public void init() {
        createGraphWithNodes();
        breadthFirstSearch = new BreadthFirstSearch<>();
    }

    @Test
    public void searchTest() {
        breadthFirstSearch.search(root);
    }

    private void createGraphWithNodes() {
        root = new Node<>("Frankfurt");
        graph =  new StumpUnweightedGraph<>(root);

        Node<String> mannheim = new Node<>("Mannheim");
        Node<String> weinberg = new Node<>("Weinberg");
        Node<String> kassey = new Node<>("Kassey");

        Node<String> karlsruhe = new Node<>("Karsluhe");
        Node<String> numberg = new Node<>("Numberg");

        graph.setRoot(root);
        graph.add(root, mannheim, weinberg, kassey);

        graph.add(mannheim, karlsruhe);
        graph.add(weinberg, numberg, new Node<>("Erfurt"));
        graph.add(kassey, new Node<>("Munchen"));

        graph.add(karlsruhe, new Node<>("Augsburg"));
        graph.add(numberg, new Node<>("Stuttgart"));

    }
}
