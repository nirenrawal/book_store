package new_book.store.repository;

import new_book.store.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findAuthorByAuthorId(Integer authorId);
}
