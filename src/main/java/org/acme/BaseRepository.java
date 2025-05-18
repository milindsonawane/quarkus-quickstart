package org.acme;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

public abstract class BaseRepository<T extends BaseEntity> implements PanacheRepository<T> {

	@Override
	public void persist(T entity) {
		PanacheRepository.super.persist(entity);
	}

	@Override
	public T findById(Long id) {
		return PanacheRepository.super.findById(id);
	}

	@Override
	public List<T> listAll() {
		return PanacheRepository.super.listAll();
	}
}
