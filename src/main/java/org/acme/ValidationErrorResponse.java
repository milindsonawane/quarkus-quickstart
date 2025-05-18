package org.acme;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;

public record ValidationErrorResponse(Map<String, List<String>> violations) {
	public ValidationErrorResponse(Collection<ConstraintViolation<?>> incomingViolations) {
		this(incomingViolations.stream()
		    .collect(Collectors.groupingBy(
		        vio -> vio.getPropertyPath().toString(),
		        Collectors.mapping(vio -> vio.getMessage(), Collectors.toList())
		    )));
	}
}
