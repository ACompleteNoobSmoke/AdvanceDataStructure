package GraphTheory;

import lombok.Data;


@Data
public class Edge<T> implements Comparable<Edge<? super Edge<T>>>{
    private Vertex<T> startVertex;
    private Vertex<T> endVertex;
    private int weight;

    public Edge(Vertex<T> startVertex, Vertex<T> endVertex){
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = Math.abs(startVertex.getGraphPoint() - endVertex.getGraphPoint());
    }

    @Override
    public int compareTo(Edge<? super Edge<T>> o) {
        return weight - o.getWeight();
    }
}
