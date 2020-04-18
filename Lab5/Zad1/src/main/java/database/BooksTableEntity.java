package database;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "books_table", schema = "public", catalog = "books")
public class BooksTableEntity {
    private String authorSurname;
    private String authorName;
    private String bookTitle;
    private String isbnNumber;
    private Date dateOfIssue;
    private BigDecimal price;
    private int id;

    public BooksTableEntity() {
    }

    public BooksTableEntity(String authorSurname, String authorName, String bookTitle, String isbnNumber, Date dateOfIssue, BigDecimal price) {
        this.authorSurname = authorSurname;
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.isbnNumber = isbnNumber;
        this.dateOfIssue = dateOfIssue;
        this.price = price;
    }

    @Column(name = "author_surname")
    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    @Column(name = "author_name")
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Column(name = "book_title")
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Column(name = "isbn_number")
    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_issue")
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
