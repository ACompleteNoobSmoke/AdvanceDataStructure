package GraphTheory;

import lombok.Data;

@Data
public class Edge<T> implements Comparable<Edge<? super T>> {
    private Vertex<T> start;
    private Vertex<T> end;
    private int startPoint;
    private int endPoint;
    private int weight;

    public Edge(Vertex start, Vertex end){
        this.start = start;
        this.end = end;
        this.startPoint = start.getPoint();
        this.endPoint = end.getPoint();
        this.weight = Math.abs(startPoint - endPoint);
    }

    @Override
    public int compareTo(Edge<? super T> o) {
        return this.weight - o.getWeight();
    }
}
