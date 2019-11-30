package alexandertang.playground.graphql.controller;

import alexandertang.playground.graphql.repository.AuthorRepository;
import alexandertang.playground.graphql.model.Author;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class AuthorController {

    private AuthorRepository authorRepository;

    @GetMapping(value = "/all-authors")
    public List<Author> getAllAuthors () {
        return authorRepository.findAll();
    }
}
