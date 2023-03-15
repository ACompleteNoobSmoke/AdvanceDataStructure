package GraphTheory;


import java.util.List;
import java.util.Set;

public class GraphMatrix<T> extends Graph<T> {
    private int[][] matrix;
    public GraphMatrix(Set<Vertex<T>> vertexSet, Set<Edge<T>> edgeSet, int size){
        super(vertexSet, edgeSet);
        this.matrix = new int[size][size];
    }

    @Override
    public void addEdge(Edge<T> newEdge){
        if(newEdge == null || !edges.add(newEdge)) return;
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

    @Override
    public void print(){
        List<Vertex<T>> header = vertices.stream().sorted(comparator).toList();
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

    public void DFS(T srcChar){
        boolean[] visited = new boolean[matrix.length];
        List<Vertex<T>> vertList = vertices.stream().sorted(comparator).toList();
        Vertex<T> current = getVertex(srcChar, vertList);
        if (current == null) return;
        int src = current.getGraphPoint();
        DFSHelper(src, visited, vertList);
    }

    private void DFSHelper(int src, boolean[] visited, List<Vertex<T>> vertList){
        if (visited[src]) return;
        else{
            visited[src] = true;
            System.out.println(vertList.get(src).getData() + ": Visited!");
        }

        for (int i = 0; i < matrix[src].length; i++){
            if (checkEdge(src, i)) DFSHelper(i, visited, vertList);
        }
        return;
    }

    private Vertex<T> getVertex(T srcChar, List<Vertex<T>> vertList) {
        for (Vertex<T> vert : vertList){
            if (vert.getData().equals(srcChar))
                return vert;
        }
        return null;
    }

}