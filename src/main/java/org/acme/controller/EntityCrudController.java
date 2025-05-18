package org.acme.controller;

import org.acme.BaseEntity;

public interface EntityCrudController<T extends BaseEntity> extends
	CreateEntity<T>, UpdateEntity<T>, GetEntity<T>, DeleteEntity<T> { }
