package hitzseb.wallet.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import hitzseb.wallet.controller.Order;
import hitzseb.wallet.model.Operation;

public class OperationsSorter {
	
	public List<Operation> sortOperations(List<Operation> operations, Order order) {
		switch(order) {
			case MOST_RECENT:
				return orderFromMostRecent(operations);
			case LEAST_RECENT:
				return orderFromLeastRecent(operations);
			case HIGHEST_AMOUNT:
				return orderFromHighestAmount(operations);
			case LOWEST_AMOUNT:
				return orderFromLeastRecent(operations);
			case A_Z:
				return orderFromAtoZ(operations);
			case Z_A:
				return orderFromZtoA(operations);
			default:
				return operations;
		}
	}
	
	public List<Operation> orderFromMostRecent(List<Operation> operations) {
		List<Operation> sortedOperations = operations
				.stream()
				.sorted(Comparator
				.comparing(Operation::getDate))
				.collect(Collectors.toList());
		return sortedOperations;
	}
	
	public List<Operation> orderFromLeastRecent(List<Operation> operations) {
		List<Operation> sortedOperations = operations
				.stream()
				.sorted(Comparator
				.comparing(Operation::getDate).reversed())
				.collect(Collectors.toList());
		return sortedOperations;
	}
	
	public List<Operation> orderFromHighestAmount(List<Operation> operations) {
		List<Operation> sortedOperations = operations
				.stream()
				.sorted(Comparator
				.comparing(Operation::getAmount))
				.collect(Collectors.toList());
		return sortedOperations;
	}
	
	public List<Operation> orderFromLowestAmount(List<Operation> operations) {
		List<Operation> sortedOperations = operations
				.stream()
				.sorted(Comparator
				.comparing(Operation::getAmount).reversed())
				.collect(Collectors.toList());
		return sortedOperations;
	}
	
	public List<Operation> orderFromAtoZ(List<Operation> operations) {
		List<Operation> sortedOperations = operations
				.stream()
				.sorted(Comparator
				.comparing(Operation::getDescription))
				.collect(Collectors.toList());
		return sortedOperations;
	}
	
	public List<Operation> orderFromZtoA(List<Operation> operations) {
		List<Operation> sortedOperations = operations
				.stream()
				.sorted(Comparator
				.comparing(Operation::getDescription).reversed())
				.collect(Collectors.toList());
		return sortedOperations;
	}

}
