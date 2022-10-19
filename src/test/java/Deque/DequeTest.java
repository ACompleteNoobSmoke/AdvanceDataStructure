package Deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {

    private int capacity = 5;
    private PracticeQueue<Integer> underTest;

    @BeforeEach
    public void setUp(){
        underTest = new PracticeQueue<>(capacity);
    }

    @Test
    public void testInsertFront1(){
        boolean added = false;
        for(int i = 1; i <= 5; i++){
            added = underTest.insertFront(i);
            assertTrue(added);
        }
        underTest.viewAll();
    }

    @Test
    public void testInsertFront2(){
        for(int i = 1; i <= 5; i++) underTest.insertFront(i);
        boolean added = underTest.insertFront(7);
        underTest.viewAll();
        assertFalse(added);
    }

    @Test
    public void testInsertRear1(){
        for(int i = 1; i <= 5; i++) assertTrue(underTest.insertRear(i));
        underTest.viewAll();
    }

    @Test
    public void testInsertRear2(){
        for(int i = 1; i <= 5; i++) underTest.insertRear(i);
        assertFalse(underTest.insertRear(6));
    }

    @Test
    public void testRemoveFront1(){
        for(int i = 1; i <= 5; i++) underTest.insertFront(i);
        int removed = underTest.removeFront();
        underTest.viewAll();
        assertEquals(5, removed);
    }

    @Test
    public void testRemoveFront2(){
        for(int i = 1; i <= 5; i++) underTest.insertRear(i);
        int actualRemoved = underTest.removeFront();
        underTest.viewAll();
        assertEquals(1, actualRemoved);
    }

    @Test
    public void testRemoveFront3(){
        for(int i = 1; i <= 5; i++) underTest.insertFront(i);
        int size = underTest.getSize();
        for(int i = 0; i < size; i++) underTest.removeFront();
        Integer actualRemoved = underTest.removeFront();
        underTest.viewAll();
        assertNull(actualRemoved);
    }

    @Test
    public void testRemoveRear1(){
        for(int i = 1; i <= 5; i++) underTest.insertFront(i);
        Integer actualRemoved = underTest.removeRear();
        underTest.viewAll();
        assertEquals(1, actualRemoved);
    }

    @Test
    public void testRemoveRear2(){
        for(int i = 1; i <= 5; i++) underTest.insertRear(i);
        Integer actualRemoved = underTest.removeRear();
        underTest.viewAll();
        assertEquals(5, actualRemoved);
    }

    @Test
    public void testRemoveRear3(){
        for(int i = 1; i <= 5; i++) underTest.insertFront(i);
        int dequeSize = underTest.getSize();
        while(dequeSize > 0){ underTest.removeRear(); dequeSize--; }
        underTest.viewAll();
        assertEquals(0, underTest.getSize());
    }


}
