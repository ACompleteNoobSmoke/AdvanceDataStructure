package GraphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class GraphList<T> extends Graph<T>{
    private ArrayList<LinkedList<Vertex<T>>> vertexList;
    public GraphList(Set<Vertex<T>> vertices, Set<Edge<T>> edges){
        super(vertices, edges);
        vertexList = new ArrayList<>();
    }

    @Override
    public void addVertices(Vertex<T> newVertex){
        boolean added = vertices.add(newVertex);
        if(!added) return;
        LinkedList<Vertex<T>> linkedList = new LinkedList<>();
        linkedList.addFirst(newVertex);
        vertexList.add(newVertex.getGraphPoint(),linkedList);
    }

    @Override
    public void addEdge(Edge<T> newEdge){
        boolean added = edges.add(newEdge);
        if(!added) return;
        edges.add(newEdge);
        LinkedList<Vertex<T>> current = vertexList.get(newEdge.getStartVertex().getGraphPoint());
        //Vertex<T> tail = vertexList.get(newEdge.getEndVertex().getGraphPoint());
        //current.addLast(tail);
    }
}
