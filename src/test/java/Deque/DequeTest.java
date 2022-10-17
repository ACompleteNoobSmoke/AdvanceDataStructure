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
}
