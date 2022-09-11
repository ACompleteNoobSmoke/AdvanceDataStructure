package SkipList;

import java.util.Random;

public class SkipList extends SkipListNode<Integer> {

    public SkipListNode head;
    public Random random;

    public SkipList(){
        head = new SkipListNode(null, 0, null, null);
        random = new Random();
    }

    public int getRandomLevel(){
        int level = 0;
        while(level <= head.level && random.nextDouble() < 0.5)
            level++;
        return level;
    }

    public boolean add(Integer value){
        if(search(value)) return false;
        int insertionLevel = getRandomLevel();
        if(insertionLevel > head.level)
            head = new SkipListNode(null, insertionLevel, null, head);

        SkipListNode curr = head, bottom = null;
        while(curr != null){
            SkipListNode next = curr.next;
            if(next == null || next.key.compareTo(value) > 0){
                if(curr.level <= insertionLevel){
                    SkipListNode newNode = new SkipListNode(value, curr.level, next, null);
                    curr.next = newNode;
                    if(bottom != null)
                        bottom.below = newNode;
                    bottom = newNode;
                }
                curr = curr.below;
            }else{
                curr = curr.next;
            }
        }
        return true;
    }

    public boolean search(Integer value){
        SkipListNode curr = head;
        while(curr != null) {
            if (curr.key != null && curr.key.compareTo(value) == 0)
                return true;

            SkipListNode next = curr.next;
            if(next == null || next.key.compareTo(value) > 0) curr = curr.below;
            else curr = curr.next;
        }
        return false;
    }
}
