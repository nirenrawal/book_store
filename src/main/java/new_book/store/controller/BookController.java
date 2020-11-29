package new_book.store.controller;

import new_book.store.model.Book;
import new_book.store.repository.BookRepository;
import new_book.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @GetMapping("/books/{title}")
//    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title){
//        return bookService.getByTitle(title);
//    }
}
