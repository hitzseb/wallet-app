package hitzseb.wallet.util;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import hitzseb.wallet.model.Category;
import hitzseb.wallet.model.Operation;
import hitzseb.wallet.model.OperationType;

public class OperationsFilter {
	
	public List<Operation> filterByType(List<Operation> operations, OperationType type) {
		List<Operation> operationsByType = operations
				.stream()
				.filter(o -> o.getType() == type)
				.collect(Collectors.toList());
		return operationsByType;
	}
	
	public List<Operation> filterByCategory(List<Operation> operations, Category category) {
		List<Operation> operationsByCategory = operations
				.stream()
				.filter(o -> o.getCategory() == category)
				.collect(Collectors.toList());
		return operationsByCategory;
	}
	
	public List<Operation> filterSinceDate(List<Operation> operations, LocalDate date) {
		List<Operation> operationsSinceDate = operations
				.stream()
				.filter(o -> o.getDate().isAfter(date) || o.getDate().isEqual(date))
				.collect(Collectors.toList());
		return operationsSinceDate;
	}
}
