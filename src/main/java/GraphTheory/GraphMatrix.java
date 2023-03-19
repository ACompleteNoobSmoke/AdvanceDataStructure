package GraphTheory;

import java.util.List;
import java.util.Set;

public class GraphMatrix<T> extends Graph<T>{
    private final int[][] matrix;

    public GraphMatrix(Set<Vertex<T>> vertices, Set<Edge<T>> edges, int size){
        super(vertices, edges);
        this.matrix = new int[size][size];
    }

    @Override
    public void addEdge(Edge<T> newEdge){
        if (!edges.add(newEdge)) return;
        int src = newEdge.getStartVertex().getGraphPoint();
        int dest = newEdge.getEndVertex().getGraphPoint();
        addEdgeToMatrix(src, dest);
    }

    private void addEdgeToMatrix(int src, int dest){
        int matrixLen = matrix.length;
        if (src >= matrixLen || dest >= matrixLen) return;
        matrix[src][dest] = 1;
    }

    @Override
    public boolean checkEdge(int src, int dest){
        int matrixLen = matrix.length;
        if (src >= matrixLen || dest >= matrixLen) return false;
        return matrix[src][dest] == 1;
    }

    public void DFS(T src){
        Vertex<T> current = getVertex(src);
        if (current ==  null) return;
        List<Vertex<T>> listOfVertices = getListOfData();
        int srcPoint = current.getGraphPoint();
        DFSHelper(srcPoint, new boolean[matrix.length], listOfVertices);
    }

    private void DFSHelper(int srcPoint, boolean[] visited, List<Vertex<T>> listOfVertices) {
        if (visited[srcPoint]) return;
        else {
            visited[srcPoint] = true;
            System.out.println(listOfVertices.get(srcPoint).getData() + ": Visited!");
        }

        for (int i = 0; i < matrix[srcPoint].length; i++){
            if (checkEdge(srcPoint, i)) DFSHelper(i, visited, listOfVertices);
        }
    }

    @Override
    public void print(){
        List<Vertex<T>> headers = getListOfData();
        System.out.print("  ");
        headers.forEach(v -> System.out.print(v.getData() + " "));
        System.out.println();

        for (int i = 0; i < matrix.length; i++){
            System.out.print(headers.get(i).getData() + " ");
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private List<Vertex<T>> getListOfData(){
        return vertices.stream().sorted(comparator).toList();
    }

    private Vertex<T> getVertex(T src){
        for (Vertex<T> vert : vertices)
            if (vert.getData().equals(src)) return vert;
        return null;
    }
}
