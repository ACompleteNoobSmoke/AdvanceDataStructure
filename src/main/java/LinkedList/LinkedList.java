package LinkedList;

public class LinkedList<T>{
    private Node<T> head;
    public int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    private boolean isEmpty(){ return head == null || size == 0; }

    private boolean isObjectNull(Object object){ return object == null; }

    private boolean isOutOfRange(int index){ return index <= 0 || index > size; }

    private boolean isOutOfRange2(int index){ return index <= 0 || index > size + 1; }

    public void insertHead(T headData){
        if(isObjectNull(headData)) throw new IllegalArgumentException("Data Is Null");
        head = new Node<T>(headData, head);
        size++;
    }

    public void insertTail(T tailData){
        if(isObjectNull(tailData)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty()){ insertHead(tailData); return; }
        if(size == 1) head.setNext(new Node<T>(tailData, null));
        else{
            Node<T> current = head.getNext();
            while(!isObjectNull(current.getNext())) current = current.getNext();
            current.setNext(new Node<T>(tailData, null));
        }
        size++;
    }

    public void insertAtIndex(int index, T newData){
        if(isObjectNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty() || isOutOfRange2(index)) return;
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
        while (!isObjectNull(current.getNext().getNext())) current = current.getNext();
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
        if(size == 2) return head.getNext().getData();
        Node<T> current = head.getNext();
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