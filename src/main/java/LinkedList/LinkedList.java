package LinkedList;

public class LinkedList<T> {
    private int size;
    private Node<T> head;

    public LinkedList(){
        size = 0;
        head = null;
    }

    private boolean isEmpty(){
        return head == null || size == 0;
    }

    public void insertHead(T newData){
        if(isEmpty()) head = new Node<>(newData);
        else{
            Node<T> newNode = new Node<T>(newData, head);
            head = newNode;
        }
        size++;
    }

    public void insertTail(T newData){
        if(isEmpty()){ insertHead(newData); return; }
        else{
            Node<T> current = head;
            while(current.getNext() != null) current = current.getNext();
            current.setNext(new Node<>(newData));
        }
        size++;
    }

    public void insertAtIndex(int index, T newData){
        if(index <= 0 || index > size + 1) return;
        if(isEmpty() || index == 1){ insertHead(newData); return;}
        else if(index == size + 1) { insertTail(newData); return;}
        Node<T> current = head;
        for(int i = 0; i < index; i++) current = current.getNext();
        Node<T> newNode = new Node<T>(newData, current.getNext());
        current.setNext(newNode);
        size++;

    }

    public T removeHead(){
        if(isEmpty()) return null;
        T removedData = head.getData();
        head = head.getNext();
        size--;
        return removedData;
    }

    public T removeTail(){
        if(isEmpty()) return null;
        if(size == 1) return removeHead();
        Node<T> current = head;
        while(current.getNext().getNext() != null) current = current.getNext();
        T removedData = current.getNext().getData();
        current.setNext(null);
        size--;
        return removedData;
    }

    public T removeAtIndex(int index){
        if(isEmpty() || (index <= 0 || index > size)) return null;
        if(index == 1) return removeHead();
        else if(index == size) return removeTail();
        Node<T> current = head;
        for(int i = 0; i < index - 1; i++) current = current.getNext();
        Node<T> nextUp = current.getNext().getNext();
        T removedData = current.getNext().getData();
        current.getNext().setNext(null);
        current.setNext(nextUp);
        size--;
        return removedData;
    }

    public Node<T> searchNode(int index){
        if(isEmpty() || (index <= 0 || index > size)) return null;
        if(index == 1) return head;
        Node<T> current = head;
        for(int i = 0; i < index; i++) current = current.getNext();
        return current;
    }

    public T viewHead(){
        if(isEmpty()) return null;
        return head.getData();
    }

    public T viewTail(){
        if(isEmpty()) return null;
        if(size == 1) return viewHead();
        Node<T> current = head;
        while(current.getNext() != null) current = current.getNext();
        return current.getData();
    }

    public void viewAll(){
        if(isEmpty()) return;
        Node<T> current = head;
        while(current.getNext() != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println(current.getData());
    }


}
