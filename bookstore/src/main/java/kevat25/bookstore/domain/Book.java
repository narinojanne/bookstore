package kevat25.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author, isbn;
    private int publicationYear;
    private double price;

    @NotEmpty(message = "Title field can not be empty")
    @Size(min = 3, max = 150)
    private String title;

    
    public Book() {
    }


    public Book(String title, String author, String isbn, int publicationYear, double price) {
        super();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public int getPublicationYear() {
        return publicationYear;
    }


    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", publicationYear=" + publicationYear
                + ", price=" + price + "]";
    }

    

}
