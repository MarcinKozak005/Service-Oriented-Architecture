import api.DataBaseAPI;
import database.BooksTableEntity;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@ManagedBean(name = "BookBean")
@SessionScoped
public class BookBean
{
    @EJB
    DataBaseAPI dataBase;

    String authorSurname;
    String authorName;
    String bookTitle;
    String isbnNumber;
    Date dateOfIssue;
    BigDecimal price;


    String authorSurnameUpdate;
    String authorNameUpdate;
    String bookTitleUpdate;
    String isbnNumberUpdate;
    Date dateOfIssueUpdate;
    BigDecimal priceUpdate;


    public void addBookToDataBase()
    {
        BooksTableEntity booksTableEntity = new BooksTableEntity(this.authorName,this.authorSurname,this.bookTitle,
                this.isbnNumber,this.dateOfIssue,this.price);
        dataBase.addBook(booksTableEntity);
        System.out.println(booksTableEntity.toString());
    }

    public void deleteBookById(int toDeleteId)
    {
        dataBase.deleteBookById(toDeleteId);
    }

    public void updateBook(int toUpdateId)
    {
        BooksTableEntity schema = new BooksTableEntity(this.authorNameUpdate,this.authorSurnameUpdate,this.bookTitleUpdate,
                this.isbnNumberUpdate,this.dateOfIssueUpdate,this.priceUpdate);
        dataBase.updateBook(toUpdateId,schema);
    }

    public List<BooksTableEntity> getAllBooks()
    {
        return dataBase.getAllBooks();
    }




    // Getters and Setters

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public String getAuthorSurnameUpdate() {
        return authorSurnameUpdate;
    }

    public void setAuthorSurnameUpdate(String authorSurnameUpdate) {
        this.authorSurnameUpdate = authorSurnameUpdate;
    }

    public String getAuthorNameUpdate() {
        return authorNameUpdate;
    }

    public void setAuthorNameUpdate(String authorNameUpdate) {
        this.authorNameUpdate = authorNameUpdate;
    }

    public String getBookTitleUpdate() {
        return bookTitleUpdate;
    }

    public void setBookTitleUpdate(String bookTitleUpdate) {
        this.bookTitleUpdate = bookTitleUpdate;
    }

    public String getIsbnNumberUpdate() {
        return isbnNumberUpdate;
    }

    public void setIsbnNumberUpdate(String isbnNumberUpdate) {
        this.isbnNumberUpdate = isbnNumberUpdate;
    }

    public Date getDateOfIssueUpdate() {
        return dateOfIssueUpdate;
    }

    public void setDateOfIssueUpdate(Date dateOfIssueUpdate) {
        this.dateOfIssueUpdate = dateOfIssueUpdate;
    }

    public BigDecimal getPriceUpdate() {
        return priceUpdate;
    }

    public void setPriceUpdate(BigDecimal priceUpdate) {
        this.priceUpdate = priceUpdate;
    }
}
