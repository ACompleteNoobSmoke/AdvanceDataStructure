package SkipList;

import java.util.Random;

public class SkipList {

    private SkipListNode Head;
    private SkipListNode Tail;

    private final int NEG_INFINITY = Integer.MIN_VALUE;
    private final int POS_INFINITY = Integer.MAX_VALUE;

    private int heightOfSkipList = 0;
    public Random random = new Random();

    public SkipList(){
        Head = new SkipListNode(NEG_INFINITY);
        Tail = new SkipListNode(POS_INFINITY);
        Head.next = Tail;
        Tail.prev = Head;
    }

    public SkipListNode skipSearch(int key){
        SkipListNode n = Head;
        while(n.below != null){
            n = n.below;
            while(key >= n.key){
                n = n.next;
            }
        }
        return n;
    }
}
