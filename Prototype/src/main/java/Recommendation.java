import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    // kenelle lista on tarkoitettu
    private String targetAudience;

    // tähän tulee kirjat
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        // tätä voi muuttaa vaikka kloonauksen jälkeen
        this.targetAudience = targetAudience;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBookByTitle(String title) {
        // poistetaan kirja nimen perusteella
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Recommendation clone() {
        // luodaan uusi recommendation
        Recommendation copy = new Recommendation(this.targetAudience);

        // deep copy: kopioidaan myös jokainen kirja
        for (Book book : this.books) {
            copy.addBook(book.clone());
        }

        return copy;
    }

    public void show() {
        System.out.println("Target audience: " + targetAudience);

        if (books.isEmpty()) {
            System.out.println("No books in this recommendation.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }
}