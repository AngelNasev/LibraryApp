package lab.app.library.service.impl;

import lab.app.library.model.Author;
import lab.app.library.model.Book;
import lab.app.library.model.dto.BookDto;
import lab.app.library.model.exceptions.AuthorNotFoundException;
import lab.app.library.model.exceptions.BookNotFoundException;
import lab.app.library.model.exceptions.CannotTakeBookException;
import lab.app.library.repository.AuthorRepository;
import lab.app.library.repository.BookRepository;
import lab.app.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
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

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setName(bookDto.getName());
        book.setAuthor(author);
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.delete(book);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if (book.getAvailableCopies()>=1){
            book.setAvailableCopies(book.getAvailableCopies()-1);
        }
        else{
            throw new CannotTakeBookException();
        }
        return Optional.of(this.bookRepository.save(book));
    }
}