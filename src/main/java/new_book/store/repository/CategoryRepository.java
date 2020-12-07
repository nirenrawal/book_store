package new_book.store.repository;

import new_book.store.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryByCategoryId(Integer categoryId);
}
