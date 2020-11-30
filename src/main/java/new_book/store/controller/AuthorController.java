package new_book.store.controller;

import new_book.store.model.Author;
import new_book.store.repository.AuthorRepository;
import new_book.store.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return authorService.getAll();
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return authorService.createNewAuthor(author);
    }

    @DeleteMapping("/authors/{authorId}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable("authorId") int authorId){
        return authorService.deleteAuthors(authorId);
    }
}
