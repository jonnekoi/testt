import java.util.ArrayList;

public class Library {

    ArrayList<String> books = new ArrayList<>();

    public void addBook(String book) {
        books.add(book);
    }

    public void removeBook(String book) {
        books.remove(book);
    }

    public ArrayList<String> listBooks() {
        return books;
    }
}