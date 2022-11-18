package hitzseb.wallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hitzseb.wallet.model.AppUser;
import hitzseb.wallet.model.Category;
import hitzseb.wallet.repository.CategoryRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public List<Category> findCategoriesByUser(AppUser user) {
		return categoryRepository.findAll();
	}
	
	public Category findCategoryById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
	}
}
