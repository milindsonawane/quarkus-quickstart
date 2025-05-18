package org.acme.example;

import org.acme.BaseService;
import org.acme.controller.EntityCrudController;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("laptop")
@ApplicationScoped
public class LaptopController implements EntityCrudController<Laptop> {

	@Inject
	LaptopService service;
	
	@Override
	public BaseService<Laptop> getService() {
		System.out.println("service sent back");
		return service;
	}

}
