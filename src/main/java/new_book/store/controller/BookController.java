package new_book.store.controller;

import new_book.store.model.Book;
import new_book.store.repository.BookRepository;
import new_book.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateTutorial(@PathVariable("bookId") int bookId, @RequestBody Book book) {
        Optional<Book> bookData = bookRepository.findById(bookId);

        if (bookData.isPresent()) {
            Book _book = bookData.get();
            _book.setTitle(book.getTitle());
            _book.setEdition(book.getEdition());
            _book.setPrice(book.getPrice());
            _book.setAuthorByAuthorId(book.getAuthorByAuthorId());
            _book.setCategoryByCategoryId(book.getCategoryByCategoryId());
            return new ResponseEntity<>(bookRepository.save(_book), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("bookId") int bookId) {
        try {
            bookRepository.deleteById(bookId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/books/{title}")
//    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title){
//        return bookService.getByTitle(title);
//    }
}
