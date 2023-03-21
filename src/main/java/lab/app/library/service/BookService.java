package lab.app.library.service;

import lab.app.library.model.Book;
import lab.app.library.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id, BookDto bookDto);
    void delete(Long id);
    Optional<Book> markAsTaken(Long id);
}
