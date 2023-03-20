package GraphTheory;

import java.util.List;
import java.util.Set;

public class GraphMatrix<T> extends Graph<T>{
    private int[][] matrix;
    public GraphMatrix(Set<Vertex<T>> vertexSet, Set<Edge<T>> edgeSet, int size){
        super(vertexSet, edgeSet);
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
        matrix[src][dest] = 1;
    }

    public boolean checkEdge(int src, int dest){
        return matrix[src][dest] == 1;
    }

    public void DFS(T src){
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;
        List<Vertex<T>> vertexList = getListOfVertex();
        int srcPoint = currentVertex.getGraphPoint();
        DFSHelper(srcPoint, new boolean[matrix.length], vertexList);
    }

    private void DFSHelper(int src, boolean[] visited, List<Vertex<T>> vertexList){
        if(visited[src]) return;
        else{
            visited[src] = true;
            System.out.println(vertexList.get(src).getData() + ": Visited!");
        }

        for (int i = 0; i < matrix[src].length; i++){
            if (checkEdge(src, i)) DFSHelper(i, visited, vertexList);
        }
    }

    @Override
    public void print(){
        List<Vertex<T>> vertexList = getListOfVertex();
        System.out.print("  ");
        vertexList.forEach(v -> System.out.print(v.getData() + " "));
        System.out.println();

        for (int i = 0; i < matrix.length; i++){
            System.out.print(vertexList.get(i).getData() + " ");
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private Vertex<T> getVertex(T src){
        for (Vertex<T> vertex : vertices)
            if (vertex.getData().equals(src)) return vertex;
        return null;
    }

    private List<Vertex<T>> getListOfVertex(){
        return vertices.stream().sorted(comparator).toList();
    }
}
