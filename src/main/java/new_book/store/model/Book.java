package new_book.store.model;

import javax.persistence.*;

@Entity
public class Book {
    private int bookId;
    private String title;
    private String edition;
    private double price;
    private String imageUrl;
    private String description;
    private Author authorByAuthorId;
    private Category categoryByCategoryId;

    public Book() {
    }

    public Book(String title, String edition, double price, String description,
                Author authorByAuthorId, Category categoryByCategoryId) {
        this.title = title;
        this.edition = edition;
        this.price = price;
        this.description = description;
        this.authorByAuthorId = authorByAuthorId;
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @Id
    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "edition", nullable = false, length = 45)
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Lob
    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Lob
    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookId != book.bookId) return false;
        if (Double.compare(book.price, price) != 0) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (edition != null ? !edition.equals(book.edition) : book.edition != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (imageUrl != null ? !imageUrl.equals(book.imageUrl) : book.imageUrl != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result;
        long temp;
        result = bookId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (edition != null ? edition.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id", nullable = false)
    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }


}
