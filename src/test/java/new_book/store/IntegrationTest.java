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

//@DataJpaTest
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

    //Make methods which could be used in all other methods. book
//    void whatever(){
//
//    }


    //@Test
    void empty_repository_dont_find_anything(){
        Iterable<Book> books = bookRepository.findAll();
        assertThat(books).isEmpty();
        Iterable<Author> authors = authorRepository.findAll();
        assertThat(authors).isEmpty();
        Iterable<Category> categories = categoryRepository.findAll();
        assertThat(categories).isEmpty();
    }

    //@Test
    void store_books_authors_categories(){
        Author author = new Author("Thomas");
        Category category = new Category("Science");

        Author _author = authorRepository.save(author);
        Category _category = categoryRepository.save(category);

        Book _book = bookRepository.save(new Book("amazon", "1999", 200.00,
                "corona sucks", _author, _category));
        assertThat(_book).hasFieldOrPropertyWithValue("title", "amazon");
        assertThat(_book).hasFieldOrPropertyWithValue("edition", "1999");
        assertThat(_book).hasFieldOrPropertyWithValue("price", 200.00);
        assertThat(_book).hasFieldOrPropertyWithValue("description", "corona sucks");
        assertThat(_book).hasFieldOrPropertyWithValue("authorByAuthorId", _author);
        assertThat(_book).hasFieldOrPropertyWithValue("categoryByCategoryId", _category);

//        Author author = authorRepository.save(new Author("nirendra"));
//        assertThat(author).hasFieldOrPropertyWithValue("authorName", "nirendra");
//
//        Category category = categoryRepository.save(new Category("science"));
//        assertThat(category).hasFieldOrPropertyWithValue("categoryName", "science");

    }

        //@Test
        void should_find_all_content_from_all_the_classes(){

//            authorRepository.save(new Author("Nirendra"));
//            Iterable<Author> authors = authorRepository.findAll();
//            assertThat(authors).hasSize(1);
//
//
//            categoryRepository.save(new Category("Science"));
//            Iterable<Category> categories = categoryRepository.findAll();
//            assertThat(categories).hasSize(1);


//            bookRepository.save(new Book("Mula", "1999", 200.00, "I love you"));
//            Iterable<Book> books = bookRepository.findAll();
//            assertThat(books).hasSize(4);

    }
}
