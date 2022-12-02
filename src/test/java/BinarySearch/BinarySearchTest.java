package BinarySearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {
    private BinarySearch underTest;
    int capacity = 10;

    @BeforeEach
    public void setUp(){
        underTest = new BinarySearch<Integer>(capacity);
        insertData();
    }

    private void insertData(){
        for(int i = 1; i <= capacity; i++)
            underTest.insertData(i);
    }

    @Test
    public void testSearch(){
        Integer target = 5;
        Integer result = (Integer) underTest.searchData(target);
        assertEquals(target, result);
    }

    @Test
    public void testSearchNull(){
        Integer target = 100;
        Integer result = (Integer) underTest.searchData(target);
        assertNull(result);
    }
}
