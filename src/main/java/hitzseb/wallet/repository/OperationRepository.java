package hitzseb.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hitzseb.wallet.model.AppUser;
import hitzseb.wallet.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
	List<Operation> findOperationsByUser(AppUser user);
}