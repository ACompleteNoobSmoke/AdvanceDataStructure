package GraphTheory;

import java.util.*;

public class GraphList<T> extends Graph<T>{
    private List<LinkedList<Vertex<T>>> vertexList;

    public GraphList(Set<Vertex<T>> vertexSet, Set<Edge<T>> edgeSet){
        super(vertexSet, edgeSet);
        vertexList = new ArrayList<>();
    }

    @Override
    public void addVertices(Vertex<T> newVertex){
        if (!vertices.add(newVertex)) return;
        LinkedList<Vertex<T>> newList = new LinkedList<>();
        newList.addFirst(newVertex);
        vertexList.add(newVertex.getGraphPoint(), newList);
    }

    @Override
    public void addEdge(Edge<T> newEdge){
        if (!edges.add(newEdge)) return;
        int src = newEdge.getStartVertex().getGraphPoint();
        int dest = newEdge.getEndVertex().getGraphPoint();
        addEdgeToList(src, dest);
    }

    private void addEdgeToList(int src, int dest){
        LinkedList<Vertex<T>> currentList = vertexList.get(src);
        if (currentList == null) return;
        Vertex<T> tail = vertexList.get(dest).get(0);
        if (tail == null) return;
        currentList.addLast(tail);
    }

    @Override
    public boolean checkEdge(int src, int dest){
        LinkedList<Vertex<T>> currentList = vertexList.get(src);
        if (currentList == null) return false;
        for (Vertex<T> vert: currentList)
            if (vert.getGraphPoint() == dest) return true;
        return false;
    }

    public void DFS(T src){
        Vertex<T> current = getVertex(src);
        if (current == null) return;

        Stack<Vertex<T>> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(current);

        while (!stack.isEmpty()){
            Vertex<T> vertex = stack.pop();
            int vertexPoint = vertex.getGraphPoint();
            if (!visited.add(vertexPoint)) continue;
            System.out.println(vertex.getData() + ": Visited!");
            LinkedList<Vertex<T>> currentList = vertexList.get(vertexPoint);
            for (Vertex<T> vert : currentList) stack.push(vert);
        }
    }

    public void BFS(T src){
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;

        Queue<Vertex<T>> bfsQ = new LinkedList<>();
        Set<Integer>  visited = new HashSet<>();
        bfsQ.offer(currentVertex);

        while (!bfsQ.isEmpty()){
            Vertex<T> vertex = bfsQ.poll();
            int vertexPoint = vertex.getGraphPoint();
            if (!visited.add(vertexPoint)) continue;
            System.out.println(vertex.getData() + ": Visited!");
            LinkedList<Vertex<T>> currentList = vertexList.get(vertexPoint);
            for (Vertex<T> vert: currentList) bfsQ.offer(vert);
        }
    }

    @Override
    public void print(){
        for (LinkedList<Vertex<T>> currentVert : vertexList){
            for (int i = 0; i < currentVert.size(); i++){
                System.out.print(currentVert.get(i).getData());
                if (i != currentVert.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        }
    }

    private Vertex<T> getVertex(T src){
        for (Vertex<T> vert : vertices)
            if (vert.getData().equals(src)) return vert;
        return null;
    }
}