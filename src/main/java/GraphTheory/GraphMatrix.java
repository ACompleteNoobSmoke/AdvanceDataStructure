package GraphTheory;

import java.util.*;

public class GraphMatrix<T> implements Comparable<Edge<? super Edge<T>>>{
    private Set<Vertex<T>> vertices;
    private Set<Edge<T>> edges;
    Comparator<Vertex<T>> comparator;
    private int[][] matrix;

    public GraphMatrix(Set<Vertex<T>> vertices, Set<Edge<T>> edges, int size){
        this.vertices = vertices;
        this.edges = edges;
        this.matrix = new int[size][size];
        comparator = Comparator.comparingInt(Vertex::getGraphPoint);
    }

    public void addVertices(Vertex<T> newVertex){
        vertices.add(newVertex);
    }

    public void addEdge(Edge<T> newEdge){
        edges.add(newEdge);
        addEdgeToMatrix(newEdge);
    }

    private void addEdgeToMatrix(Edge<T> newEdge){
        int src = newEdge.getStartVertex().getGraphPoint();
        int dest = newEdge.getEndVertex().getGraphPoint();
        matrix[src][dest] = 1;
    }

    public boolean checkEdge(T src, T dest){
        for (Edge<T> edge: edges){
            T start = edge.getStartVertex().getData();
            T end = edge.getEndVertex().getData();
            if (start.equals(src) && end.equals(dest))
                return true;
        }
        return false;
    }

    public boolean checkMatrix(int src, int dest){
        return matrix[src][dest] == 1;
    }

    public void print(){
        List<Vertex<T>> headerList = vertices.stream().sorted(comparator).toList();
        System.out.print("  ");
        headerList.forEach(h -> System.out.print(h.getData() + " "));
        System.out.println();

        for (int i = 0; i < matrix.length; i++){
            System.out.print(headerList.get(i).getData() + " ");
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public int compareTo(Edge<? super Edge<T>> o) {
        return compareTo(o);
    }
}