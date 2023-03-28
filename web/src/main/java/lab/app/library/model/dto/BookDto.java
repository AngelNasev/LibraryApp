package lab.app.library.model.dto;

import lab.app.library.model.Author;
import lab.app.library.model.enumerations.Category;
import lombok.Data;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Long author;
    private Integer availableCopies;
}
