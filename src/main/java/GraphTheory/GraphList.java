package GraphTheory;

import java.util.*;

public class GraphList<T> extends Graph<T> {
    private final List<LinkedList<Vertex<T>>> listOfVertices;

    public GraphList(Set<Vertex<T>> vertices, Set<Edge<T>> edges){
        super(vertices, edges);
        this.listOfVertices = new ArrayList<>();
    }

    @Override
    public void addVertices(Vertex<T> newVertex){
        if (!vertices.add(newVertex)) return;
        LinkedList<Vertex<T>> newVertexList = new LinkedList<>();
        newVertexList.add(newVertex);
        listOfVertices.add(newVertex.getGraphPoint(), newVertexList);
    }

    @Override
    public void addEdge(Edge<T> newEdge){
        if (!edges.add(newEdge)) return;
        int src = newEdge.getStartVertex().getGraphPoint();
        int dest = newEdge.getEndVertex().getGraphPoint();
        addEdgeToList(src, dest);
    }

    private void addEdgeToList(int src, int dest){
        LinkedList<Vertex<T>> currentList = listOfVertices.get(src);
        if (currentList == null) return;
        Vertex<T> tail = listOfVertices.get(dest).get(0);
        currentList.addLast(tail);
    }

    @Override
    public boolean checkEdge(int src, int dest){
        LinkedList<Vertex<T>> currentList = listOfVertices.get(src);
        if (currentList == null) return false;
        for (Vertex<T> tail: currentList)
            if (tail.getGraphPoint() == dest) return true;
        return false;
    }

    public void DFS(T src){
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;
        int srcPoint = currentVertex.getGraphPoint();
        DFSHelper(srcPoint, new HashSet<>());
    }

    private void DFSHelper(int srcPoint, Set<Integer> visited){
        LinkedList<Vertex<T>> current = listOfVertices.get(srcPoint);
        for (Vertex<T> vert: current){
            if(visited.add(vert.getGraphPoint())){
                System.out.println(vert.getData() + ": Visited!");
                DFSHelper(vert.getGraphPoint(), visited);
            }
        }
    }

    public void BFS(T src){
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;

        Queue<Integer> bfsQ = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        bfsQ.offer(currentVertex.getGraphPoint());

        while (!bfsQ.isEmpty()){
            int currentPoint = bfsQ.poll();
            if (!visited.add(currentPoint)) continue;
            LinkedList<Vertex<T>> vert = listOfVertices.get(currentPoint);
            System.out.println(vert.get(0).getData() + ": Visited!");
            vert.forEach(v -> bfsQ.offer(v.getGraphPoint()));
        }
    }

    @Override
    public void print(){
        for (LinkedList<Vertex<T>> vertices: listOfVertices){
            for (int i = 0; i < vertices.size(); i++){
                System.out.print(vertices.get(i).getData());
                if (i != vertices.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        }
    }

    private Vertex<T> getVertex(T src){
        for (Vertex<T> vert: vertices)
            if (vert.getData().equals(src)) return vert;
        return null;
    }
}



