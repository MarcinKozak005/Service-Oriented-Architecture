package api;

import database.BooksTableEntity;
import java.util.List;

public interface DataBaseAPI {
    List<BooksTableEntity> getAllBooks();
    void addBook(BooksTableEntity book);
    void deleteBookById(int toDeleteId);
    void updateBook(int toUpdateId, BooksTableEntity schema);
}
