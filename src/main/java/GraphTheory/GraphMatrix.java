package GraphTheory;

import java.util.*;

public class GraphMatrix<T> extends Graph<T>{
    private final int[][] matrixGraph;

    public GraphMatrix(Set<Vertex<T>> vertices, Set<Edge<T>> edges, int size){
        super(vertices, edges);
        this.matrixGraph = new int[size][size];
    }

    @Override
    public void addEdge(Edge<T> newEdge){
        if (!edges.add(newEdge)) return;
        int src = newEdge.getStartVertex().getGraphPoint();
        int dest = newEdge.getEndVertex().getGraphPoint();
        addEdgeToMatrixGraph(src, dest);
    }

    private void addEdgeToMatrixGraph(int src, int dest){
        matrixGraph[src][dest] = 1;
    }

    @Override
    public boolean checkEdge(int src, int dest){
        return matrixGraph[src][dest] == 1;
    }

    public void DFS(T src){
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;

        Stack<Integer> dfsStack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        List<Vertex<T>> vertexList = sortedList();
        dfsStack.push(currentVertex.getGraphPoint());

        while (!dfsStack.isEmpty()){
            int vertexPoint = dfsStack.pop();
            if (!visited.add(vertexPoint)) continue;
            System.out.println(vertexList.get(vertexPoint).getData() + ": Visited!");

            for (int i = 0; i < matrixGraph[vertexPoint].length; i++){
                if (checkEdge(vertexPoint, i)) dfsStack.push(i);
            }
        }
    }

    public void BFS(T src){
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;

        Queue<Vertex<T>> bfsQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        List<Vertex<T>> vertexList = sortedList();
        bfsQueue.offer(currentVertex);

        while (!bfsQueue.isEmpty()){
            Vertex<T> vertex = bfsQueue.poll();
            int graphPoint = vertex.getGraphPoint();
            if (!visited.add(graphPoint)) continue;
            System.out.println(vertex.getData() + ": Visited!");

            for (int i = 0; i < matrixGraph[graphPoint].length; i++)
                if (checkEdge(graphPoint, i)) bfsQueue.offer(vertexList.get(i));
        }
    }

    @Override
    public void print(){
        if (vertices.isEmpty()) return;
        List<Vertex<T>> header = sortedList();
        System.out.print("  ");
        header.forEach(v -> System.out.print(v.getData() + " "));
        System.out.println();

        for (int i = 0; i < matrixGraph.length; i++){
            System.out.print(header.get(i).getData() + ":");
            for (int j = 0; j < matrixGraph[i].length; j++){
                System.out.print(matrixGraph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private Vertex<T> getVertex(T src){
        for (Vertex<T> vertex : vertices)
                if (vertex.getData().equals(src)) return vertex;
        return null;
    }

    private List<Vertex<T>> sortedList(){
        return vertices.stream().sorted(comparator).toList();
    }
}