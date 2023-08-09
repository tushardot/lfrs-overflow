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

package panasonic.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import panasonic.service.model.channel;

/**
 * The persistence utility for the channel service. This utility wraps <code>panasonic.service.service.persistence.impl.channelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see channelPersistence
 * @generated
 */
public class channelUtil {

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
	public static void clearCache(channel channel) {
		getPersistence().clearCache(channel);
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
	public static Map<Serializable, channel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<channel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<channel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<channel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<channel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static channel update(channel channel) {
		return getPersistence().update(channel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static channel update(
		channel channel, ServiceContext serviceContext) {

		return getPersistence().update(channel, serviceContext);
	}

	/**
	 * Returns all the channels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching channels
	 */
	public static List<channel> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the channels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>channelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of channels
	 * @param end the upper bound of the range of channels (not inclusive)
	 * @return the range of matching channels
	 */
	public static List<channel> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the channels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>channelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of channels
	 * @param end the upper bound of the range of channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channels
	 */
	public static List<channel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<channel> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the channels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>channelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of channels
	 * @param end the upper bound of the range of channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching channels
	 */
	public static List<channel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<channel> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	public static channel findByUuid_First(
			String uuid, OrderByComparator<channel> orderByComparator)
		throws panasonic.service.exception.NoSuchchannelException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public static channel fetchByUuid_First(
		String uuid, OrderByComparator<channel> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	public static channel findByUuid_Last(
			String uuid, OrderByComparator<channel> orderByComparator)
		throws panasonic.service.exception.NoSuchchannelException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public static channel fetchByUuid_Last(
		String uuid, OrderByComparator<channel> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the channels before and after the current channel in the ordered set where uuid = &#63;.
	 *
	 * @param userName the primary key of the current channel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel
	 * @throws NoSuchchannelException if a channel with the primary key could not be found
	 */
	public static channel[] findByUuid_PrevAndNext(
			String userName, String uuid,
			OrderByComparator<channel> orderByComparator)
		throws panasonic.service.exception.NoSuchchannelException {

		return getPersistence().findByUuid_PrevAndNext(
			userName, uuid, orderByComparator);
	}

	/**
	 * Removes all the channels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of channels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching channels
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the channels where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching channels
	 */
	public static List<channel> findByuserName(String userName) {
		return getPersistence().findByuserName(userName);
	}

	/**
	 * Returns a range of all the channels where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>channelModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of channels
	 * @param end the upper bound of the range of channels (not inclusive)
	 * @return the range of matching channels
	 */
	public static List<channel> findByuserName(
		String userName, int start, int end) {

		return getPersistence().findByuserName(userName, start, end);
	}

	/**
	 * Returns an ordered range of all the channels where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>channelModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of channels
	 * @param end the upper bound of the range of channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching channels
	 */
	public static List<channel> findByuserName(
		String userName, int start, int end,
		OrderByComparator<channel> orderByComparator) {

		return getPersistence().findByuserName(
			userName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the channels where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>channelModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of channels
	 * @param end the upper bound of the range of channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching channels
	 */
	public static List<channel> findByuserName(
		String userName, int start, int end,
		OrderByComparator<channel> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserName(
			userName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	public static channel findByuserName_First(
			String userName, OrderByComparator<channel> orderByComparator)
		throws panasonic.service.exception.NoSuchchannelException {

		return getPersistence().findByuserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the first channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public static channel fetchByuserName_First(
		String userName, OrderByComparator<channel> orderByComparator) {

		return getPersistence().fetchByuserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the last channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	public static channel findByuserName_Last(
			String userName, OrderByComparator<channel> orderByComparator)
		throws panasonic.service.exception.NoSuchchannelException {

		return getPersistence().findByuserName_Last(
			userName, orderByComparator);
	}

	/**
	 * Returns the last channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public static channel fetchByuserName_Last(
		String userName, OrderByComparator<channel> orderByComparator) {

		return getPersistence().fetchByuserName_Last(
			userName, orderByComparator);
	}

	/**
	 * Removes all the channels where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public static void removeByuserName(String userName) {
		getPersistence().removeByuserName(userName);
	}

	/**
	 * Returns the number of channels where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching channels
	 */
	public static int countByuserName(String userName) {
		return getPersistence().countByuserName(userName);
	}

	/**
	 * Returns the channel where email = &#63; or throws a <code>NoSuchchannelException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	public static channel findByemail(String email)
		throws panasonic.service.exception.NoSuchchannelException {

		return getPersistence().findByemail(email);
	}

	/**
	 * Returns the channel where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public static channel fetchByemail(String email) {
		return getPersistence().fetchByemail(email);
	}

	/**
	 * Returns the channel where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public static channel fetchByemail(String email, boolean useFinderCache) {
		return getPersistence().fetchByemail(email, useFinderCache);
	}

	/**
	 * Removes the channel where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the channel that was removed
	 */
	public static channel removeByemail(String email)
		throws panasonic.service.exception.NoSuchchannelException {

		return getPersistence().removeByemail(email);
	}

	/**
	 * Returns the number of channels where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching channels
	 */
	public static int countByemail(String email) {
		return getPersistence().countByemail(email);
	}

	/**
	 * Caches the channel in the entity cache if it is enabled.
	 *
	 * @param channel the channel
	 */
	public static void cacheResult(channel channel) {
		getPersistence().cacheResult(channel);
	}

	/**
	 * Caches the channels in the entity cache if it is enabled.
	 *
	 * @param channels the channels
	 */
	public static void cacheResult(List<channel> channels) {
		getPersistence().cacheResult(channels);
	}

	/**
	 * Creates a new channel with the primary key. Does not add the channel to the database.
	 *
	 * @param userName the primary key for the new channel
	 * @return the new channel
	 */
	public static channel create(String userName) {
		return getPersistence().create(userName);
	}

	/**
	 * Removes the channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userName the primary key of the channel
	 * @return the channel that was removed
	 * @throws NoSuchchannelException if a channel with the primary key could not be found
	 */
	public static channel remove(String userName)
		throws panasonic.service.exception.NoSuchchannelException {

		return getPersistence().remove(userName);
	}

	public static channel updateImpl(channel channel) {
		return getPersistence().updateImpl(channel);
	}

	/**
	 * Returns the channel with the primary key or throws a <code>NoSuchchannelException</code> if it could not be found.
	 *
	 * @param userName the primary key of the channel
	 * @return the channel
	 * @throws NoSuchchannelException if a channel with the primary key could not be found
	 */
	public static channel findByPrimaryKey(String userName)
		throws panasonic.service.exception.NoSuchchannelException {

		return getPersistence().findByPrimaryKey(userName);
	}

	/**
	 * Returns the channel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userName the primary key of the channel
	 * @return the channel, or <code>null</code> if a channel with the primary key could not be found
	 */
	public static channel fetchByPrimaryKey(String userName) {
		return getPersistence().fetchByPrimaryKey(userName);
	}

	/**
	 * Returns all the channels.
	 *
	 * @return the channels
	 */
	public static List<channel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>channelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channels
	 * @param end the upper bound of the range of channels (not inclusive)
	 * @return the range of channels
	 */
	public static List<channel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>channelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channels
	 * @param end the upper bound of the range of channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of channels
	 */
	public static List<channel> findAll(
		int start, int end, OrderByComparator<channel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>channelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of channels
	 * @param end the upper bound of the range of channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of channels
	 */
	public static List<channel> findAll(
		int start, int end, OrderByComparator<channel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the channels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of channels.
	 *
	 * @return the number of channels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static channelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile channelPersistence _persistence;

}