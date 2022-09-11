package SkipList;

public class SkipListNode<T extends Comparable<T>> {

    public SkipListNode below;
    public SkipListNode next;
    public T key;
    int level;

    public SkipListNode(){
        this.key = null;
        this.level = -1;
        this.below = null;
        this.next = null;
    }

    public SkipListNode(T key, int level, SkipListNode below, SkipListNode next){
        this.key = key;
        this.level = level;
        this.below = below;
        this.next = next;
    }

}
