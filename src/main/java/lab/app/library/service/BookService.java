package lab.app.library.service;

import lab.app.library.model.Book;
import lab.app.library.model.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Page<Book> findAllWithPagination(Pageable pageable);

    Optional<Book> findById(Long id);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> edit(Long id, BookDto bookDto);
    void delete(Long id);
    Optional<Book> markAsTaken(Long id);
}
