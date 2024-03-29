package PatternMatching;

import PatternMatching.BoyerMoore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoyerMooreTest {
    private BoyerMoore underTest;

    @BeforeEach
    public void setUp(){
        underTest = new BoyerMoore();
    }

    @Test
    public void testSearchPattern1(){
        String text = "This is me testing";
        String pattern = "test";

        underTest.setPattern(pattern);
        underTest.setText(text);

        boolean result = underTest.searchPattern();
        underTest.printMismatchTable();

        Assertions.assertTrue(result);
    }

    @Test
    public void testSearchPattern2(){
        String text = "This is me testing";
        String pattern = "Vegeta";

        underTest.setPattern(pattern);
        underTest.setText(text);

        boolean result = underTest.searchPattern();
        underTest.printMismatchTable();

        Assertions.assertFalse(result);
    }

    @Test
    public void testAlternateSearchPattern(){
        String text = "Leaf Hurricane";
        String pattern = "Hurri";

        boolean result = underTest.searchPatternPractice(pattern, text);

        Assertions.assertTrue(result);
    }

    @Test
    public void testAlternateSearchPatternFalse(){
        String text = "Jeff Hardy";
        String pattern = "Matt";

        boolean result = underTest.searchPatternPractice(pattern, text);

        Assertions.assertFalse(result);
    }
}
