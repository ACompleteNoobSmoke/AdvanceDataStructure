package Heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class MyHeapTest {

    public MyHeap<Integer> underTest;

    @BeforeEach
    public void setUp(){
        underTest = new MyHeap();
    }

    @Test
    public void testAddition(){
        Integer testArray[] = {7, 14, 21, 28, 35, 42, 49, 56, 63};
        Arrays.stream(testArray).forEach(underTest::add);
        Arrays.stream(testArray).forEach(i -> System.out.print(i + " "));
        underTest.add(0);
        System.out.println("\nNew Array After Addition");
        Object answers[] = underTest.getBackingArray();
        Arrays.stream(answers).forEach(i -> System.out.print(i + " "));
        System.out.println(" ");
    }

    @Test
    public void testAddition2(){
        Integer testArray[] = {0, 14, 21};
        Arrays.stream(testArray).forEach(underTest::add);
        Arrays.stream(testArray).forEach(i -> System.out.print(i + " "));
        underTest.add(7);
        System.out.println("\nNew Array After Addition");
        Object answers[] = underTest.getBackingArray();
        Arrays.stream(answers).forEach(i -> System.out.print(i + " "));
        System.out.println(" ");
    }

    @Test
    public void testAddition3(){
        Integer testArray[] = {7, 14, 21, 28, 35, 42, 49, 56, 63, 70, 77, 84};
        Arrays.stream(testArray).forEach(underTest::add);
        Arrays.stream(testArray).forEach(i -> System.out.print(i + " "));
        underTest.add(0);
        System.out.println("\nNew Array After Addition");
        Object answers[] = underTest.getBackingArray();
        Arrays.stream(answers).forEach(i -> System.out.print(i + " "));
        System.out.println(" ");
    }

    @Test
    public void remove(){
        Integer testArray[] = {0, 7, 14, 21, 28, 35, 42};
        Arrays.stream(testArray).forEach(underTest::add);
        Arrays.stream(testArray).forEach(i -> System.out.print(i + " "));
        underTest.remove();
        System.out.println("\nNew Array After Remove");
        Object answers[] = underTest.getBackingArray();
        Arrays.stream(answers).forEach(i -> System.out.print(i + " "));
        System.out.println(" ");
    }

    @Test
    public void remove2(){
        Integer testArray[] = {0, 7, 14, 21, 28, 35, 42, 49, 56};
        Arrays.stream(testArray).forEach(underTest::add);
        Arrays.stream(testArray).forEach(i -> System.out.print(i + " "));
        underTest.remove();
        System.out.println("\nNew Array After Remove");
        Object answers[] = underTest.getBackingArray();
        Arrays.stream(answers).forEach(i -> System.out.print(i + " "));
        System.out.println(" ");
    }

}
