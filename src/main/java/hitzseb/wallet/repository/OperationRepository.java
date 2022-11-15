package hitzseb.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hitzseb.wallet.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

}
