package lab.app.library.config;

import jakarta.annotation.PostConstruct;
import lab.app.library.model.Author;
import lab.app.library.model.Book;
import lab.app.library.model.Country;
import lab.app.library.model.enumerations.Category;
import lab.app.library.repository.AuthorRepository;
import lab.app.library.repository.BookRepository;
import lab.app.library.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void initData() {
        for (int i = 1; i <= 20; i++) {
            Country country = new Country();
            country.setName(String.format("Country %d", i));
            country.setContinent(String.format("Continent %d", i));
            countryRepository.save(country);

            Author author = new Author();
            author.setName(String.format("AuthorName %d", i));
            author.setSurname(String.format("AuthorSurname %d", i));
            author.setCountry(country);
            authorRepository.save(author);

            Book book = new Book();
            book.setName(String.format("BookName %d", i));
            book.setAuthor(author);
            book.setCategory(Category.values()[i % Category.values().length]);
            book.setAvailableCopies(i);
            bookRepository.save(book);
        }
    }
}
