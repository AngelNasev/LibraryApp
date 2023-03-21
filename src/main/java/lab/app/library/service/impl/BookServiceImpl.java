package lab.app.library.service.impl;

import lab.app.library.model.Author;
import lab.app.library.model.Book;
import lab.app.library.model.dto.BookDto;
import lab.app.library.model.exceptions.AuthorNotFoundException;
import lab.app.library.repository.AuthorRepository;
import lab.app.library.repository.BookRepository;
import lab.app.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        Book book = new Book(bookDto.getName(),bookDto.getCategory(),author,bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }
}
