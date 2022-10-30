package LinkedList;

public class LinkedList<T>{
    private Node<T> head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    private boolean isEmpty(){
        return head == null || size == 0;
    }

    private boolean isOutOfRange(int index){
        return index <= 0 || index > size;
    }

    private boolean isDataNull(T newData){
        return newData == null;
    }

    public void insertHead(T newData){
        if(isDataNull(newData)) throw new IllegalArgumentException("Data Is Null");
        head = new Node<T>(newData, head);
        size++;
    }

    public void insertTail(T newData){
        if(isDataNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty()){ insertHead(newData); return; }
        if(size == 1) head.setNext(new Node<>(newData));
        else{
            Node<T> current = head;
            while(current.getNext() != null) current = current.getNext();
            current.setNext(new Node<>(newData));
        }
        size++;
    }

    public void insertAtIndex(int index, T newData){
        if(isDataNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty() || index > size + 1) return;
        if(index == 1){ insertHead(newData); return; }
        if(index == size + 1){ insertTail(newData); return; }
        Node<T> current = head;
        for(int i = 1; i < index - 1; i++) current = current.getNext();
        current.setNext(new Node<T>(newData, current.getNext()));
        size++;
    }

    public T removeHead(){
        if(isEmpty()) return null;
        T removedHeadData = head.getData();
        head = head.getNext();
        size--;
        return removedHeadData;
    }

    public T removeTail(){
        if(isEmpty()) return null;
        if(size == 1) return removeHead();
        Node<T> current = head;
        while (current.getNext().getNext() != null) current = current.getNext();
        T removedTailData = current.getNext().getData();
        current.setNext(null);
        size--;
        return removedTailData;
    }

    public T removeAtIndex(int index){
        if(isEmpty() || isOutOfRange(index)) return null;
        if(index == 1) return removeHead();
        if(index == size) return removeTail();
        Node<T> current = head;
        for(int i = 1; i < index - 1; i++) current = current.getNext();
        T removedData = current.getNext().getData();
        Node<T> replacementNode = current.getNext().getNext();
        current.getNext().setNext(null);
        current.setNext(replacementNode);
        size--;
        return removedData;
    }

    public Node<T> searchNode(int index){
        if(isEmpty() || isOutOfRange(index)) return null;
        Node<T> found;
        if(index == 1) found = head;
        else if(index == 2) found = head.getNext();
        else{
            Node<T> current = head;
            for(int i = 1; i < index; i++ ) current = current.getNext();
            found = current;
        }
        return found;
    }

    public T viewHead(){
        if(isEmpty()) return null;
        return head.getData();
    }

    public T viewTail(){
        if(isEmpty()) return null;
        if(size == 1) return viewHead();
        if(size == 2) return head.getNext().getData();
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

    public int getSize(){ return size; }
}