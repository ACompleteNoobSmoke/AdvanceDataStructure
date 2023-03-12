package GraphTheory;

import java.util.*;

public class GraphMatrix<T> implements Comparator<Edge<? super  T>> {
    List<T> data;
    private Set<Vertex<T>> vertices;
    private Set<Edge<T>> edges;
    private int[][] matrix;

    public GraphMatrix(Set vertices, Set edges, int size){
        data = new ArrayList<>();
        this.vertices = vertices;
        this.edges = edges;
        matrix = new int[size][size];
    }

    public void addVertices(Vertex<T> newVertex){
        vertices.add(newVertex);
        data.add(newVertex.getData());
    }

    public void addEdge(Edge<T> newEdge){
        edges.add(newEdge);
        if(!checkEdge(newEdge))
            addEdgeToMatrix(newEdge);
    }

    private void addEdgeToMatrix(Edge<T> newEdge){
        matrix[newEdge.getStartPoint()][newEdge.getEndPoint()] = 1;
    }

    public boolean checkEdge(Edge<T> checkThis){
        return matrix[checkThis.getStartPoint()][checkThis.getEndPoint()] == 1;
    }

    public void print(){
        System.out.print("  ");
        //vertices.stream().sorted().forEach(v -> System.out.print(v.getData() + " "));
        Comparator<Vertex<T>> comp = new Comparator<Vertex<T>>() {
            @Override
            public int compare(Vertex<T> o1, Vertex<T> o2) {
                return o1.getPoint() - o2.getPoint();
            }
        };
        vertices.stream().sorted(comp).forEach(v -> System.out.print(v.getData() + " "));
        System.out.println();


        for (int i = 0; i < matrix.length; i++){
            System.out.print(data.get(i) + " ");
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
