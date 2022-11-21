package HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest{

    private MyPracticeHashMap<Integer, Integer> underTest;

    @BeforeEach
    public void setUnderTest(){
        underTest = new MyPracticeHashMap<>(3);
    }

    @Test
    public void testPutFunction(){
        for(int i = 0; i <= 7; i++){
            underTest.put(i, i);
        }
        underTest.put(8, 8);
        assertEquals(15, underTest.getTable().length);
    }

    @Test
    public void testPutFunction2(){
        int nums[] = {13, 53, 15, 3, 17, 5, 19, 218};
        Arrays.stream(nums).forEach(i -> underTest.put(i, i));
        System.out.println("BEFORE");
        for(int i = 0; i < underTest.getTable().length; i++){
            System.out.println(underTest.getTable()[i]);
        }
        underTest.put(1, 1);

        System.out.println("\nAFTER");
        for(int i = 0; i < underTest.getTable().length; i++){
            System.out.println(underTest.getTable()[i]);
        }
    }

    @Test
    public void testPutFunction3(){
        for(int i = 0; i <= 17; i++){
            underTest.put(i, i);
        }
        System.out.println("BEFORE");
        for(int i = 0; i < underTest.getTable().length; i++){
            System.out.println(underTest.getTable()[i]);
        }

        System.out.println("ADDING: " + 18);
        underTest.put(18, 18);

        System.out.println("\nAFTER");
        for(int i = 0; i < underTest.getTable().length; i++){
            System.out.println(underTest.getTable()[i]);
        }
    }

    @Test
    public void testPutFunction4(){
        int nums[] = {18, 26, 29, 33, 42, 40};
        Arrays.stream(nums).forEach(i -> underTest.put(i, i));
        System.out.println("BEFORE");
        for(int i = 0; i < underTest.getTable().length; i++){
            System.out.println(underTest.getTable()[i]);
        }
        underTest.put(1, 1);

        System.out.println("\nAFTER");
        for(int i = 0; i < underTest.getTable().length; i++){
            System.out.println(underTest.getTable()[i]);
        }
    }

    @Test
    public void testPutFunctionNegative(){
        for(int i = 0; i <= 7; i++){
            underTest.put(i, i);
        }

        System.out.println("BEFORE");
        for(int i = 0; i < underTest.getTable().length; i++){
            System.out.println(underTest.getTable()[i]);
        }
        underTest.put(-8, -8);

        System.out.println("\nAFTER");
        for(int i = 0; i < underTest.getTable().length; i++){
            System.out.println(underTest.getTable()[i]);
        }
    }
}
