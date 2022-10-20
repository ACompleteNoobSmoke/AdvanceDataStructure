package LinkedList;

import Queue.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        for(int i = 0; i < 2; i++) underTest.insertHead(listOfSongs().get(i));
        underTest.viewAll();
        int listSize = underTest.getSize();
        assertEquals(2, listSize);
    }

    @Test
    public void insertHead3(){
        listOfSongs().stream().forEach(underTest::insertHead);
        underTest.viewAll();
        int songListSize = listOfSongs().size();
        int linkedListSize = underTest.getSize();
        assertEquals(songListSize, linkedListSize);
    }
}
