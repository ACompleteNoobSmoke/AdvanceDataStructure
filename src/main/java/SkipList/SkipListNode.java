package SkipList;

public class SkipListNode {

    public SkipListNode above;
    public SkipListNode below;
    public SkipListNode next;
    public SkipListNode prev;
    public int key;

    public SkipListNode(int key){
        this.key = key;
        this.above = null;
        this.below = null;
        this.next = null;
        this.prev = null;
    }
}
