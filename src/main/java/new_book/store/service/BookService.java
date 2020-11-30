package new_book.store.service;

import new_book.store.model.Book;
import new_book.store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    //FIND BOOK BY AN ID
    public ResponseEntity<Book> getById(int bookId) {
        Optional<Book> b = bookRepository.findById(bookId);
        if (b.isPresent())
            return new ResponseEntity<>(b.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //SHOW ALL BOOKS
    public ResponseEntity<List<Book>> getAll() {
        try {
            List<Book> books = bookRepository.findAll();
            if (books.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //CREATE A NEW BOOK
    public ResponseEntity<Book> createNewBook(@RequestBody Book book) {
        try {
            Book book1 = bookRepository.save(book);
            return new ResponseEntity<>(book1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //UPDATE A BOOK
    public ResponseEntity<Book> updateBookById(@PathVariable("bookId") int bookId, @RequestBody Book book) {
        Optional<Book> bookData = bookRepository.findById(bookId);
        if (bookData.isPresent()) {
            Book book1 = bookData.get();
            book1.setTitle(book.getTitle());
            book1.setEdition(book.getEdition());
            book1.setPrice(book.getPrice());
            book1.setAuthorByAuthorId(book.getAuthorByAuthorId());
            book1.setCategoryByCategoryId(book.getCategoryByCategoryId());
            return new ResponseEntity<>(bookRepository.save(book1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE A BOOK
    public ResponseEntity<HttpStatus> deleteBooks(@PathVariable("bookId") int bookId) {
        try {
            bookRepository.deleteById(bookId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE ALL BOOKS
    public ResponseEntity<HttpStatus> deleteBooks(){
        try{
            bookRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
