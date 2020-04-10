import CurrencyExchange.Exchanger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "Search")
@SessionScoped
public class SearchClass {

    String title = "";
    String author = "";
    String category = "";
    int priceMin = 0;
    int priceMax = 100;
    String currency = "";
    int numOfPagesMin = 0;
    int numOfPagesMax = 10000;
    boolean inPLN = true;
    Exchanger exchanger= new Exchanger();

    BookRepository bookRepository = new BookRepository();
    List<Book> orderedBooks = new ArrayList<>();
    double sumOfOrder = 0.0;

    boolean visibleTitle = true;
    boolean visibleAuthor = true;
    boolean visibleCategory = true;
    boolean visiblePrice = true;
    boolean visibleCurrency = true;
    boolean visiblePages = true;

    boolean searchTitle = false;
    boolean searchAuthor = false;
    boolean searchCategory = false;
    boolean searchPrice = true;
    boolean searchCurrency = false;
    boolean searchPages = false;



    public List<Book> getBooksForSearch()
    {
        List<Book> result = new ArrayList<>();
        boolean matches;
        for (Book book: bookRepository.bookList)
        {
            matches = true;
            if(searchTitle) matches = matches && book.title.equals(title);
            if(searchAuthor) matches = matches && book.author.equals(author);
            if(searchCategory) matches = matches && book.category.equals(category);
            if(searchPrice) matches = matches && (priceForBook(book)>=priceMin && priceForBook(book)<=priceMax);
            if(searchCurrency) matches = matches && book.currency.equals(currency);
            if(searchPages) matches = matches && (book.numOfPages>=numOfPagesMin && book.numOfPages<=numOfPagesMax);

            if(matches) result.add(book);
        }
        return result;
    }

    public String currencyForBook(Book book)
    {
        if(this.inPLN) return "PLN";
        else return book.currency;
    }

    public double priceForBook(Book book)
    {
        if(this.inPLN)
            return Math.ceil(exchanger.exchangeToPLN(book.currency,book.price));
        else
            return book.price;
    }


    public String submitOrder(){
        orderedBooks.clear();
        sumOfOrder = 0;
        for (Book book: getBooksForSearch())
        {
            if (book.selected){
                orderedBooks.add(book);
                sumOfOrder += Math.ceil(exchanger.exchangeToPLN(book.currency,book.price));
            }
        }
        return "summary";
    }

    public Boolean isSthVisible() {
        return visibleTitle || visibleAuthor || visibleCategory || visiblePrice || visibleCurrency || visiblePages;
    }

    // Getters and Setters

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getNumOfPagesMin() {
        return numOfPagesMin;
    }

    public void setNumOfPagesMin(int numOfPagesMin) {
        this.numOfPagesMin = numOfPagesMin;
    }

    public int getNumOfPagesMax() {
        return numOfPagesMax;
    }

    public void setNumOfPagesMax(int numOfPagesMax) {
        this.numOfPagesMax = numOfPagesMax;
    }

    public boolean isInPLN() {
        return inPLN;
    }

    public void setInPLN(boolean inPLN) {
        this.inPLN = inPLN;
    }

    public boolean isVisibleTitle() {
        return visibleTitle;
    }

    public void setVisibleTitle(boolean visibleTitle) {
        this.visibleTitle = visibleTitle;
    }

    public boolean isVisibleAuthor() {
        return visibleAuthor;
    }

    public void setVisibleAuthor(boolean visibleAuthor) {
        this.visibleAuthor = visibleAuthor;
    }

    public boolean isVisibleCategory() {
        return visibleCategory;
    }

    public void setVisibleCategory(boolean visibleCategory) {
        this.visibleCategory = visibleCategory;
    }

    public boolean isVisiblePrice() {
        return visiblePrice;
    }

    public void setVisiblePrice(boolean visiblePrice) {
        this.visiblePrice = visiblePrice;
    }

    public boolean isVisibleCurrency() {
        return visibleCurrency;
    }

    public void setVisibleCurrency(boolean visibleCurrency) {
        this.visibleCurrency = visibleCurrency;
    }

    public boolean isVisiblePages() {
        return visiblePages;
    }

    public void setVisiblePages(boolean visiblePages) {
        this.visiblePages = visiblePages;
    }

    public boolean isSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(boolean searchTitle) {
        this.searchTitle = searchTitle;
    }

    public boolean isSearchAuthor() {
        return searchAuthor;
    }

    public void setSearchAuthor(boolean searchAuthor) {
        this.searchAuthor = searchAuthor;
    }

    public boolean isSearchCategory() {
        return searchCategory;
    }

    public void setSearchCategory(boolean searchCategory) {
        this.searchCategory = searchCategory;
    }

    public boolean isSearchPrice() {
        return searchPrice;
    }

    public void setSearchPrice(boolean searchPrice) {
        this.searchPrice = searchPrice;
    }

    public boolean isSearchCurrency() {
        return searchCurrency;
    }

    public void setSearchCurrency(boolean searchCurrency) {
        this.searchCurrency = searchCurrency;
    }

    public boolean isSearchPages() {
        return searchPages;
    }

    public void setSearchPages(boolean searchPages) {
        this.searchPages = searchPages;
    }

    public double getSumOfOrder() {
        return sumOfOrder;
    }

    public void setSumOfOrder(double sumOfOrder) {
        this.sumOfOrder = sumOfOrder;
    }

    public List<Book> getOrderedBooks() {
        return orderedBooks;
    }

    public void setOrderedBooks(List<Book> orderedBooks) {
        this.orderedBooks = orderedBooks;
    }
}
