package Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private Queue underTest;

    @BeforeEach
    public void setUp(){
        underTest = new Queue(5);
    }

    private Song[] getSongsArray(){
        Song newSong1 = new Song("Bells Of Doom", "MF DOOM", "Hip-Hop/Rap", 2006);
        Song newSong2 = new Song("Be Above It", "Tame Impala", "Rock", 2012);
        Song newSong3 = new Song("Flowers", "Nujabes", "Lo-Fi", 2006);
        Song newSong4 = new Song("Soldier", "Eminem", "Hip-Hop/Rap", 2002);
        Song newSong5 = new Song("Suggestions", "System Of A Down", "Rock", 1999);
        return new Song[]{newSong1, newSong2, newSong3, newSong4, newSong5};
    }

    @Test
    @DisplayName("Add single element to queue")
    public void testEnqueueFunction1(){
        underTest.enqueue(getSongsArray()[0]);
        underTest.viewAll();
        assertEquals(1, underTest.getCurrentSize());
    }

    @Test
    @DisplayName("Can add multiple elements to queue")
    public void testEnqueueFunction2(){
        Arrays.stream(getSongsArray()).forEach(underTest::enqueue);
        underTest.viewAll();
        assertEquals(5, underTest.getCurrentSize());
    }

    @Test
    @DisplayName("Make sure no other element can be added to the queue once it is full")
    public void testEnqueueFunction3(){
        Arrays.stream(getSongsArray()).forEach(underTest::enqueue);
        System.out.println("BEFORE:\n");
        underTest.viewAll();
        Song newSong = new Song("Flex 36", "Lil B", "Hip-Hop/Rap/Based", 2012);
        boolean added = underTest.enqueue(newSong);
        System.out.println("AFTER:\n");
        underTest.viewAll();
        assertFalse(added);
    }

}
