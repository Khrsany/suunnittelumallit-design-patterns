public class Book implements Cloneable {
    // kirjan perustiedot
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public Book clone() {
        // tehdään uusi samanlainen kirja
        return new Book(title, author, genre, publicationYear);
    }

    @Override
    public String toString() {
        return title + " by " + author + " | Genre: " + genre + " | Year: " + publicationYear;
    }
}