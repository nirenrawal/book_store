package new_book.store.controller;

import new_book.store.model.Book;
import new_book.store.repository.BookRepository;
import new_book.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return bookService.getAll();
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createTutorial(@RequestBody Book book){
        try {
            Book _book = bookRepository.save(book);
            return new ResponseEntity<>(_book, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/books/{title}")
//    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title){
//        return bookService.getByTitle(title);
//    }
}
