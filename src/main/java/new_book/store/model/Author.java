package new_book.store.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
    private int authorId;
    private String authorName;

    public Author() {
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    @Id
    @Column(name = "author_id", nullable = false)
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "author_name", nullable = false, length = 100)
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (authorId != author.authorId) return false;
        if (authorName != null ? !authorName.equals(author.authorName) : author.authorName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorId;
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        return result;
    }

}
