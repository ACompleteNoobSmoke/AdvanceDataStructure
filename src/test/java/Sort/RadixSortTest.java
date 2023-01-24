package Sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RadixSortTest {
    private RadixSort underTest;
    private int[] testArray;

    @BeforeEach
    public void setUp(){
        int cap = 20;
        testArray = createTestArray(cap);
        underTest = new RadixSort(cap, testArray);
    }

    private int[] createTestArray(int cap){
        int[] testArray = new int[cap];
        for(int i = 0; i < cap; i++)
            testArray[i] = new Random().nextInt(0, 20);
        return testArray;
    }


    @Test
    public void radixSortTest(){
        final int[] oldArray = testArray;
        IntStream sortArray = Arrays.stream(oldArray).sorted();
        int[] newArray = sortArray.toArray();


        System.out.print("Before: ");
        Arrays.stream(underTest.array).forEach(i -> System.out.print(i + ", "));
        underTest.sort();
        System.out.print("\nAfter: ");
        Arrays.stream(underTest.array).forEach(i -> System.out.print(i + ", "));

        //Assertions.assertArrayEquals(newArray, );
    }
}
