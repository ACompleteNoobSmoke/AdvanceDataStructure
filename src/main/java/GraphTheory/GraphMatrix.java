package GraphTheory;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphMatrix<T> extends Graph<T>{
    private final int[][] matrix;

    public GraphMatrix(Set<Vertex<T>> vertices, Set<Edge<T>> edges, int size){
        super(vertices, edges);
        this.matrix = new int[size][size];
    }

    @Override
    public void addEdge(Edge<T> newEdge){
        if(!edges.add(newEdge)) return;
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
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;
        DFSHelper(currentVertex.getGraphPoint(), new boolean[matrix.length], getSortedListOfVertex());
    }

    private void DFSHelper(int srcPoint, boolean[] visited, List<Vertex<T>> vertexList){
        if(visited[srcPoint]) return;
        else{
            visited[srcPoint] = true;
            System.out.println(vertexList.get(srcPoint).getData() + ": Visited!");
        }

        for (int i = 0; i < matrix[srcPoint].length; i++){
            if (checkEdge(srcPoint, i)) DFSHelper(i, visited, vertexList);
        }
    }

    public void BFS(T src){
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;

        int currentPoint = currentVertex.getGraphPoint();
        Queue<Integer> bfsQ = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];
        List<Vertex<T>> sortedList = getSortedListOfVertex();
        bfsQ.offer(currentPoint);

        while (!bfsQ.isEmpty()){
            currentPoint = bfsQ.poll();
            if(!visited[currentPoint]){
                visited[currentPoint] = true;
                System.out.println(sortedList.get(currentPoint).getData() + ": Visited!");
            }

            for (int i = 0; i < matrix[currentPoint].length; i++)
                if (checkEdge(currentPoint, i) && !visited[i]) bfsQ.offer(i);
        }
    }

    @Override
    public void print(){
        List<Vertex<T>> header = getSortedListOfVertex();
        System.out.print("  ");
        header.forEach(v -> System.out.print(v.getData() + " "));
        System.out.println();

        for (int i = 0; i < matrix.length; i++){
            System.out.print(header.get(i).getData() + " ");
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private Vertex<T> getVertex(T src){
        for (Vertex<T> vert: vertices)
            if (vert.getData().equals(src)) return vert;
        return null;
    }

    private List<Vertex<T>> getSortedListOfVertex(){
        return vertices.stream().sorted(comparator).toList();
    }
}
