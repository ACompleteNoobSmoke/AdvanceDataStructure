package GraphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class GraphList<T> extends Graph<T> {
    private ArrayList<LinkedList<Vertex<T>>> vertexList;
    public GraphList(Set<Vertex<T>> vertices, Set<Edge<T>> edges){
        super(vertices, edges);
        this.vertexList = new ArrayList<>();
    }

    @Override
    public void addVertices(Vertex<T> newVertex){
        if (newVertex == null || !vertices.add(newVertex)) return;
        LinkedList<Vertex<T>> current = new LinkedList<>();
        current.add(newVertex);
        vertexList.add(newVertex.getGraphPoint(), current);
    }

    @Override
    public void addEdge(Edge<T> newEdge){
        if(newEdge == null || !edges.add(newEdge)) return;
        int src = newEdge.getStartVertex().getGraphPoint();
        int dest = newEdge.getEndVertex().getGraphPoint();
        addEdgeToList(src, dest);
    }

    private void addEdgeToList(int src, int dest){
        LinkedList<Vertex<T>> current = vertexList.get(src);
        Vertex<T> tail = vertexList.get(dest).get(0);
        current.addLast(tail);
    }

    @Override
    public boolean checkEdge(int src, int dest){
        LinkedList<Vertex<T>> current = vertexList.get(src);
        Vertex<T> tail = vertexList.get(dest).get(0);
        if (current == null || tail == null) return false;
        for (Vertex<T> vert : current){
            if (vert.getGraphPoint() == tail.getGraphPoint()) return true;
        }
        return false;
    }

    @Override
    public void print(){
        for (int i = 0; i < vertexList.size(); i++){
            for (int j = 0; j < vertexList.get(i).size(); j++){
                System.out.print(vertexList.get(i).get(j).getData());
                if (j != vertexList.get(i).size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        }
    }

}



