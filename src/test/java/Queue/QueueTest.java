package Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private Queue underTest;
    private int testCapacity = 5;

    @BeforeEach
    public void setUp(){
        underTest = new Queue(testCapacity);
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
        assertEquals(testCapacity, underTest.getCurrentSize());
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

    @Test
    @DisplayName("Testing single dequeue call")
    public void testDequeueFunction1(){
        Arrays.stream(getSongsArray()).forEach(underTest::enqueue);
        System.out.println("BEFORE:\n");
        underTest.viewAll();
        Song removedSong = underTest.dequeue();
        System.out.println("AFTER:\n");
        underTest.viewAll();
        String title = removedSong.getSongTitle();
        String artist = removedSong.getSongArtist();
        String genre = removedSong.getSongGenre();
        int year = removedSong.getSongReleaseYear();
        assertEquals(getSongsArray()[0].getSongTitle(), title);
        assertEquals(getSongsArray()[0].getSongArtist(), artist);
        assertEquals(getSongsArray()[0].getSongGenre(), genre);
        assertEquals(getSongsArray()[0].getSongReleaseYear(), year);
    }

    @Test
    @DisplayName("Testing multiple dequeue call")
    public void testDequeueFunction2() {
        Arrays.stream(getSongsArray()).forEach(underTest::enqueue);
        System.out.println("BEFORE:\n");
        underTest.viewAll();
        for (int i = 0; i < testCapacity; i++) underTest.dequeue();
        System.out.println("AFTER:\n");
        underTest.viewAll();
        assertEquals(0, underTest.getCurrentSize());
    }

    @Test
    @DisplayName("Testing dequeue return null when queue is empty")
    public void testDequeueFunction3() {
        Arrays.stream(getSongsArray()).forEach(underTest::enqueue);
        System.out.println("BEFORE:\n");
        underTest.viewAll();
        for (int i = 0; i < testCapacity; i++) underTest.dequeue();
        Song removedSong = underTest.dequeue();
        System.out.println("AFTER:\n");
        underTest.viewAll();
        assertNull(removedSong);
    }

    @Test
    @DisplayName("Testing dequeue and adding object back to queue")
    public void testDequeueFunction4(){
        Arrays.stream(getSongsArray()).forEach(underTest::enqueue);
        System.out.println("BEFORE:\n");
        underTest.viewAll();
        for(int i = 0; i < testCapacity; i++) underTest.dequeue();
        Song lilB = new Song("Flex 36", "Lil B",
                "Hip-Hop/Rap/Based", 2012);
        underTest.enqueue(lilB);
        Song peekedSong = underTest.peek();
        System.out.println("AFTER:\n");
        underTest.viewAll();
        String title = peekedSong.getSongTitle();
        String artist = peekedSong.getSongArtist();
        String genre = peekedSong.getSongGenre();
        int year = peekedSong.getSongReleaseYear();
        assertEquals(lilB.getSongTitle(), title);
        assertEquals(lilB.getSongArtist(), artist);
        assertEquals(lilB.getSongGenre(), genre);
        assertEquals(lilB.getSongReleaseYear(), year);
    }
}
