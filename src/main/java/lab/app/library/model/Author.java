package lab.app.library.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Author() {
    }
}
