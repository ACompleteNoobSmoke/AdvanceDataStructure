package GraphTheory;

import java.util.*;

public class GraphList<T> extends Graph<T>{
    private final List<LinkedList<Vertex<T>>> verticesLinkedList;

    public GraphList(Set<Vertex<T>> vertices, Set<Edge<T>> edges){
        super(vertices, edges);
        verticesLinkedList = new ArrayList<>();
    }

    @Override
    public void addVertices(Vertex<T> newVertex){
        if (!vertices.add(newVertex)) return;
        LinkedList<Vertex<T>> newList = new LinkedList<>();
        newList.addFirst(newVertex);
        verticesLinkedList.add(newVertex.getGraphPoint(), newList);
    }

    @Override
    public void addEdge(Edge<T> newEdge){
        if (!edges.add(newEdge)) return;
        int src = newEdge.getStartVertex().getGraphPoint();
        int dest = newEdge.getEndVertex().getGraphPoint();
        addEdgeToList(src, dest);
    }

    private void addEdgeToList(int src, int dest){
        LinkedList<Vertex<T>> currentList = verticesLinkedList.get(src);
        Vertex<T> tail = verticesLinkedList.get(dest).get(0);
        if (currentList == null || tail == null) return;
        currentList.addLast(tail);
    }

    @Override
    public boolean checkEdge(int src, int dest){
        LinkedList<Vertex<T>> currentList = verticesLinkedList.get(src);
        if (currentList == null) return false;
        for (Vertex<T> vertex: currentList)
            if (vertex.getGraphPoint() == dest) return true;
        return false;
    }

    public void DFS(T src){
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;

        Stack<Vertex<T>> dfsStack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        dfsStack.push(currentVertex);

        while (!dfsStack.isEmpty()){
            Vertex<T> vertex = dfsStack.pop();
            if (!visited.add(vertex.getGraphPoint())) continue;
            System.out.println(vertex.getData() + ": Visited");
            LinkedList<Vertex<T>> currentList =
                    verticesLinkedList.get(vertex.getGraphPoint());
            for (Vertex<T> vert: currentList)  dfsStack.push(vert);
        }
    }

    public void BFS(T src){
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;

        Queue<Vertex<T>> bfsQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        bfsQueue.offer(currentVertex);

        while (!bfsQueue.isEmpty()){
            Vertex<T> vertex = bfsQueue.poll();
            if (!visited.add(vertex.getGraphPoint())) continue;
            System.out.println(vertex.getData() + ": Visited!");
            LinkedList<Vertex<T>> currentList =
                    verticesLinkedList.get(vertex.getGraphPoint());
            for (Vertex<T> vert: currentList) bfsQueue.offer(vert);
        }
    }

    @Override
    public void print(){
        for (LinkedList<Vertex<T>> currentList: verticesLinkedList){
            for (int i = 0; i < currentList.size(); i++){
                System.out.print(currentList.get(i).getData());
                if (i < currentList.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        }
    }

    private Vertex<T> getVertex(T src){
        for (Vertex<T> vertex : vertices)
            if (vertex.getData().equals(src))
                return vertex;
        return null;
    }
}