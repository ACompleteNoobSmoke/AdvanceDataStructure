package GraphTheory;

import java.util.*;

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
        matrix[src][dest] = 1;
    }

    @Override
    public boolean checkEdge(int src, int dest){
        return matrix[src][dest] == 1;
    }

    public void DFS(T src){
        Vertex<T> current = getVertex(src);
        if (current == null) return;
        DFSHelper(current);
    }

    private void DFSHelper(Vertex<T> current){
        Stack<Vertex<T>> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        List<Vertex<T>> vertexList = getSortedVertexList();
        stack.push(current);

        while (!stack.isEmpty()){
            Vertex<T> vert = stack.pop();
            int vertPoint = vert.getGraphPoint();
            if (!visited.add(vertPoint)) continue;
            System.out.println(vert.getData() + ": Visited!");

            for (int i = 0; i < matrix[vert.getGraphPoint()].length; i++)
                if (checkEdge(vertPoint, i)) stack.push(vertexList.get(i));
        }
    }

    public void BFS(T src){
        Vertex<T> current = getVertex(src);
        if (current == null) return;

        Queue<Vertex<T>> bfsQ = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        List<Vertex<T>> sortedList = getSortedVertexList();
        bfsQ.offer(current);

        while (!bfsQ.isEmpty()){
            Vertex<T> vertex = bfsQ.poll();
            int vertexPoint = vertex.getGraphPoint();
            if (!visited.add(vertexPoint)) continue;
            System.out.println(vertex.getData() + ": Visited!");

            for (int i = 0; i < matrix[vertexPoint].length; i++){
                if (checkEdge(vertexPoint, i)) bfsQ.offer(sortedList.get(i));
            }
        }
    }

    @Override
    public void print(){
        List<Vertex<T>> header = getSortedVertexList();
        System.out.print("  ");
        header.forEach(v -> System.out.print(v.getData() + " "));
        System.out.println();

        for (int i = 0; i < matrix.length; i++){
            System.out.print(header.get(i).getData() + "|");
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private Vertex<T> getVertex(T src){
        if (vertices.isEmpty()) return null;
        for (Vertex<T> vert: vertices)
            if (vert.getData().equals(src)) return vert;
        return null;
    }

    private List<Vertex<T>> getSortedVertexList(){
        return vertices.stream().sorted(comparator).toList();
    }
}