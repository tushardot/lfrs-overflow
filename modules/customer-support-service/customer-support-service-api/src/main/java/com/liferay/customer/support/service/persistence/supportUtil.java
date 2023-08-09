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

package com.liferay.customer.support.service.persistence;

import com.liferay.customer.support.model.support;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the support service. This utility wraps <code>com.liferay.customer.support.service.persistence.impl.supportPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see supportPersistence
 * @generated
 */
public class supportUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(support support) {
		getPersistence().clearCache(support);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, support> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<support> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<support> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<support> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<support> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static support update(support support) {
		return getPersistence().update(support);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static support update(
		support support, ServiceContext serviceContext) {

		return getPersistence().update(support, serviceContext);
	}

	/**
	 * Caches the support in the entity cache if it is enabled.
	 *
	 * @param support the support
	 */
	public static void cacheResult(support support) {
		getPersistence().cacheResult(support);
	}

	/**
	 * Caches the supports in the entity cache if it is enabled.
	 *
	 * @param supports the supports
	 */
	public static void cacheResult(List<support> supports) {
		getPersistence().cacheResult(supports);
	}

	/**
	 * Creates a new support with the primary key. Does not add the support to the database.
	 *
	 * @param spportId the primary key for the new support
	 * @return the new support
	 */
	public static support create(long spportId) {
		return getPersistence().create(spportId);
	}

	/**
	 * Removes the support with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spportId the primary key of the support
	 * @return the support that was removed
	 * @throws NoSuchsupportException if a support with the primary key could not be found
	 */
	public static support remove(long spportId)
		throws com.liferay.customer.support.exception.NoSuchsupportException {

		return getPersistence().remove(spportId);
	}

	public static support updateImpl(support support) {
		return getPersistence().updateImpl(support);
	}

	/**
	 * Returns the support with the primary key or throws a <code>NoSuchsupportException</code> if it could not be found.
	 *
	 * @param spportId the primary key of the support
	 * @return the support
	 * @throws NoSuchsupportException if a support with the primary key could not be found
	 */
	public static support findByPrimaryKey(long spportId)
		throws com.liferay.customer.support.exception.NoSuchsupportException {

		return getPersistence().findByPrimaryKey(spportId);
	}

	/**
	 * Returns the support with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spportId the primary key of the support
	 * @return the support, or <code>null</code> if a support with the primary key could not be found
	 */
	public static support fetchByPrimaryKey(long spportId) {
		return getPersistence().fetchByPrimaryKey(spportId);
	}

	/**
	 * Returns all the supports.
	 *
	 * @return the supports
	 */
	public static List<support> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the supports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>supportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of supports
	 * @param end the upper bound of the range of supports (not inclusive)
	 * @return the range of supports
	 */
	public static List<support> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the supports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>supportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of supports
	 * @param end the upper bound of the range of supports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of supports
	 */
	public static List<support> findAll(
		int start, int end, OrderByComparator<support> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the supports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>supportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of supports
	 * @param end the upper bound of the range of supports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of supports
	 */
	public static List<support> findAll(
		int start, int end, OrderByComparator<support> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the supports from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of supports.
	 *
	 * @return the number of supports
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static supportPersistence getPersistence() {
		return _persistence;
	}

	private static volatile supportPersistence _persistence;

}