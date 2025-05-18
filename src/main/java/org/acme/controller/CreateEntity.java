package org.acme.controller;

import org.acme.BaseEntity;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public interface CreateEntity<T extends BaseEntity> extends Serviced<T> {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public default Response create(@Valid T t) {
		return Response.status(Status.CREATED).entity(getService().create(t)).build();
	}
}
