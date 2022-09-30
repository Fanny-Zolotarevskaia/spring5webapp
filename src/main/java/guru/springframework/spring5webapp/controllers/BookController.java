package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Fanny on 09/27/22.
 */
@Controller
public class BookController {

    private final BookRepository bookRepository; // Inject a book repo

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") // This method is invoked when calling on this endpoint
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll()); //gets a list of books present in the repository

        return "books/list";
    }
}
