package LinkedList;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private int size;

    public DoublyLinkedList(){
        head = null;
        size = 0;
    }

    private boolean isEmpty(){
        return head == null || size == 0;
    }

    private boolean isOutOfRange(int index){
        return index <= 0 || index > size;
    }

    private boolean isObjectNull(Object data){
        return data == null;
    }

    public void insertHead(T newData){
        if(isObjectNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty()) head = new Node<>(newData);
        else head = new Node<T>(newData, head);
        size++;
    }

    public void insertTail(T newData){
        if(isObjectNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty()) { insertHead(newData); return; }
        if(size == 1) head.setNext(new Node<T>(head, newData));
        else{
            Node<T> current = head;
            while(!isObjectNull(current.getNext())) current = current.getNext();
            current.setNext(new Node<T>(current, newData));
        }
        size++;
    }

    public void insertAtIndex(int index, T newData){
        if(isObjectNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty() || index > size + 1) return;
        if(index == 1) { insertHead(newData); return; }
        if(index == size + 1) { insertTail(newData); return; }
        Node<T> current = head;
        for(int i = 1; i < index; i++) current = current.getNext();
        Node<T> newNode = new Node<T>(current.getPrev(), newData, current);
        current.setPrev(newNode);
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
        while(!isObjectNull(current.getNext())) current = current.getNext();
        current.getPrev().setNext(null);
        current.setPrev(null);
        size--;
        return current.getData();
    }

    public T removeAtIndex(int index){
        if(isEmpty() || isOutOfRange(index)) return null;
        if(index == 1) return removeHead();
        if(index == size) return removeTail();
        Node<T> current = head;
        for(int i = 1; i < index; i++) current = current.getNext();
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        current.setPrev(null); current.setNext(null);
        size--;
        return current.getData();
    }

    public Node<T> searchNode(int index){
        if(isEmpty() || isOutOfRange(index)) return null;
        Node<T> found;
        if(index == 1) found = head;
        else if(index == 2) found = head.getNext();
        else{
            Node<T> current = head;
            for(int i = 1; i < index; i++) current = current.getNext();
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
        while(!isObjectNull(current.getNext())) current = current.getNext();
        return current.getData();
    }

    public void viewAll(){
        if(isEmpty()) return;
        Node<T> current = head;
        while(!isObjectNull(current.getNext())){
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println(current.getData());
    }

    public int getSize(){ return size; }
}
