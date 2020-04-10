import java.util.ArrayList;
import java.util.List;

public class BookRepository
{
    List<Book> bookList = new ArrayList<>();

    public BookRepository() {
        bookList.add(new Book("Harry Potter","JK Rowling","Fantasy",120,"GBP",200));
        bookList.add(new Book("Pan Tadeusz","Adam Mickiewicz","Polish",50,"PLN",500));
        bookList.add(new Book("Ogniem i mieczem","Henryk Sienkiewicz","Polish",30,"PLN",300));
        bookList.add(new Book("English for everyone","Mr. Beans","Comedy",110,"GBP",50));
        bookList.add(new Book("Title 1 ","Author 1","2 Category",20,"CHF",1000));
        bookList.add(new Book("Title 2 ","Author 1","3 Category",2110,"EUR",1000));
        bookList.add(new Book("Title 3 ","Author 2","1 Category",200,"CHF",1000));
        bookList.add(new Book("Title 4 ","Author 2","2 Category",2000,"JPY",1000));
        bookList.add(new Book("Title 5 ","Author 2","3 Category",120,"PLN",1000));
        bookList.add(new Book("Title 6 ","Author 3","1 Category",220,"USD",1000));
        bookList.add(new Book("Title 7 ","Author 3","3 Category",320,"USD",1000));

    }

    // Getters and Setters
}
