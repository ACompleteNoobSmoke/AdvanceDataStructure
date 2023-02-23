package PatternMatching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class KMPTest {
    private KMP underTest;

    @BeforeEach
    public void setUp(){
        underTest = new KMP();
    }

    @Test
    public void testArray(){
        String pattern = "abcdabca";
        int[] values = underTest.getValueArray(pattern);
        for (int i = 0; i < pattern.length(); i++){
            System.out.println("Character: " + pattern.charAt(i)
                    + " Value: " + values[i]);
        }
    }

    @Test
    public void testArray2(){
        String pattern = "aabaabaaa";
        int[] values = underTest.getValueArray(pattern);
        for (int i = 0; i < pattern.length(); i++){
            System.out.println("Character: " + pattern.charAt(i)
                    + " Value: " + values[i]);
        }
    }

    @Test
    public void testArray3(){
        String pattern = "ababd";
        int[] values = underTest.getValueArray(pattern);
        for (int i = 0; i < pattern.length(); i++){
            System.out.println("Character: " + pattern.charAt(i)
                    + " Value: " + values[i]);
        }
    }
}
