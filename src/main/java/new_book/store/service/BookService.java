package new_book.store.service;

import new_book.store.model.Book;
import new_book.store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

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

//    public ResponseEntity<Book> getByTitle(String title) {
//        List<Book> bookData = bookRepository.findByTitleContaining(title);
//        if (bookData.contains())
//            return new ResponseEntity<>(bookData.get(0), HttpStatus.OK);
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
