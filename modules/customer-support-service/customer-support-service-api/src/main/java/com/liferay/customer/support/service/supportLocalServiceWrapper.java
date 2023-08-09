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

package com.liferay.customer.support.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link supportLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see supportLocalService
 * @generated
 */
public class supportLocalServiceWrapper
	implements ServiceWrapper<supportLocalService>, supportLocalService {

	public supportLocalServiceWrapper(supportLocalService supportLocalService) {
		_supportLocalService = supportLocalService;
	}

	/**
	 * Adds the support to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect supportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param support the support
	 * @return the support that was added
	 */
	@Override
	public com.liferay.customer.support.model.support addsupport(
		com.liferay.customer.support.model.support support) {

		return _supportLocalService.addsupport(support);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new support with the primary key. Does not add the support to the database.
	 *
	 * @param spportId the primary key for the new support
	 * @return the new support
	 */
	@Override
	public com.liferay.customer.support.model.support createsupport(
		long spportId) {

		return _supportLocalService.createsupport(spportId);
	}

	@Override
	public com.liferay.customer.support.model.support createsupportinfo(
		String claim, String query, String suggestioncomplaint, String BU,
		String channel, long invoiceNumber, java.util.Date invoiceDate,
		long itemvalueinvoice, long itemvalueyou, long claimvalue,
		String detailclaim, String querybox, String scbox) {

		return _supportLocalService.createsupportinfo(
			claim, query, suggestioncomplaint, BU, channel, invoiceNumber,
			invoiceDate, itemvalueinvoice, itemvalueyou, claimvalue,
			detailclaim, querybox, scbox);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the support with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect supportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param spportId the primary key of the support
	 * @return the support that was removed
	 * @throws PortalException if a support with the primary key could not be found
	 */
	@Override
	public com.liferay.customer.support.model.support deletesupport(
			long spportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportLocalService.deletesupport(spportId);
	}

	/**
	 * Deletes the support from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect supportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param support the support
	 * @return the support that was removed
	 */
	@Override
	public com.liferay.customer.support.model.support deletesupport(
		com.liferay.customer.support.model.support support) {

		return _supportLocalService.deletesupport(support);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _supportLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _supportLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.customer.support.model.impl.supportModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _supportLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.customer.support.model.impl.supportModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _supportLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _supportLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _supportLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.customer.support.model.support fetchsupport(
		long spportId) {

		return _supportLocalService.fetchsupport(spportId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _supportLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _supportLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _supportLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the support with the primary key.
	 *
	 * @param spportId the primary key of the support
	 * @return the support
	 * @throws PortalException if a support with the primary key could not be found
	 */
	@Override
	public com.liferay.customer.support.model.support getsupport(long spportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportLocalService.getsupport(spportId);
	}

	/**
	 * Returns a range of all the supports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.customer.support.model.impl.supportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of supports
	 * @param end the upper bound of the range of supports (not inclusive)
	 * @return the range of supports
	 */
	@Override
	public java.util.List<com.liferay.customer.support.model.support>
		getsupports(int start, int end) {

		return _supportLocalService.getsupports(start, end);
	}

	/**
	 * Returns the number of supports.
	 *
	 * @return the number of supports
	 */
	@Override
	public int getsupportsCount() {
		return _supportLocalService.getsupportsCount();
	}

	/**
	 * Updates the support in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect supportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param support the support
	 * @return the support that was updated
	 */
	@Override
	public com.liferay.customer.support.model.support updatesupport(
		com.liferay.customer.support.model.support support) {

		return _supportLocalService.updatesupport(support);
	}

	@Override
	public supportLocalService getWrappedService() {
		return _supportLocalService;
	}

	@Override
	public void setWrappedService(supportLocalService supportLocalService) {
		_supportLocalService = supportLocalService;
	}

	private supportLocalService _supportLocalService;

}