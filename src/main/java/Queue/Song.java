package Queue;

public class Song {
    private String songTitle;
    private String songArtist;
    private String songGenre;
    private int songReleaseYear;

    public Song(String songTitle, String songArtist, String songGenre, int songReleaseYear){
        this.songTitle = songTitle;
        this.songArtist = songArtist;
        this.songGenre = songGenre;
        this.songReleaseYear = songReleaseYear;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(String songGenre) {
        this.songGenre = songGenre;
    }

    public int getSongReleaseYear() {
        return songReleaseYear;
    }

    public void setSongReleaseYear(int songReleaseYear) {
        this.songReleaseYear = songReleaseYear;
    }

    public String toString(){
        return "SONG INFORMATION:\n" +
                "Title: " + songTitle + "\n" +
                "Artist: " + songArtist + "\n" +
                "Genre: " + songGenre + "\n" +
                "Year: " + songReleaseYear + "\n\n";
    }
}
