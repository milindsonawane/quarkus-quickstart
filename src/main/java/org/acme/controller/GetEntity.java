package org.acme.controller;

import org.acme.BaseEntity;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public interface GetEntity<T extends BaseEntity> extends Serviced<T> {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public default Response get(@PathParam("id") Long id) {
		return getService().find(id).map(i -> Response.status(Status.OK).entity(i).build())
				.orElseGet(() -> Response.status(Status.NOT_FOUND).build());
	}
}
