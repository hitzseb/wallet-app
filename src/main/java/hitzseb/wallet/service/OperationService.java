package hitzseb.wallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hitzseb.wallet.model.AppUser;
import hitzseb.wallet.model.Operation;
import hitzseb.wallet.repository.OperationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OperationService {
	private final OperationRepository operationRepository;

    public List<Operation> findOperationsByUser(AppUser user) {
        return operationRepository.findOperationsByUser(user);
    }
    
    public Operation findOperationById(Long id) {
    	return operationRepository.findById(id).orElse(null);
    }
    
    public void saveOperation(Operation operation) {
    	operationRepository.save(operation);
    }

    public void deleteOperationById(Long id) {
    	operationRepository.deleteById(id);
    }  
}
