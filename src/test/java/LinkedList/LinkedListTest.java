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
        Song newSong = new Song("Miss The Rage", "Trippie Red", "Hip-Hop", 2021);
        underTest.insertHead(newSong);
        underTest.viewAll();
        int listSize = underTest.getSize();
        assertEquals(1, listSize);
    }

    @Test
    public void insertHead2(){
        Song newSong = new Song("Miss The Rage", "Trippie Red", "Hip-Hop", 2021);
        Song newSong2 = new Song("North North", "Project Pat", "Hip-Hop", 1999);
        underTest.insertHead(newSong);
        underTest.insertHead(newSong2);
        underTest.viewAll();
        int listSize = underTest.getSize();
        assertEquals(2, listSize);
    }
}
