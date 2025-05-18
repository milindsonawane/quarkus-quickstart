package org.acme.controller;

import java.util.Objects;

import org.acme.BaseEntity;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public interface UpdateEntity<T extends BaseEntity> extends Serviced<T> {

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public default Response update(@Valid T t, @PathParam("id") Long id) {
		if (Objects.isNull(t.getId()))
			t.setId(id);
		return getService().update(t).map(e -> Response.ok().entity(e).build())
				.orElseGet(() -> Response.status(Status.NOT_FOUND).build());
	}
}
