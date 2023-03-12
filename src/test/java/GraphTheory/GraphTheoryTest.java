//package GraphTheory;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class GraphTheoryTest {
//    private Graph underTest;
//
//
//    @Test
//    public void displayGraph(){
//        underTest = new Graph(5);
//        Vertex<Character> node1 = new Vertex<>('A');
//        Vertex<Character> node2 = new Vertex<>('B');
//        Vertex<Character> node3 = new Vertex<>('C');
//        Vertex<Character> node4 = new Vertex<>('D');
//        Vertex<Character> node5 = new Vertex<>('E');
//        underTest.addVertex(node1);
//        underTest.addVertex(node2);
//        underTest.addVertex(node3);
//        underTest.addVertex(node4);
//        underTest.addVertex(node5);
//
//        underTest.addEdge(0, 1);
//        underTest.addEdge(1, 2);
//        underTest.addEdge(2, 3);
//        underTest.addEdge(2, 4);
//        underTest.addEdge(4, 0);
//        underTest.addEdge(4, 2);
//
//        underTest.print();
//    }
//}
