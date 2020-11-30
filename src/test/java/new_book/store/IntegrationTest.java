package new_book.store;

import new_book.store.model.Book;
import new_book.store.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IntegrationTest {

    @Autowired
    BookRepository repository;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    public void init(){
        repository.deleteAll();
    }

    @Test
    public void find_All_Books_Test(){
        Iterable<Book> books = repository.findAll();
        assertThat(books).isEmpty();
    }

    @Test
    public void find_BooK_By_Id(){
        Book book1 = new Book("title1", "edition1", 100);
        testEntityManager.persist(book1);
    }


}
