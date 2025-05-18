package org.acme.controller;

import org.acme.BaseEntity;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public interface DeleteEntity<T extends BaseEntity> extends Serviced<T> {

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public default Response delete(@PathParam("id") Long id) {
		getService().kill(id);
		return Response.accepted().build();
	}
}
