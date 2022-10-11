package Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void testPushFunction(){
        Books theStand = getBooksArray()[0];
        boolean result = underTest.push(theStand);
        underTest.viewAll();
        assertTrue(result);
    }

    @Test
    public void testPushFunction2(){
       for(int i = 0; i < 2; i++)
           underTest.push(getBooksArray()[i]);
        underTest.viewAll();
        assertEquals(2, underTest.getCurrentSize());
    }

    @Test
    public void testPushFunction3(){
        Arrays.stream(getBooksArray()).forEach(underTest::push);
        Books monster = new Books("Monster", "Walter Dean Myers", 1999);
        boolean bookPushed = underTest.push(monster);
        underTest.viewAll();
        assertFalse(bookPushed);
    }

    @Test
    public void testPopFunction1(){
        Arrays.stream(getBooksArray()).forEach(underTest::push);
        System.out.println("BEFORE\n");
        underTest.viewAll();
        Books bookRemoved = underTest.pop();
        System.out.println("AFTER\n");
        underTest.viewAll();
        assertThat(bookRemoved).isEqualToComparingFieldByField(getBooksArray()[getBooksArray().length - 1]);
    }

    @Test
    public void testPopFunction2(){
        Arrays.stream(getBooksArray()).forEach(underTest::push);
        System.out.println("BEFORE\n");
        underTest.viewAll();
        while(underTest.getCurrentSize() > 0)
            underTest.pop();
        System.out.println("AFTER\n");
        underTest.viewAll();
        assertEquals(0, underTest.getCurrentSize());
    }

    @Test
    public void testPopFunction3(){
        Arrays.stream(getBooksArray()).forEach(underTest::push);
        System.out.println("BEFORE\n");
        underTest.viewAll();
        while(underTest.getCurrentSize() > 0)
            underTest.pop();
        System.out.println("AFTER\n");
        underTest.viewAll();
        Books bookRemoved = underTest.pop();
        assertNull(bookRemoved);
    }

    @Test
    public void testPeekFunction1(){
        for(int i = 0; i < 2; i++)
            underTest.push(getBooksArray()[i]);
        Books peekBook = underTest.peek();
        Books fromArray = getBooksArray()[1];
        assertThat(peekBook.getBookTitle()).isEqualTo(fromArray.getBookTitle());
        assertEquals(peekBook.getBookAuthor(), fromArray.getBookAuthor());
        assertEquals(peekBook.getBookPublish(), fromArray.getBookPublish());

    }

    @Test
    public void testPeekFunction2(){
        Books[] bookArray = getBooksArray();
        Arrays.stream(bookArray).forEach(underTest::push);
        underTest.pop();
        Books peekBook = underTest.peek();
        Books compareBook = bookArray[3];
        assertEquals(peekBook.getBookTitle(), compareBook.getBookTitle());
        assertEquals(peekBook.getBookAuthor(), compareBook.getBookAuthor());
        assertEquals(peekBook.getBookPublish(), compareBook.getBookPublish());
    }

    @Test
    public void testPeekFunction3(){
        Books peekBook = underTest.peek();
        assertNull(peekBook);
    }
}