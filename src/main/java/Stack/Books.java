package Stack;

public class Books {

    private String bookTitle;
    private String bookAuthor;
    private int bookPublish;
    private boolean bookRented;

    public Books(String bookTitle, String bookAuthor, int bookPublish){
        this(bookTitle, bookAuthor, bookPublish, false);
    }

    public Books(String bookTitle, String bookAuthor, int bookPublish, boolean bookRented){
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublish = bookPublish;
        this.bookRented = bookRented;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(int bookPublish) {
        this.bookPublish = bookPublish;
    }

    public boolean isBookRented() {
        return bookRented;
    }

    public void setBookRented(boolean bookRented) {
        this.bookRented = bookRented;
    }

    public String toString(){
        return "Book Information:\n" +
                "Title: " + bookTitle + "\n" +
                "Author: " + bookAuthor + "\n" +
                "Publish Year: " + bookPublish + "\n\n";
    }
}
