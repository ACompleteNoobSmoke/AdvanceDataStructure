package GraphTheory;

import lombok.Data;

@Data
public class Vertex<T>  {
    private T data;
    private int graphPoint;

    public Vertex(T data, int graphPoint){
        this.data = data;
        this.graphPoint = graphPoint;
    }
}
