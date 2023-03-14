package GraphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        int src = newEdge.getStartVertex().getGraphPoint();
        int dest = newEdge.getEndVertex().getGraphPoint();
        addEdgeToList(src, dest);
    }

    private void addEdgeToList(int src, int dest){
        LinkedList<Vertex<T>> current = vertexList.get(src);
        Vertex<T> tail = vertexList.get(dest).get(0);
        current.addLast(tail);
    }

    public boolean checkEdge(int src, int dest){
        for (Edge<T> edge : edges)
            if(edge.getStartVertex().getGraphPoint() == src &&
                edge.getEndVertex().getGraphPoint() == dest) return true;
        return false;
    }

    @Override
    public void print(){
        for (int i = 0; i < vertexList.size(); i++){
            LinkedList<Vertex<T>> vert = vertexList.get(i);
            for (int j = 0; j < vert.size(); j++){
                System.out.print(vert.get(j).getData());
                if (j != vert.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        }
    }
}
