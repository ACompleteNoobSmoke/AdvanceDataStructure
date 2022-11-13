package LinkedList;

public class LinkedList<T>{
    private Node<T> head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    private boolean isEmpty(){ return isNull(head); }

    private boolean isNull(Object obj){ return obj == null; }

    private boolean isOutOfRange(int index) { return index <= 0 || index > size; }

    private boolean isOutOfRange2(int index) { return index <= 0 || index > size + 1; }

    public void insertHead(T newData){
        if(isNull(newData)) throw new IllegalArgumentException("Data Is Null");
        head = new Node<T>(newData, head);
        size++;
    }

    public void insertTail(T newData){
        if(isNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty()) { insertHead(newData); return; }
        if(size == 1) head.setNext(new Node<>(newData, null));
        else{
            Node<T> current = head;
            while(!isNull(current.getNext())) current = current.getNext();
            current.setNext(new Node<>(newData, null));
        }
        size++;
    }

    public void insertAtIndex(int index, T newData){
        if(isNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty() || isOutOfRange2(index)) return;
        if(index == 1) insertHead(newData);
        else if(index == size + 1) insertTail(newData);
        else{
            Node<T> current = head;
            for(int i = 1; i < index-1; i++) current = current.getNext();
            current.setNext(new Node<T>(newData, current.getNext()));
            size++;
        }
    }

    public T removeHead(){
        if(isEmpty()) return null;
        T headData = head.getData();
        head = head.getNext();
        size--;
        return headData;
    }

    public T removeTail(){
        if(isEmpty()) return null;
        if(size == 1) return removeHead();
        Node<T> current = head;
        while(!isNull(current.getNext().getNext())) current = current.getNext();
        T removedData = current.getNext().getData();
        current.setNext(null);
        size--;
        return removedData;
    }

    public T removeAtIndex(int index){
        if(isEmpty() || isOutOfRange(index)) return null;
        if(index == 1) return removeHead();
        if(index == size) return removeTail();
        Node<T> current = head;
        for(int i = 1; i < index - 1; i++) current = current.getNext();
        T removedData = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        size--;
        return removedData;
    }

    public T searchNode(int index){
        if(isEmpty() || isOutOfRange(index)) return null;
        if(index == 1) return viewHead();
        if(index == size) return viewTail();
        Node<T> current = head;
        for(int i = 1; i < index; i++) current = current.getNext();
        return current.getData();
    }

    public T viewHead(){
        if(isEmpty()) return null;
        return head.getData();
    }

    public T viewTail(){
        if(isEmpty()) return null;
        if(size == 1) return viewHead();
        Node<T> current = head;
        while(!isNull(current.getNext())) current = current.getNext();
        return current.getData();
    }

    public void viewAll(){
        if(isEmpty()) return;
        Node<T> current = head;
        while(!isNull(current)){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public int getSize(){ return size; }
}