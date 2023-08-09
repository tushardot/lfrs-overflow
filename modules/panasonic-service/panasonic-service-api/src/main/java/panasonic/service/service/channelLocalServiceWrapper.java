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

package panasonic.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link channelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see channelLocalService
 * @generated
 */
public class channelLocalServiceWrapper
	implements channelLocalService, ServiceWrapper<channelLocalService> {

	public channelLocalServiceWrapper(channelLocalService channelLocalService) {
		_channelLocalService = channelLocalService;
	}

	/**
	 * Adds the channel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect channelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param channel the channel
	 * @return the channel that was added
	 */
	@Override
	public panasonic.service.model.channel addchannel(
		panasonic.service.model.channel channel) {

		return _channelLocalService.addchannel(channel);
	}

	/**
	 * Creates a new channel with the primary key. Does not add the channel to the database.
	 *
	 * @param userName the primary key for the new channel
	 * @return the new channel
	 */
	@Override
	public panasonic.service.model.channel createchannel(String userName) {
		return _channelLocalService.createchannel(userName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _channelLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the channel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect channelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param channel the channel
	 * @return the channel that was removed
	 */
	@Override
	public panasonic.service.model.channel deletechannel(
		panasonic.service.model.channel channel) {

		return _channelLocalService.deletechannel(channel);
	}

	/**
	 * Deletes the channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect channelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userName the primary key of the channel
	 * @return the channel that was removed
	 * @throws PortalException if a channel with the primary key could not be found
	 */
	@Override
	public panasonic.service.model.channel deletechannel(String userName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _channelLocalService.deletechannel(userName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _channelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _channelLocalService.dynamicQuery();
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

		return _channelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>panasonic.service.model.impl.channelModelImpl</code>.
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

		return _channelLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>panasonic.service.model.impl.channelModelImpl</code>.
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

		return _channelLocalService.dynamicQuery(
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

		return _channelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _channelLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public panasonic.service.model.channel fetchchannel(String userName) {
		return _channelLocalService.fetchchannel(userName);
	}

	@Override
	public panasonic.service.model.channel getbyemail(String email)
		throws panasonic.service.exception.NoSuchchannelException {

		return _channelLocalService.getbyemail(email);
	}

	/**
	 * Returns the channel with the primary key.
	 *
	 * @param userName the primary key of the channel
	 * @return the channel
	 * @throws PortalException if a channel with the primary key could not be found
	 */
	@Override
	public panasonic.service.model.channel getchannel(String userName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _channelLocalService.getchannel(userName);
	}

	/**
	 * Returns a range of all the channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>panasonic.service.model.impl.channelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channels
	 * @param end the upper bound of the range of channels (not inclusive)
	 * @return the range of channels
	 */
	@Override
	public java.util.List<panasonic.service.model.channel> getchannels(
		int start, int end) {

		return _channelLocalService.getchannels(start, end);
	}

	/**
	 * Returns the number of channels.
	 *
	 * @return the number of channels
	 */
	@Override
	public int getchannelsCount() {
		return _channelLocalService.getchannelsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _channelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _channelLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public panasonic.service.model.channel getuserbyemail(String email) {
		return _channelLocalService.getuserbyemail(email);
	}

	/**
	 * Updates the channel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect channelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param channel the channel
	 * @return the channel that was updated
	 */
	@Override
	public panasonic.service.model.channel updatechannel(
		panasonic.service.model.channel channel) {

		return _channelLocalService.updatechannel(channel);
	}

	@Override
	public channelLocalService getWrappedService() {
		return _channelLocalService;
	}

	@Override
	public void setWrappedService(channelLocalService channelLocalService) {
		_channelLocalService = channelLocalService;
	}

	private channelLocalService _channelLocalService;

}