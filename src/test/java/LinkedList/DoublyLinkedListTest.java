package LinkedList;

import Queue.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DoublyLinkedListTest {
    private DoublyLinkedList<Song> underTest;

    @BeforeEach
    public void setUp(){
        underTest = new DoublyLinkedList<Song>();
    }

    private ArrayList<Song> listOfSongs(){
        ArrayList<Song> songList = new ArrayList<>();
        songList.add(new Song("Miss The Rage", "Trippie Red", "Hip-Hop", 2021));
        songList.add(new Song("North North", "Project Pat", "Hip-Hop", 1999));
        songList.add(new Song("Flex 36", "Lil B", "Hip-Hop/Rap/Based", 2012));
        songList.add(new Song("Suggestions", "System Of A Down", "Rock", 1999));
        songList.add(new Song("Flowers", "Nujabes", "Lo-Fi", 2006));
        return songList;
    }

    @Test
    public void insertHead1(){
        Song newSong = listOfSongs().get(0);
        underTest.insertHead(newSong);
        underTest.viewAll();
        int listSize = underTest.getSize();
        assertEquals(1, listSize);
    }

    @Test
    public void insertHead2(){
        listOfSongs().forEach(underTest::insertHead);
        underTest.viewAll();
        int songListSize = listOfSongs().size();
        int linkedListSize = underTest.getSize();
        assertEquals(songListSize, linkedListSize);
    }

    @Test
    public void insertHead3(){
        listOfSongs().forEach(underTest::insertTail);
        underTest.insertHead(new Song("Sicko Mode", "Travis $cott", "Hip-Hop", 2018));
        underTest.viewAll();
        int songListSize = listOfSongs().size();
        int linkedListSize = underTest.getSize();
        assertEquals(songListSize + 1, linkedListSize);

    }

    @Test
    public void insertTail1(){
        underTest.insertTail(listOfSongs().get(0));
        underTest.viewAll();
        int linkedListSize = underTest.getSize();
        assertEquals(1, linkedListSize);
    }

    @Test
    public void insertTail2(){
        listOfSongs().forEach(underTest::insertTail);
        underTest.viewAll();
        int songListSize = listOfSongs().size();
        int linkedListSize = underTest.getSize();
        assertEquals(songListSize, linkedListSize);
    }

    @Test
    public void insertTail3(){
        listOfSongs().forEach(underTest::insertHead);
        underTest.insertTail(new Song("Remind Me", "Röyksopp", "Electronic", 2001));
        underTest.viewAll();
        int songListSize = listOfSongs().size();
        int linkedListSize = underTest.getSize();
        assertEquals(songListSize + 1, linkedListSize);
    }

    @Test
    public void insertAtIndex1(){
        underTest.insertAtIndex(5, listOfSongs().get(0));
        underTest.viewAll();
        int linkedListSize = underTest.getSize();
        assertEquals(0, linkedListSize);
    }

    @Test
    public void insertAtIndex2(){
        listOfSongs().forEach(underTest::insertTail);
        Song newSong = new Song("Remind Me", "Röyksopp", "Electronic", 2001);
        underTest.insertAtIndex(1, newSong);
        underTest.viewAll();
        Song headSong = underTest.viewHead();
        assertThat(headSong).usingRecursiveComparison().isEqualTo(newSong);
    }

    @Test
    public void insertAtIndex3(){
        listOfSongs().forEach(underTest::insertHead);
        Song newSong = new Song("Remind Me", "Röyksopp", "Electronic", 2001);
        underTest.insertAtIndex(underTest.getSize() + 1, newSong);
        underTest.viewAll();
        Song tailSong = underTest.viewTail();
        assertThat(tailSong).usingRecursiveComparison().isEqualTo(newSong);
    }

    @Test
    public void insertAtIndex4(){
        listOfSongs().forEach(underTest::insertTail);
        Song newSong = new Song("Remind Me", "Röyksopp", "Electronic", 2001);
        int index = 3;
        underTest.insertAtIndex(index, newSong);
        Song indexSong = underTest.searchNode(index);
        assertThat(indexSong).usingRecursiveComparison().isEqualTo(newSong);
    }

    @Test
    public void removeHead1(){
        Song headSong = underTest.removeHead();
        assertNull(headSong);
    }

    @Test
    public void removeHead2(){
        listOfSongs().forEach(underTest::insertTail);
        System.out.println("BEFORE:\n\n");
        underTest.viewAll();
        Song firstSong = listOfSongs().get(0);
        Song headSong = underTest.removeHead();
        System.out.println("AFTER:\n\n");
        underTest.viewAll();
        assertThat(headSong).usingRecursiveComparison().isEqualTo(firstSong);
    }

    @Test
    public void removeHead3(){
        listOfSongs().forEach(underTest::insertHead);
        System.out.println("BEFORE:\n\n");
        underTest.viewAll();
        Song firstSong = listOfSongs().get(listOfSongs().size() - 1);
        Song headSong = underTest.removeHead();
        System.out.println("AFTER:\n\n");
        underTest.viewAll();
        assertThat(headSong).usingRecursiveComparison().isEqualTo(firstSong);
    }

    @Test
    public void removeTail1(){
        Song tailSong = underTest.removeTail();
        assertNull(tailSong);
    }

    @Test
    public void removeTail2(){
        listOfSongs().forEach(underTest::insertTail);
        Song lastSong = listOfSongs().get(listOfSongs().size() - 1);
        System.out.println("BEFORE:\n\n");
        underTest.viewAll();
        Song tailSong = underTest.removeTail();
        System.out.println("AFTER:\n\n");
        underTest.viewAll();
        assertThat(tailSong).usingRecursiveComparison().isEqualTo(lastSong);
    }

    @Test
    public void removeAtIndex1(){
        Song removedSong = underTest.removeAtIndex(1);
        assertNull(removedSong);
    }

    @Test
    public void removeAtIndex2(){
        listOfSongs().forEach(underTest::insertTail);
        Song removedSong = underTest.removeAtIndex(0);
        assertNull(removedSong);
    }

    @Test
    public void removeAtIndex3(){
        listOfSongs().forEach(underTest::insertHead);
        Song removedSong = underTest.removeAtIndex(8);
        assertNull(removedSong);
    }

    @Test
    public void removeAtIndex4(){
        listOfSongs().forEach(underTest::insertTail);
        System.out.println("BEFORE:\n\n");
        underTest.viewAll();
        Song compareSong = listOfSongs().get(0);
        Song removedSong = underTest.removeAtIndex(1);
        System.out.println("AFTER:\n\n");
        underTest.viewAll();
        assertThat(removedSong).usingRecursiveComparison().isEqualTo(compareSong);
    }

    @Test
    public void removeAtIndex5(){
        listOfSongs().forEach(underTest::insertTail);
        System.out.println("BEFORE:\n\n");
        underTest.viewAll();
        int index = listOfSongs().size() - 1;
        Song compareSong = listOfSongs().get(index);
        Song removedSong = underTest.removeAtIndex(index + 1);
        System.out.println("AFTER:\n\n");
        underTest.viewAll();
        assertThat(removedSong).usingRecursiveComparison().isEqualTo(compareSong);
    }

    @Test
    public void removeAtIndex6(){
        listOfSongs().forEach(underTest::insertTail);
        System.out.println("BEFORE:\n\n");
        underTest.viewAll();
        int index = new Random().nextInt(0, listOfSongs().size() - 1);
        Song compareSong = listOfSongs().get(index);
        Song removedSong = underTest.removeAtIndex(index + 1);
        System.out.println("AFTER:\n\n");
        underTest.viewAll();
        assertThat(removedSong).usingRecursiveComparison().isEqualTo(compareSong);
    }

    @Test
    public void removeAtIndex7(){
        listOfSongs().forEach(underTest::insertTail);
        System.out.println("BEFORE:\n\n");
        underTest.viewAll();
        int index = 3;
        Song compareSong = listOfSongs().get(index);
        Song removedSong = underTest.removeAtIndex(index + 1);
        System.out.println("AFTER:\n\n");
        underTest.viewAll();
        assertThat(removedSong).usingRecursiveComparison().isEqualTo(compareSong);
    }
}
