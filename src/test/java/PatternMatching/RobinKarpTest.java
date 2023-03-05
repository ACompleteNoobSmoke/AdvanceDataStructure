package PatternMatching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RobinKarpTest {
    private RobinKarp underTest;

    @BeforeEach
    public void setUp(){
        underTest = new RobinKarp();
    }

    @Test
    public void testHashFunction(){
        String pattern = "dba";
        int base = 10;
        int result = 421;
        Assertions.assertEquals(result, underTest.getHashValue(pattern, base));
    }

    @Test
    public void testHashFunction2(){
        String pattern = "DbA";
        int base = 10;
        int result = 421;
        Assertions.assertEquals(result, underTest.getHashValue(pattern, base));
    }

    @Test
    public void testSearchPatternFunction(){
        String pattern = "dba";
        String text = "I will become a fantastic software engineer who will work for FAANGdba";
        boolean result = underTest.searchPattern(text, pattern);
        Assertions.assertTrue(result);
    }

    @Test
    public void testSearchPatternFunction2(){
        String pattern = "dba";
        String text = "I will become a fantastic software engineer who will work for FAANG";
        boolean result = underTest.searchPattern(text, pattern);
        Assertions.assertFalse(result);
    }
}
