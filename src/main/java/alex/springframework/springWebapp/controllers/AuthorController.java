package alex.springframework.springWebapp.controllers;

import alex.springframework.springWebapp.repository.AuthorRepository;
import alex.springframework.springWebapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getBooks(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        return "author/list";
   }
}
