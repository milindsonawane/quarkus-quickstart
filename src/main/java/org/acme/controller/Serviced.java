package org.acme.controller;

import org.acme.BaseEntity;
import org.acme.BaseService;

public interface Serviced<T extends BaseEntity> {

	public BaseService<T> getService();
}
