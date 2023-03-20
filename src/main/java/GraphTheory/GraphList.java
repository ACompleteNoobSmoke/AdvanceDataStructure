package GraphTheory;

import java.util.*;

public class GraphList<T> extends Graph<T>{
    private List<LinkedList<Vertex<T>>> listOfVertices;

    public GraphList(Set<Vertex<T>> vertexSet, Set<Edge<T>> edges){
        super(vertexSet, edges);
        listOfVertices = new ArrayList<>();
    }

    @Override
    public void addVertices(Vertex<T> newVertex){
        if (!vertices.add(newVertex)) return;
        LinkedList<Vertex<T>> currentList = new LinkedList<Vertex<T>>();
        currentList.add(newVertex);
        listOfVertices.add(newVertex.getGraphPoint(), currentList);
    }

    @Override
    public void addEdge(Edge<T> newEdge){
        if (!edges.add(newEdge)) return;
        int src = newEdge.getStartVertex().getGraphPoint();
        int dest = newEdge.getEndVertex().getGraphPoint();
        addEdgeToLinkedList(src, dest);
    }

    private void addEdgeToLinkedList(int src, int dest){
        LinkedList<Vertex<T>> currentList = listOfVertices.get(src);
        Vertex<T> tail = listOfVertices.get(dest).get(0);
        currentList.addLast(tail);
    }

    @Override
    public boolean checkEdge(int src, int dest){
        LinkedList<Vertex<T>> currentList = listOfVertices.get(src);
        if (currentList == null) return false;
        for (Vertex<T> vert : currentList){
            if (vert.getGraphPoint() == dest) return true;
        }
        return false;
    }


    public void DFS(T src){
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;
        DFSHelper(currentVertex.getGraphPoint(), new HashSet<>());
    }

    private void DFSHelper(int src, Set<Integer> visited){
        if (!visited.add(src)) return;
        LinkedList<Vertex<T>> current = listOfVertices.get(src);
        System.out.println(current.get(0).getData() + ": Visited!");
        for (Vertex<T> vert: current)
            DFSHelper(vert.getGraphPoint(), visited);
    }

    private Vertex<T> getVertex(T src){
        for (Vertex<T> vert : vertices)
            if (vert.getData().equals(src)) return vert;
        return null;
    }

    private List<Vertex<T>> getListOfVertex(){
        return vertices.stream().sorted(comparator).toList();
    }

    @Override
    public void print(){
        for (LinkedList<Vertex<T>> vert : listOfVertices){
            for (int i = 1; i <= vert.size(); i++){
                System.out.print(vert.get(i).getData());
                if (i != vert.size()) System.out.print(" -> ");
            }
            System.out.println();
        }
    }
}



