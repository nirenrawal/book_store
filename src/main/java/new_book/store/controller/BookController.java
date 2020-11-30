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

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> findBookById(@PathVariable("bookId") int bookId){
        return bookService.getById(bookId);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return bookService.getAll();
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return bookService.createNewBook(book);
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book){
        return bookService.updateBookById(bookId, book);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("bookId") int bookId){
        return bookService.deleteBooks(bookId);
    }

    @DeleteMapping("/books")
    public ResponseEntity<HttpStatus> deleteAllBooks(){
        return bookService.deleteBooks();
    }

}
