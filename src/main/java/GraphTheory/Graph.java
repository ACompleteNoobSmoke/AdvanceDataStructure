package GraphTheory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public abstract class Graph<T> {
    protected Set<Vertex<T>> vertices;
    protected Set<Edge<T>> edges;
    protected Comparator<Vertex<T>> comparator;

    public Graph(Set<Vertex<T>> vertices, Set<Edge<T>> edges){
        this.vertices = vertices;
        this.edges = edges;
        comparator = Comparator.comparingInt(Vertex::getGraphPoint);
    }

    public void addVertices(Vertex<T> newVertex){
        vertices.add(newVertex);
    }

    public void addEdge(Edge<T> newEdge){
        edges.add(newEdge);
    }

    public abstract boolean checkEdge(int src, int dest);

    protected abstract void print();

}
