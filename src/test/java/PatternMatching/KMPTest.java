package PatternMatching;

import org.junit.jupiter.api.Assertions;
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
        int[] values = underTest.getSubstringValues(pattern);
        for (int i = 0; i < pattern.length(); i++){
            System.out.println("Character: " + pattern.charAt(i)
                    + " Value: " + values[i]);
        }
    }

    @Test
    public void testArray2(){
        String pattern = "aabaabaaa";
        int[] values = underTest.getSubstringValues(pattern);
        for (int i = 0; i < pattern.length(); i++){
            System.out.println("Character: " + pattern.charAt(i)
                    + " Value: " + values[i]);
        }
    }

    @Test
    public void testArray3(){
        String pattern = "ababd";
        int[] values = underTest.getSubstringValues(pattern);
        for (int i = 0; i < pattern.length(); i++){
            System.out.println("Character: " + pattern.charAt(i)
                    + " Value: " + values[i]);
        }
    }

    @Test
    public void testSearchPattern(){
        String patttern = "bob";
        String text = "Spongebob Squarepants";
        boolean result = underTest.searchPattern(patttern, text);
        Assertions.assertTrue(result);
    }

    @Test
    public void testSearchPatternFalse(){
        String patttern = "Patrick";
        String text = "Spongebob Squarepants";
        boolean result = underTest.searchPattern(patttern, text);
        Assertions.assertFalse(result);
    }

    @Test
    public void testSearchPatternTrue(){
        String pattern = "abcdabca";
        String text = "xdaskjabcdalfdsklkl1abcdabca23kljklds";
        boolean result = underTest.searchPattern(pattern, text);
        Assertions.assertTrue(result);
    }
}
