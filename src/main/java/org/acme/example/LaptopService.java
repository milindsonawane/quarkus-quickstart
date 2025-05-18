package org.acme.example;

import org.acme.BaseRepository;
import org.acme.BaseService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LaptopService extends BaseService<Laptop> {

	@Inject
	LaptopRepository repo;
	
	@Override
	public BaseRepository<Laptop> getRepository() {
		return repo;
	}
}
