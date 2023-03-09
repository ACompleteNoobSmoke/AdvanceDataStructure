package GraphTheory;

public class Vertex<T> {
    private T data;
    public Vertex(T data){
        if (data == null){ throw new IllegalArgumentException("Data Is Null"); }
        this.data = data;
    }

    public T getData(){ return data; }
}
