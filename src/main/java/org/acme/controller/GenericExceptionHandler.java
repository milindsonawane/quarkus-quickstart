package org.acme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExceptionHandler implements ExceptionMapper<Exception> {
	
	private static final Logger log = LoggerFactory.getLogger(GenericExceptionHandler.class);

	@Override
	public Response toResponse(Exception exception) {
		record ErrorResponse(String message) {
			static ErrorResponse getErrorResponse() {
				return new ErrorResponse("Something went wrong, please try again in sometime.");
			}
		}
		log.error("Something went wrong: ", exception);
		return Response.status(Status.BAD_REQUEST).entity(ErrorResponse.getErrorResponse()).build();
	}
}
