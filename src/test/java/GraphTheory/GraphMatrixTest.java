package GraphTheory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class GraphMatrixTest {
    private GraphMatrix<Character> underTest;

    @BeforeEach
    public void setUp(){
        underTest = new GraphMatrix<>(new HashSet<>(), new HashSet<>(), 6);
        addVerticesAndEdges();
    }

    private void addVerticesAndEdges(){
        Vertex<Character> vertex1 = new Vertex<>('A', 0);
        Vertex<Character> vertex2 = new Vertex<>('B', 1);
        Vertex<Character> vertex3 = new Vertex<>('C', 2);
        Vertex<Character> vertex4 = new Vertex<>('D', 3);
        Vertex<Character> vertex5 = new Vertex<>('E', 4);
        Vertex<Character> vertex6 = new Vertex<>('F', 5);

        Edge<Character> edge1 = new Edge<>(vertex1, vertex2);
        Edge<Character> edge2 = new Edge<>(vertex2, vertex6);
        Edge<Character> edge3 = new Edge<>(vertex3, vertex1);
        Edge<Character> edge4 = new Edge<>(vertex4, vertex2);
        Edge<Character> edge5 = new Edge<>(vertex2, vertex4);
        Edge<Character> edge6 = new Edge<>(vertex6, vertex3);

        underTest.addVertices(vertex1);
        underTest.addVertices(vertex2);
        underTest.addVertices(vertex3);
        underTest.addVertices(vertex4);
        underTest.addVertices(vertex5);
        underTest.addVertices(vertex6);

        underTest.addEdge(edge1);
        underTest.addEdge(edge2);
        underTest.addEdge(edge3);
        underTest.addEdge(edge4);
        underTest.addEdge(edge5);
        underTest.addEdge(edge6);
    }

    @Test
    public void graphTest1(){
        underTest.print();
    }

    @Test
    public void dfsSearchTest(){
        underTest.DFS('A');
    }
}
