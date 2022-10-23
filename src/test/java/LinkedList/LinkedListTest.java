package LinkedList;

import Queue.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private LinkedList<Song> underTest;

    @BeforeEach
    public void setUp(){
        underTest = new LinkedList<Song>();
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
        listOfSongs().stream().forEach(underTest::insertHead);
        underTest.viewAll();
        int songListSize = listOfSongs().size();
        int linkedListSize = underTest.getSize();
        assertEquals(songListSize, linkedListSize);
    }

    @Test
    public void insertHead3(){
        listOfSongs().stream().forEach(underTest::insertTail);
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
        listOfSongs().stream().forEach(underTest::insertTail);
        underTest.viewAll();
        int songListSize = listOfSongs().size();
        int linkedListSize = underTest.getSize();
        assertEquals(songListSize, linkedListSize);
    }

    @Test
    public void insertTail3(){
        listOfSongs().stream().forEach(underTest::insertHead);
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
        assertThat(headSong).isEqualToComparingFieldByField(newSong);
    }

    @Test
    public void insertAtIndex3(){
        listOfSongs().forEach(underTest::insertHead);
        Song newSong = new Song("Remind Me", "Röyksopp", "Electronic", 2001);
        underTest.insertAtIndex(underTest.getSize() + 1, newSong);
        underTest.viewAll();
        Song tailSong = underTest.viewTail();
        assertThat(tailSong).isEqualToComparingFieldByField(newSong);
    }

    @Test
    public void insertAtIndex4(){
        listOfSongs().forEach(underTest::insertTail);
        Song newSong = new Song("Remind Me", "Röyksopp", "Electronic", 2001);
        int index = 3;
        underTest.insertAtIndex(index, newSong);
        //underTest.viewAll();
        Song indexSong = null;
        Node<Song> node = underTest.searchNode(index);
        if(node != null) indexSong = node.getData();
        assertThat(indexSong).isNotNull().isEqualToComparingFieldByField(newSong);
    }
}
