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

package com.todoservices.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.todoservices.exception.NoSuchTodoException;
import com.todoservices.model.Todo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the todo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoUtil
 * @generated
 */
@ProviderType
public interface TodoPersistence extends BasePersistence<Todo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TodoUtil} to access the todo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the todos where user = &#63;.
	 *
	 * @param user the user
	 * @return the matching todos
	 */
	public java.util.List<Todo> findByuser(long user);

	/**
	 * Returns a range of all the todos where user = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param user the user
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of matching todos
	 */
	public java.util.List<Todo> findByuser(long user, int start, int end);

	/**
	 * Returns an ordered range of all the todos where user = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param user the user
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todos
	 */
	public java.util.List<Todo> findByuser(
		long user, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the todos where user = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param user the user
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todos
	 */
	public java.util.List<Todo> findByuser(
		long user, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo in the ordered set where user = &#63;.
	 *
	 * @param user the user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByuser_First(
			long user,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the first todo in the ordered set where user = &#63;.
	 *
	 * @param user the user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByuser_First(
		long user,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the last todo in the ordered set where user = &#63;.
	 *
	 * @param user the user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo
	 * @throws NoSuchTodoException if a matching todo could not be found
	 */
	public Todo findByuser_Last(
			long user,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Returns the last todo in the ordered set where user = &#63;.
	 *
	 * @param user the user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo, or <code>null</code> if a matching todo could not be found
	 */
	public Todo fetchByuser_Last(
		long user,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns the todos before and after the current todo in the ordered set where user = &#63;.
	 *
	 * @param id the primary key of the current todo
	 * @param user the user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo[] findByuser_PrevAndNext(
			long id, long user,
			com.liferay.portal.kernel.util.OrderByComparator<Todo>
				orderByComparator)
		throws NoSuchTodoException;

	/**
	 * Removes all the todos where user = &#63; from the database.
	 *
	 * @param user the user
	 */
	public void removeByuser(long user);

	/**
	 * Returns the number of todos where user = &#63;.
	 *
	 * @param user the user
	 * @return the number of matching todos
	 */
	public int countByuser(long user);

	/**
	 * Caches the todo in the entity cache if it is enabled.
	 *
	 * @param todo the todo
	 */
	public void cacheResult(Todo todo);

	/**
	 * Caches the todos in the entity cache if it is enabled.
	 *
	 * @param todos the todos
	 */
	public void cacheResult(java.util.List<Todo> todos);

	/**
	 * Creates a new todo with the primary key. Does not add the todo to the database.
	 *
	 * @param id the primary key for the new todo
	 * @return the new todo
	 */
	public Todo create(long id);

	/**
	 * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the todo
	 * @return the todo that was removed
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo remove(long id) throws NoSuchTodoException;

	public Todo updateImpl(Todo todo);

	/**
	 * Returns the todo with the primary key or throws a <code>NoSuchTodoException</code> if it could not be found.
	 *
	 * @param id the primary key of the todo
	 * @return the todo
	 * @throws NoSuchTodoException if a todo with the primary key could not be found
	 */
	public Todo findByPrimaryKey(long id) throws NoSuchTodoException;

	/**
	 * Returns the todo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the todo
	 * @return the todo, or <code>null</code> if a todo with the primary key could not be found
	 */
	public Todo fetchByPrimaryKey(long id);

	/**
	 * Returns all the todos.
	 *
	 * @return the todos
	 */
	public java.util.List<Todo> findAll();

	/**
	 * Returns a range of all the todos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @return the range of todos
	 */
	public java.util.List<Todo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the todos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of todos
	 */
	public java.util.List<Todo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the todos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todos
	 * @param end the upper bound of the range of todos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of todos
	 */
	public java.util.List<Todo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Todo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the todos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of todos.
	 *
	 * @return the number of todos
	 */
	public int countAll();

}