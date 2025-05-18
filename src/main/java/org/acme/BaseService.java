package org.acme;

import java.util.Optional;

import jakarta.transaction.Transactional;

/**
 * Provides basic FUCK (Find, Update, Create, Kill) operations for entity.
 */
public abstract class BaseService<T extends BaseEntity> {
	protected abstract BaseRepository<T> getRepository();
	
	protected void beforeFind(long id) { }
	protected void afterFind(Optional<T> t) { }
	public Optional<T> find(long id) {
		beforeFind(id);
		Optional<T> entityFound = getRepository().findByIdOptional(id);
		afterFind(entityFound);
		return entityFound;
	}
	
	@Transactional
	public Optional<T> update(T entity) {
		beforeUpdate();
		getRepository().persist(entity);
		afterUpdate();
		return Optional.ofNullable(entity);
	}
	protected void beforeUpdate() { }
	protected void afterUpdate() { }
	
	@Transactional
	public T create(T entity) {
		beforeCreate(entity);
		getRepository().persist(entity);
		afterCreate(entity);
		return entity;
	}
	protected void beforeCreate(T entity) { }
	protected void afterCreate(T entity) { }

	@Transactional
	public void kill(long id) {
		beforeKill(id);
		getRepository().deleteById(id);
		afterKill(id);
	}
	protected void beforeKill(long id) { }
	protected void afterKill(long id) { }
}
