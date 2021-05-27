/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.todoservices.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Todo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Todo
 * @generated
 */
public class TodoWrapper
	extends BaseModelWrapper<Todo> implements ModelWrapper<Todo>, Todo {

	public TodoWrapper(Todo todo) {
		super(todo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("done", isDone());
		attributes.put("dueDate", getDueDate());
		attributes.put("user", getUser());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean done = (Boolean)attributes.get("done");

		if (done != null) {
			setDone(done);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Long user = (Long)attributes.get("user");

		if (user != null) {
			setUser(user);
		}
	}

	/**
	 * Returns the done of this todo.
	 *
	 * @return the done of this todo
	 */
	@Override
	public boolean getDone() {
		return model.getDone();
	}

	/**
	 * Returns the due date of this todo.
	 *
	 * @return the due date of this todo
	 */
	@Override
	public Date getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the ID of this todo.
	 *
	 * @return the ID of this todo
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this todo.
	 *
	 * @return the name of this todo
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this todo.
	 *
	 * @return the primary key of this todo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user of this todo.
	 *
	 * @return the user of this todo
	 */
	@Override
	public long getUser() {
		return model.getUser();
	}

	/**
	 * Returns <code>true</code> if this todo is done.
	 *
	 * @return <code>true</code> if this todo is done; <code>false</code> otherwise
	 */
	@Override
	public boolean isDone() {
		return model.isDone();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this todo is done.
	 *
	 * @param done the done of this todo
	 */
	@Override
	public void setDone(boolean done) {
		model.setDone(done);
	}

	/**
	 * Sets the due date of this todo.
	 *
	 * @param dueDate the due date of this todo
	 */
	@Override
	public void setDueDate(Date dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the ID of this todo.
	 *
	 * @param id the ID of this todo
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this todo.
	 *
	 * @param name the name of this todo
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this todo.
	 *
	 * @param primaryKey the primary key of this todo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user of this todo.
	 *
	 * @param user the user of this todo
	 */
	@Override
	public void setUser(long user) {
		model.setUser(user);
	}

	@Override
	protected TodoWrapper wrap(Todo todo) {
		return new TodoWrapper(todo);
	}

}