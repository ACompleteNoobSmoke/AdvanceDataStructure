package BinarySearchTree;

public class Film implements Comparable<Film> {
    private int filmID;
    private String filmTitle;
    private String filmDirector;
    private int filmReleaseYear;

    public Film(int filmID, String filmTitle, String filmDirector, int filmReleaseYear){
        this.filmID = filmID;
        this.filmTitle = filmTitle;
        this.filmDirector = filmDirector;
        this.filmReleaseYear = filmReleaseYear;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(String filmDirector) {
        this.filmDirector = filmDirector;
    }

    public int getFilmReleaseYear() {
        return filmReleaseYear;
    }

    public void setFilmReleaseYear(int filmReleaseYear) {
        this.filmReleaseYear = filmReleaseYear;
    }

    public String toString(){
        return "Film Information: \n"  +
                "ID: " + filmID + "\n" +
                "Title: " + filmTitle + "\n" +
                "Director: " + filmDirector + "\n" +
                "Release Year: " + filmReleaseYear + "\n";
    }

    @Override
    public int compareTo(Film o) {
       return filmID - o.filmID;
    }
}
