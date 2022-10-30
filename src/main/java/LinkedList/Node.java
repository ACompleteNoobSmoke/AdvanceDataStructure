package LinkedList;

public class Node<T> {
    private T data;
    private Node<T> prev, next;

    public Node(T data){
        this(null, data, null);
    }

    public Node(T data, Node<T> next){
        this.prev = null;
        this.data = data;
        this.next = next;
    }

    public Node(Node<T> prev, T data){
        this.prev = prev;
        this.data = data;
        this.next = null;
    }

    public Node(Node<T> prev, T data, Node<T> next){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public T getData(){ return data; }

    public void setPrev(Node<T> prev){ this.prev = prev; }

    public Node<T> getPrev(){ return prev; }

    public void setNext(Node<T> next){ this.next = next; }

    public Node<T> getNext(){ return next; }

    public String toString(){
        return data.toString();
    }

}
