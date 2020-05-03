package api;

import model.Book;

import java.util.List;

public interface BookAPI {
    List<Book> getAllBooks();
    void addBook(Book book);
    void deleteBook(int id);
    void updateBook(int id, Book book);
    Book getBook(int id);
}
