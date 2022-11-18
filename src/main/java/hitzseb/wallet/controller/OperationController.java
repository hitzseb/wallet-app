package hitzseb.wallet.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hitzseb.wallet.model.Category;
import hitzseb.wallet.model.Operation;
import hitzseb.wallet.model.OperationType;
import hitzseb.wallet.service.AppUserService;
import hitzseb.wallet.service.OperationService;
import hitzseb.wallet.util.OperationsFilter;
import hitzseb.wallet.util.OperationsSorter;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class OperationController {
	private final OperationService operationService;
	private final AppUserService userService;

	@PostMapping("/api/v1/new-operation")
    public void newOperation(@RequestBody Operation operation) {
        operationService.saveOperation(operation);
    }
	
	@GetMapping("/api/v1/operations")
	@ResponseBody
	public List<Operation> getOperationsSinceDate(
			@RequestParam(required=false) Category category, 
			@RequestParam(required=false) OperationType type,
			@RequestParam(required=false) LocalDate date, 
			@RequestParam(required=false) Order order) {
		List<Operation> operations = 
				operationService.findOperationsByUser(
				userService.getCurrentUser());
		OperationsSorter.sortOperations(
		OperationsFilter.filterByCategory(
		OperationsFilter.filterByType(
		OperationsFilter.filterSinceDate(
		operations, date), type), category), order);
		return null;
	}
	
	@PutMapping("/api/v1/edit-operation/{id}")
    public void editOperation(@PathVariable Long id,
    		@RequestParam String description,
    		@RequestParam double amount,
    		@RequestParam OperationType type,
    		@RequestParam Category category,
    		@RequestParam LocalDate date) {
		if(id == userService.getCurrentUser().getId()) {
			Operation operation = operationService.findOperationById(id);
	        operation.setDescription(description);
	        operation.setAmount(amount);
	        operation.setType(type);
	        operation.setCategory(category);
	        operation.setDate(date);
	        operationService.saveOperation(operation);
		}
    }

    @DeleteMapping("/api/v1/delete-operation/{id}")
    public void deleteOperation(@PathVariable Long id) {
    	if(id == userService.getCurrentUser().getId()) {
    		operationService.deleteOperationById(id);
    	}
    }
}
