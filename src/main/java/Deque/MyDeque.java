package Deque;

import java.util.Arrays;

public class MyDeque {

    private int front;
    private int size;
    private int length;
    private Integer[] nums;

    public MyDeque(int length){
        this.length = length;
        this.nums = new Integer[length];
        size = 0;
        //front = (0 + size) % length;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == length;
    }

    private int getFrontIndex(){
        return front;
    }

    private int getFront(){
        if(isEmpty()) return -1;
        return nums[front];
    }

    private int getLast(){
        if(isEmpty()) return -1;
        return nums[(front + (size-1)) % length];
    }

    public void enqueue(int number){
        if(isEmpty()){
            System.out.println(front); nums[front] = number; size++; return;}
        if(isFull()) shift();
        nums[(front + size++) % length] = number;
    }

    public void shift(){
        this.length *= 2;
        Integer[] newArray = new Integer[length];
        for(int i = 0; i < size; i++){
            newArray[i] = nums[(front + (i + 1)) % nums.length];
            //System.out.print((front + (i + 1)) % nums.length + " ");
        }
        front = 0;
        Arrays.stream(newArray).forEach(System.out::println);
        nums = newArray;
    }

    public Integer dequeue(){
        if(isEmpty()) return null;
        int removed = nums[front];
        nums[front++] = null;
        front = (front == length-1) ? 0 : front;
        size--;
        return removed;
    }

    public Integer[] returnArray(){
        return nums;
    }

    public static void main(String[] args){
        MyDeque deque = new MyDeque(3);
        deque.enqueue(8);
        deque.enqueue(9);
        deque.enqueue(10);
        deque.enqueue(16);
        deque.dequeue();
        deque.enqueue(19);
        //System.out.println("Item: " + deque.getFront());
        //Arrays.stream(deque.returnArray()).forEach(System.out::println);
    }

}
