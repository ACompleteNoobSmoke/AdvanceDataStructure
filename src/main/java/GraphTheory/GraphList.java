package GraphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphList<T> extends Graph<T>{
    private final List<LinkedList<Vertex<T>>> listOfData;

    public GraphList(Set<Vertex<T>> vertexSet, Set<Edge<T>> edges){
        super(vertexSet, edges);
        this.listOfData = new ArrayList<>();
    }

    @Override
    public void addVertices(Vertex<T> newVertex){
        if (!vertices.add(newVertex)) return;
        LinkedList<Vertex<T>> newList = new LinkedList<>();
        newList.add(newVertex);
        listOfData.add(newVertex.getGraphPoint(), newList);
    }

    @Override
    public void addEdge(Edge<T> newEdge){
        if (!edges.add(newEdge)) return;
        LinkedList<Vertex<T>> currentList = listOfData.get(newEdge.getStartVertex().getGraphPoint());
        Vertex<T> tail = listOfData.get(newEdge.getEndVertex().getGraphPoint()).get(0);
        currentList.addLast(tail);
    }

    @Override
    public boolean checkEdge(int src, int dest){
        LinkedList<Vertex<T>> currentList = listOfData.get(src);
        if (currentList == null) return false;
        for (Vertex<T> vert: currentList)
            if (vert.getGraphPoint() == dest) return true;
        return false;
    }

    @Override
    public void print(){
        for (LinkedList<Vertex<T>> listOfDatum : listOfData) {
            for (int j = 0; j < listOfDatum.size(); j++) {
                System.out.print(listOfDatum.get(j).getData());
                if (j != listOfDatum.size() - 1) System.out.print(" -> ");
            }
            System.out.println();
        }
    }
}



