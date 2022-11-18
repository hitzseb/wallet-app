package hitzseb.wallet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hitzseb.wallet.model.Category;
import hitzseb.wallet.service.AppUserService;
import hitzseb.wallet.service.CategoryService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;
	private final AppUserService userService;
	
	@PostMapping("/api/v1/new-category")
	public void newCategory(@RequestBody Category category) {
		categoryService.saveCategory(category);
	}
	
	@GetMapping("/api/v1/categories")
	public List<Category> getCurrentUserCategories() {
		return categoryService.findCategoriesByUser(userService.getCurrentUser());
	}
	
	@DeleteMapping("/api/v1/delete-category/{id}")
	public void deleteCategoryById(@PathVariable Long id) {
		if(id == userService.getCurrentUser().getId()) {
			categoryService.deleteCategoryById(id);
		}
	}
}
