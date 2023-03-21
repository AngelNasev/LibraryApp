package lab.app.library.service;

import lab.app.library.model.Book;
import lab.app.library.model.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);
}
