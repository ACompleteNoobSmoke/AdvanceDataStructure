package Sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RadixSortTest {
    private RadixSort<Integer> underTest;

    @BeforeEach
    public void setUp(){
        int cap = 15;
        underTest = new RadixSort<>(cap);
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
    public void getMaxTest(){
        for(int i = 0; i < underTest.getCapacity(); i++)
            underTest.insert(new Random().nextInt(0, 20));

        System.out.print("Array: ");
        underTest.printArray();
        System.out.println("\nMaximum: " + underTest.getMax());
    }

    @Test
    public void getMinTest(){
        for(int i = 0; i < underTest.getCapacity(); i++)
            underTest.insert(new Random().nextInt(0, 20));

        System.out.print("Array: ");
        underTest.printArray();
        System.out.println("\nMinimum: " + underTest.getMin());
    }

//    @Test
//    public void sortTest(){
//        for(int i = 0; i < underTest.getCapacity(); i++){
//            int randomNumber = new Random().nextInt(0, 20);
//            underTest.insert(randomNumber);
//        }
//        System.out.print("Before: ");
//        underTest.printArray();
//        underTest.sort();
//        System.out.print("\n\nAfter: ");
//        underTest.printArray();
//    }
}
