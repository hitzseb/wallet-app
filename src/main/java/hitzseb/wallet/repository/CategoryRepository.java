package hitzseb.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hitzseb.wallet.model.AppUser;
import hitzseb.wallet.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	List<Category> findCategoriesByUser(AppUser user);
}