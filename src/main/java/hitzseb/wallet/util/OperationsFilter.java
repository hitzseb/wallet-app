package hitzseb.wallet.util;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import hitzseb.wallet.model.Operation;
import hitzseb.wallet.model.Category;
import hitzseb.wallet.model.Type;

public class OperationsFilter {
	
	public static List<Operation> filterByType(List<Operation> operations, Type type) {
		if(type == Type.ALL) {
			return operations;
		}
		List<Operation> operationsByType = operations
				.stream()
				.filter(o -> o.getType() == type)
				.collect(Collectors.toList());
		return operationsByType;
	}
	
	public static List<Operation> filterByCategory(List<Operation> operations, Category category) {
		if(category == Category.ALL) {
			return operations;
		}
		List<Operation> operationsByCategory = operations
				.stream()
				.filter(o -> o.getCategory() == category)
				.collect(Collectors.toList());
		return operationsByCategory;
	}
	
	public static List<Operation> filterSinceDate(List<Operation> operations, LocalDate dateTime) {
		List<Operation> operationsSinceDate = operations
				.stream()
				.filter(o -> o.getDate().isAfter(dateTime) || o.getDate().isEqual(dateTime))
				.collect(Collectors.toList());
		return operationsSinceDate;
	}
}
