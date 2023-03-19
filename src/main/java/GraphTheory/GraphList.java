package GraphTheory;

import javax.xml.crypto.Data;
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
        System.out.println(src);
        LinkedList<Vertex<T>> currentList = listOfData.get(src);
        if (currentList == null) return false;
        for (Vertex<T> vert: currentList)
            if (vert.getGraphPoint() == dest) return true;
        return false;
    }

    public void DFS(T src){
        Vertex<T> currentVertex = getVertex(src);
        if (currentVertex == null) return;
        int srcPoint = currentVertex.getGraphPoint();
        DFSHelper(srcPoint, new boolean[listOfData.size()]);
    }

    private void DFSHelper(int srcPoint, boolean[] visited){
        if (visited[srcPoint]) return;
        else{
            visited[srcPoint] = true;
            System.out.println(listOfData.get(srcPoint).get(0).getData() + ": Visited!");
        }

        for (Vertex<T> vert: listOfData.get(srcPoint)){
            DFSHelper(vert.getGraphPoint(), visited);
        }
    }

    private Vertex<T> getVertex(T src){
        for (Vertex<T> vertex: vertices)
            if (vertex.getData().equals(src)) return vertex;
        return null;
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



