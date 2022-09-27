package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Xreated by Fanny 09/27/22.
 */
@Component // By marking it as a component Spring Framework is going to detect this as a Spring managed component
public class BootStrapData implements CommandLineRunner {
    // This class that implements from CommandLineRunner is going to tell Spring to look for instances of this type
    // and when it finds them it is going to go ahead and run them.

    private final AuthorRepository authorRepository; // Use dependency injection
    private final BookRepository bookRepository; // Use dependency injection

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {  // When Spring implements this component it is going to bring it into this Spring context
        this.authorRepository = authorRepository; // It will do a dependency injection into the constructor of an instance of the author repo
        this.bookRepository = bookRepository; // same her, do a dependency injection into the constructor of an instance of the book repo
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book ("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric); // save the author to the H2 database
        bookRepository.save(ddd); // save the book to the H2 database

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of Books: " + bookRepository.count());

    }
}
