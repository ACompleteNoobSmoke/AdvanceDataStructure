package Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    public Stack underTest;

    @BeforeEach
    public void setUp(){
        underTest = new Stack(5);
    }

    public Books[] getBooksArray(){
        Books theStand = new Books("The Stand", "Stephen King", 1988);
        Books bourneIdentity = new Books("The Bourne Identity", "Robert Ludlum", 1980);
        Books goosebumps = new Books("Goosebumps", "R.L Stine", 2001);
        Books othello = new Books("Othello", "William Shakespeare", 1601);
        Books perksWallflower = new Books("The Perks of Being a Wallflower", "Stephen Chbosky", 1999);
        return new Books[]{theStand, bourneIdentity, goosebumps, othello, perksWallflower};
    }

    @Test
    public void testPopFunction(){
        Books theStand = getBooksArray()[0];
        boolean result = underTest.push(theStand);
        underTest.viewAll();
        assertTrue(result);
    }

    @Test
    public void testPopFunction2(){
       for(int i = 0; i < 2; i++)
           underTest.push(getBooksArray()[i]);
        underTest.viewAll();
        assertEquals(2, underTest.getCurrentSize());
    }

    @Test
    public void testPopFunction3(){
        Arrays.stream(getBooksArray()).forEach(underTest::push);
        Books monster = new Books("Monster", "Walter Dean Myers", 1999);
        boolean bookPushed = underTest.push(monster);
        underTest.viewAll();
        assertFalse(bookPushed);
    }
}