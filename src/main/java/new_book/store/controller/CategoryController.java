package new_book.store.controller;

import new_book.store.model.Category;
import new_book.store.repository.CategoryRepository;
import new_book.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findAllCategory(){
        return categoryService.getAll();
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return categoryService.createNewCategory(category);
    }

    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<HttpStatus> deleteCategoryById(@PathVariable("categoryId") int categoryId){
        return categoryService.deleteCategory(categoryId);
    }
}
