package Sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuickSortTest {
    private QuickSort<Integer> underTest;

    @BeforeEach
    public void setUp(){
        int cap = 15;
        underTest = new QuickSort<>(cap);
    }

    @Test
    public void insertTest(){
        for(int i = 0; i < underTest.getCapacity(); i++){
            int randomNumber = new Random().nextInt(0, 30);
            underTest.insert(randomNumber);
        }
        underTest.printArray();
        System.out.println("\n");
    }

    @Test
    public void insertTest2(){
        Integer randomNum = null;
        assertThrows(IllegalArgumentException.class, () -> underTest.insert(randomNum));
    }

    @Test
    public void sortTest(){
        for(int i = 0; i < underTest.getCapacity(); i++){
            int randomNumber = new Random().nextInt(0, 20);
            underTest.insert(randomNumber);
        }
        System.out.print("Before: ");
        underTest.printArray();
        underTest.sort();
        System.out.print("\n\nAfter: ");
        underTest.printArray();
    }
}
