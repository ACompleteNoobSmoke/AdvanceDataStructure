package GraphTheory;

import lombok.Data;

@Data
public class Vertex<T> implements Comparable<T> {
    private T data;
    private int point;
    public Vertex(T data, int point){
        if (data == null){ throw new IllegalArgumentException("Data Is Null"); }
        this.data = data;
        this.point = point;
    }

    @Override
    public int compareTo(T o) {
        return this.point - getPoint();
    }
}
