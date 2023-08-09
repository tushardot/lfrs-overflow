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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import panasonic.service.exception.NoSuchchannelException;
import panasonic.service.model.channel;

/**
 * The persistence interface for the channel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see channelUtil
 * @generated
 */
@ProviderType
public interface channelPersistence extends BasePersistence<channel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link channelUtil} to access the channel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the channels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching channels
	 */
	public java.util.List<channel> findByUuid(String uuid);

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
	public java.util.List<channel> findByUuid(String uuid, int start, int end);

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
	public java.util.List<channel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<channel>
			orderByComparator);

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
	public java.util.List<channel> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<channel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	public channel findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<channel>
				orderByComparator)
		throws NoSuchchannelException;

	/**
	 * Returns the first channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public channel fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<channel>
			orderByComparator);

	/**
	 * Returns the last channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	public channel findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<channel>
				orderByComparator)
		throws NoSuchchannelException;

	/**
	 * Returns the last channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public channel fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<channel>
			orderByComparator);

	/**
	 * Returns the channels before and after the current channel in the ordered set where uuid = &#63;.
	 *
	 * @param userName the primary key of the current channel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next channel
	 * @throws NoSuchchannelException if a channel with the primary key could not be found
	 */
	public channel[] findByUuid_PrevAndNext(
			String userName, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<channel>
				orderByComparator)
		throws NoSuchchannelException;

	/**
	 * Removes all the channels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of channels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching channels
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the channels where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching channels
	 */
	public java.util.List<channel> findByuserName(String userName);

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
	public java.util.List<channel> findByuserName(
		String userName, int start, int end);

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
	public java.util.List<channel> findByuserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<channel>
			orderByComparator);

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
	public java.util.List<channel> findByuserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<channel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	public channel findByuserName_First(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<channel>
				orderByComparator)
		throws NoSuchchannelException;

	/**
	 * Returns the first channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public channel fetchByuserName_First(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<channel>
			orderByComparator);

	/**
	 * Returns the last channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	public channel findByuserName_Last(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<channel>
				orderByComparator)
		throws NoSuchchannelException;

	/**
	 * Returns the last channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public channel fetchByuserName_Last(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<channel>
			orderByComparator);

	/**
	 * Removes all the channels where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public void removeByuserName(String userName);

	/**
	 * Returns the number of channels where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching channels
	 */
	public int countByuserName(String userName);

	/**
	 * Returns the channel where email = &#63; or throws a <code>NoSuchchannelException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	public channel findByemail(String email) throws NoSuchchannelException;

	/**
	 * Returns the channel where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public channel fetchByemail(String email);

	/**
	 * Returns the channel where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching channel, or <code>null</code> if a matching channel could not be found
	 */
	public channel fetchByemail(String email, boolean useFinderCache);

	/**
	 * Removes the channel where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the channel that was removed
	 */
	public channel removeByemail(String email) throws NoSuchchannelException;

	/**
	 * Returns the number of channels where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching channels
	 */
	public int countByemail(String email);

	/**
	 * Caches the channel in the entity cache if it is enabled.
	 *
	 * @param channel the channel
	 */
	public void cacheResult(channel channel);

	/**
	 * Caches the channels in the entity cache if it is enabled.
	 *
	 * @param channels the channels
	 */
	public void cacheResult(java.util.List<channel> channels);

	/**
	 * Creates a new channel with the primary key. Does not add the channel to the database.
	 *
	 * @param userName the primary key for the new channel
	 * @return the new channel
	 */
	public channel create(String userName);

	/**
	 * Removes the channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userName the primary key of the channel
	 * @return the channel that was removed
	 * @throws NoSuchchannelException if a channel with the primary key could not be found
	 */
	public channel remove(String userName) throws NoSuchchannelException;

	public channel updateImpl(channel channel);

	/**
	 * Returns the channel with the primary key or throws a <code>NoSuchchannelException</code> if it could not be found.
	 *
	 * @param userName the primary key of the channel
	 * @return the channel
	 * @throws NoSuchchannelException if a channel with the primary key could not be found
	 */
	public channel findByPrimaryKey(String userName)
		throws NoSuchchannelException;

	/**
	 * Returns the channel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userName the primary key of the channel
	 * @return the channel, or <code>null</code> if a channel with the primary key could not be found
	 */
	public channel fetchByPrimaryKey(String userName);

	/**
	 * Returns all the channels.
	 *
	 * @return the channels
	 */
	public java.util.List<channel> findAll();

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
	public java.util.List<channel> findAll(int start, int end);

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
	public java.util.List<channel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<channel>
			orderByComparator);

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
	public java.util.List<channel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<channel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the channels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of channels.
	 *
	 * @return the number of channels
	 */
	public int countAll();

}