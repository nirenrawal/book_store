package new_book.store;


import new_book.store.model.Author;
import new_book.store.model.Book;
import new_book.store.model.Category;
import new_book.store.repository.AuthorRepository;
import new_book.store.repository.BookRepository;
import new_book.store.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IntegrationTest{

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void init(){
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        categoryRepository.deleteAll();

    }

    @Test
    void empty_repository_dont_find_anything(){
        Iterable<Book> books = bookRepository.findAll();
        assertThat(books).isEmpty();
        Iterable<Author> authors = authorRepository.findAll();
        assertThat(authors).isEmpty();
        Iterable<Category> categories = categoryRepository.findAll();
        assertThat(categories).isEmpty();
    }

    @Test
    void store_books_authors_categories(){
//        Book book = bookRepository.save(new Book("amazon", "1999", 200, "I love you", Author, Category))
////        assertThat(books).hasFieldOrPropertyWithValue("title", "amazon");
////        assertThat(books).hasFieldOrPropertyWithValue("edition", "1999");
////        assertThat(books).hasFieldOrPropertyWithValue("price", 200);
////        assertThat(books).hasFieldOrPropertyWithValue("description", "I love you");

//        Author author = authorRepository.save(new Author("nirendra"));
//        assertThat(author).hasFieldOrPropertyWithValue("authorName", "nirendra");
//
//        Category category = categoryRepository.save(new Category("science"));
//        assertThat(category).hasFieldOrPropertyWithValue("categoryName", "science");

    }
}