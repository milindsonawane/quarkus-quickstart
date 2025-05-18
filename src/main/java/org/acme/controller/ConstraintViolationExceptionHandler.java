package org.acme.controller;

import org.acme.ValidationErrorResponse;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		ValidationErrorResponse response = new ValidationErrorResponse(exception.getConstraintViolations());
		return Response.status(Status.BAD_REQUEST).entity(response).build();
	}
}
