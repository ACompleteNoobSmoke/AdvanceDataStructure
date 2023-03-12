package GraphTheory;

import java.util.Comparator;
import java.util.Set;

public class GraphMatrix<T> implements Comparator<Edge<? super  T>> {
    private Set<Vertex<T>> vertices;
    private Set<Edge<T>> edges;
    private int[][] matrix;

    public GraphMatrix(Set vertices, Set edges, int size){
        this.vertices = vertices;
        this.edges = edges;
        matrix = new int[size][size];
    }

    public void addVertices(Vertex newVertex){
        vertices.add(newVertex);
    }

    public void addEdge(Edge newEdge){
        edges.add(newEdge);
        if(!checkEdge(newEdge))
            addEdgeToMatrix(newEdge);
    }

    private void addEdgeToMatrix(Edge newEdge){
        matrix[newEdge.getStartPoint()][newEdge.getEndPoint()] = 1;
    }

    public boolean checkEdge(Edge checkThis){
        return matrix[checkThis.getStartPoint()][checkThis.getEndPoint()] == 1;
    }

    public void print(){
        System.out.print("  ");
        vertices.forEach(v -> System.out.print(v.getData() + " "));
        System.out.println();

        T[] vertArr =  (T[])new Object[vertices.size()];
        vertArr = vertices.toArray(vertArr);

        for (int i = 0; i < matrix.length; i++){
            System.out.print(vertArr[i] + " ");
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public int compare(Edge<? super T> o1, Edge<? super T> o2) {
        return 0;
    }
}
