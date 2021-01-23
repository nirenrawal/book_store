package new_book.store.repository;

import new_book.store.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    //List<Book> findByTitleContaining(String title);
}
