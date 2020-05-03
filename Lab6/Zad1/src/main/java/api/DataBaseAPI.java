package api;

import model.*;

import java.util.List;

public interface DataBaseAPI {
    List<Author> getAllAuthors();

    List<Book> getAllBooks();

    List<Category> getAllCategories();

    List<Loan> getAllLoans();

//    List<Reader> getAllReaders();
//    void addReader(Reader reader);
//    void deleteReader(int id);
//    void updateReader(int id, Reader reader);

    List<Specimen> getAllSpecimens();

}
