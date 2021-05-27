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

package com.todoservices.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.todoservices.model.Todo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Todo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TodoCacheModel implements CacheModel<Todo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TodoCacheModel)) {
			return false;
		}

		TodoCacheModel todoCacheModel = (TodoCacheModel)object;

		if (id == todoCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", done=");
		sb.append(done);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append(", user=");
		sb.append(user);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Todo toEntityModel() {
		TodoImpl todoImpl = new TodoImpl();

		todoImpl.setId(id);

		if (name == null) {
			todoImpl.setName("");
		}
		else {
			todoImpl.setName(name);
		}

		todoImpl.setDone(done);

		if (dueDate == Long.MIN_VALUE) {
			todoImpl.setDueDate(null);
		}
		else {
			todoImpl.setDueDate(new Date(dueDate));
		}

		todoImpl.setUser(user);

		todoImpl.resetOriginalValues();

		return todoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		name = objectInput.readUTF();

		done = objectInput.readBoolean();
		dueDate = objectInput.readLong();

		user = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(done);
		objectOutput.writeLong(dueDate);

		objectOutput.writeLong(user);
	}

	public long id;
	public String name;
	public boolean done;
	public long dueDate;
	public long user;

}