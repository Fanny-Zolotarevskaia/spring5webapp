package guru.springframework.spring5webapp.model;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Fanny on 09/26/22.
 */
@Entity //Annotate to imply this is a JPA Entity
public class Author {
    @Id //Annotate it as this is the ID
    @GeneratedValue(strategy = GenerationType.AUTO) //Tells Hibernate how this value is generated, GenerationType.AUTO means that the underlying database is going to be providing the generation of this
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
