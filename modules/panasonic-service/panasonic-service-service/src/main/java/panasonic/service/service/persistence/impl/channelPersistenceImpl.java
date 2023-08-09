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

package panasonic.service.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import panasonic.service.exception.NoSuchchannelException;
import panasonic.service.model.channel;
import panasonic.service.model.impl.channelImpl;
import panasonic.service.model.impl.channelModelImpl;
import panasonic.service.service.persistence.channelPersistence;
import panasonic.service.service.persistence.channelUtil;
import panasonic.service.service.persistence.impl.constants.LiferayPersistenceConstants;

/**
 * The persistence implementation for the channel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = channelPersistence.class)
public class channelPersistenceImpl
	extends BasePersistenceImpl<channel> implements channelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>channelUtil</code> to access the channel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		channelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the channels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching channels
	 */
	@Override
	public List<channel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<channel> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<channel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<channel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<channel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<channel> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<channel> list = null;

		if (useFinderCache) {
			list = (List<channel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (channel channel : list) {
					if (!uuid.equals(channel.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CHANNEL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(channelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<channel>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	@Override
	public channel findByUuid_First(
			String uuid, OrderByComparator<channel> orderByComparator)
		throws NoSuchchannelException {

		channel channel = fetchByUuid_First(uuid, orderByComparator);

		if (channel != null) {
			return channel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchchannelException(sb.toString());
	}

	/**
	 * Returns the first channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel, or <code>null</code> if a matching channel could not be found
	 */
	@Override
	public channel fetchByUuid_First(
		String uuid, OrderByComparator<channel> orderByComparator) {

		List<channel> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	@Override
	public channel findByUuid_Last(
			String uuid, OrderByComparator<channel> orderByComparator)
		throws NoSuchchannelException {

		channel channel = fetchByUuid_Last(uuid, orderByComparator);

		if (channel != null) {
			return channel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchchannelException(sb.toString());
	}

	/**
	 * Returns the last channel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel, or <code>null</code> if a matching channel could not be found
	 */
	@Override
	public channel fetchByUuid_Last(
		String uuid, OrderByComparator<channel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<channel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public channel[] findByUuid_PrevAndNext(
			String userName, String uuid,
			OrderByComparator<channel> orderByComparator)
		throws NoSuchchannelException {

		uuid = Objects.toString(uuid, "");

		channel channel = findByPrimaryKey(userName);

		Session session = null;

		try {
			session = openSession();

			channel[] array = new channelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, channel, uuid, orderByComparator, true);

			array[1] = channel;

			array[2] = getByUuid_PrevAndNext(
				session, channel, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected channel getByUuid_PrevAndNext(
		Session session, channel channel, String uuid,
		OrderByComparator<channel> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHANNEL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(channelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(channel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<channel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the channels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (channel channel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(channel);
		}
	}

	/**
	 * Returns the number of channels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching channels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHANNEL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "channel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(channel.uuid IS NULL OR channel.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByuserName;
	private FinderPath _finderPathWithoutPaginationFindByuserName;
	private FinderPath _finderPathCountByuserName;

	/**
	 * Returns all the channels where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching channels
	 */
	@Override
	public List<channel> findByuserName(String userName) {
		return findByuserName(
			userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<channel> findByuserName(String userName, int start, int end) {
		return findByuserName(userName, start, end, null);
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
	@Override
	public List<channel> findByuserName(
		String userName, int start, int end,
		OrderByComparator<channel> orderByComparator) {

		return findByuserName(userName, start, end, orderByComparator, true);
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
	@Override
	public List<channel> findByuserName(
		String userName, int start, int end,
		OrderByComparator<channel> orderByComparator, boolean useFinderCache) {

		userName = Objects.toString(userName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserName;
				finderArgs = new Object[] {userName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserName;
			finderArgs = new Object[] {userName, start, end, orderByComparator};
		}

		List<channel> list = null;

		if (useFinderCache) {
			list = (List<channel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (channel channel : list) {
					if (!userName.equals(channel.getUserName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CHANNEL_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(channelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserName) {
					queryPos.add(userName);
				}

				list = (List<channel>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	@Override
	public channel findByuserName_First(
			String userName, OrderByComparator<channel> orderByComparator)
		throws NoSuchchannelException {

		channel channel = fetchByuserName_First(userName, orderByComparator);

		if (channel != null) {
			return channel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userName=");
		sb.append(userName);

		sb.append("}");

		throw new NoSuchchannelException(sb.toString());
	}

	/**
	 * Returns the first channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching channel, or <code>null</code> if a matching channel could not be found
	 */
	@Override
	public channel fetchByuserName_First(
		String userName, OrderByComparator<channel> orderByComparator) {

		List<channel> list = findByuserName(userName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	@Override
	public channel findByuserName_Last(
			String userName, OrderByComparator<channel> orderByComparator)
		throws NoSuchchannelException {

		channel channel = fetchByuserName_Last(userName, orderByComparator);

		if (channel != null) {
			return channel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userName=");
		sb.append(userName);

		sb.append("}");

		throw new NoSuchchannelException(sb.toString());
	}

	/**
	 * Returns the last channel in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching channel, or <code>null</code> if a matching channel could not be found
	 */
	@Override
	public channel fetchByuserName_Last(
		String userName, OrderByComparator<channel> orderByComparator) {

		int count = countByuserName(userName);

		if (count == 0) {
			return null;
		}

		List<channel> list = findByuserName(
			userName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the channels where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	@Override
	public void removeByuserName(String userName) {
		for (channel channel :
				findByuserName(
					userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(channel);
		}
	}

	/**
	 * Returns the number of channels where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching channels
	 */
	@Override
	public int countByuserName(String userName) {
		userName = Objects.toString(userName, "");

		FinderPath finderPath = _finderPathCountByuserName;

		Object[] finderArgs = new Object[] {userName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHANNEL_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				sb.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserName) {
					queryPos.add(userName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_2 =
		"channel.userName = ?";

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 =
		"(channel.userName IS NULL OR channel.userName = '')";

	private FinderPath _finderPathFetchByemail;
	private FinderPath _finderPathCountByemail;

	/**
	 * Returns the channel where email = &#63; or throws a <code>NoSuchchannelException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching channel
	 * @throws NoSuchchannelException if a matching channel could not be found
	 */
	@Override
	public channel findByemail(String email) throws NoSuchchannelException {
		channel channel = fetchByemail(email);

		if (channel == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("email=");
			sb.append(email);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchchannelException(sb.toString());
		}

		return channel;
	}

	/**
	 * Returns the channel where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching channel, or <code>null</code> if a matching channel could not be found
	 */
	@Override
	public channel fetchByemail(String email) {
		return fetchByemail(email, true);
	}

	/**
	 * Returns the channel where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching channel, or <code>null</code> if a matching channel could not be found
	 */
	@Override
	public channel fetchByemail(String email, boolean useFinderCache) {
		email = Objects.toString(email, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {email};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByemail, finderArgs, this);
		}

		if (result instanceof channel) {
			channel channel = (channel)result;

			if (!Objects.equals(email, channel.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CHANNEL_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				List<channel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByemail, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {email};
							}

							_log.warn(
								"channelPersistenceImpl.fetchByemail(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					channel channel = list.get(0);

					result = channel;

					cacheResult(channel);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (channel)result;
		}
	}

	/**
	 * Removes the channel where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the channel that was removed
	 */
	@Override
	public channel removeByemail(String email) throws NoSuchchannelException {
		channel channel = findByemail(email);

		return remove(channel);
	}

	/**
	 * Returns the number of channels where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching channels
	 */
	@Override
	public int countByemail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByemail;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHANNEL_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 =
		"channel.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(channel.email IS NULL OR channel.email = '')";

	public channelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("password", "password_");

		setDBColumnNames(dbColumnNames);

		setModelClass(channel.class);

		setModelImplClass(channelImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the channel in the entity cache if it is enabled.
	 *
	 * @param channel the channel
	 */
	@Override
	public void cacheResult(channel channel) {
		entityCache.putResult(
			channelImpl.class, channel.getPrimaryKey(), channel);

		finderCache.putResult(
			_finderPathFetchByemail, new Object[] {channel.getEmail()},
			channel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the channels in the entity cache if it is enabled.
	 *
	 * @param channels the channels
	 */
	@Override
	public void cacheResult(List<channel> channels) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (channels.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (channel channel : channels) {
			if (entityCache.getResult(
					channelImpl.class, channel.getPrimaryKey()) == null) {

				cacheResult(channel);
			}
		}
	}

	/**
	 * Clears the cache for all channels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(channelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the channel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(channel channel) {
		entityCache.removeResult(channelImpl.class, channel);
	}

	@Override
	public void clearCache(List<channel> channels) {
		for (channel channel : channels) {
			entityCache.removeResult(channelImpl.class, channel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(channelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(channelModelImpl channelModelImpl) {
		Object[] args = new Object[] {channelModelImpl.getEmail()};

		finderCache.putResult(
			_finderPathCountByemail, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByemail, args, channelModelImpl, false);
	}

	/**
	 * Creates a new channel with the primary key. Does not add the channel to the database.
	 *
	 * @param userName the primary key for the new channel
	 * @return the new channel
	 */
	@Override
	public channel create(String userName) {
		channel channel = new channelImpl();

		channel.setNew(true);
		channel.setPrimaryKey(userName);

		String uuid = PortalUUIDUtil.generate();

		channel.setUuid(uuid);

		return channel;
	}

	/**
	 * Removes the channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userName the primary key of the channel
	 * @return the channel that was removed
	 * @throws NoSuchchannelException if a channel with the primary key could not be found
	 */
	@Override
	public channel remove(String userName) throws NoSuchchannelException {
		return remove((Serializable)userName);
	}

	/**
	 * Removes the channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the channel
	 * @return the channel that was removed
	 * @throws NoSuchchannelException if a channel with the primary key could not be found
	 */
	@Override
	public channel remove(Serializable primaryKey)
		throws NoSuchchannelException {

		Session session = null;

		try {
			session = openSession();

			channel channel = (channel)session.get(
				channelImpl.class, primaryKey);

			if (channel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchchannelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(channel);
		}
		catch (NoSuchchannelException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected channel removeImpl(channel channel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(channel)) {
				channel = (channel)session.get(
					channelImpl.class, channel.getPrimaryKeyObj());
			}

			if (channel != null) {
				session.delete(channel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (channel != null) {
			clearCache(channel);
		}

		return channel;
	}

	@Override
	public channel updateImpl(channel channel) {
		boolean isNew = channel.isNew();

		if (!(channel instanceof channelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(channel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(channel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in channel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom channel implementation " +
					channel.getClass());
		}

		channelModelImpl channelModelImpl = (channelModelImpl)channel;

		if (Validator.isNull(channel.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			channel.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(channel);
			}
			else {
				channel = (channel)session.merge(channel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(channelImpl.class, channelModelImpl, false, true);

		cacheUniqueFindersCache(channelModelImpl);

		if (isNew) {
			channel.setNew(false);
		}

		channel.resetOriginalValues();

		return channel;
	}

	/**
	 * Returns the channel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the channel
	 * @return the channel
	 * @throws NoSuchchannelException if a channel with the primary key could not be found
	 */
	@Override
	public channel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchchannelException {

		channel channel = fetchByPrimaryKey(primaryKey);

		if (channel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchchannelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return channel;
	}

	/**
	 * Returns the channel with the primary key or throws a <code>NoSuchchannelException</code> if it could not be found.
	 *
	 * @param userName the primary key of the channel
	 * @return the channel
	 * @throws NoSuchchannelException if a channel with the primary key could not be found
	 */
	@Override
	public channel findByPrimaryKey(String userName)
		throws NoSuchchannelException {

		return findByPrimaryKey((Serializable)userName);
	}

	/**
	 * Returns the channel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userName the primary key of the channel
	 * @return the channel, or <code>null</code> if a channel with the primary key could not be found
	 */
	@Override
	public channel fetchByPrimaryKey(String userName) {
		return fetchByPrimaryKey((Serializable)userName);
	}

	/**
	 * Returns all the channels.
	 *
	 * @return the channels
	 */
	@Override
	public List<channel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<channel> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<channel> findAll(
		int start, int end, OrderByComparator<channel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<channel> findAll(
		int start, int end, OrderByComparator<channel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<channel> list = null;

		if (useFinderCache) {
			list = (List<channel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHANNEL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHANNEL;

				sql = sql.concat(channelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<channel>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the channels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (channel channel : findAll()) {
			remove(channel);
		}
	}

	/**
	 * Returns the number of channels.
	 *
	 * @return the number of channels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHANNEL);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userName";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CHANNEL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return channelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the channel persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new channelModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", channel.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByuserName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userName"}, true);

		_finderPathWithoutPaginationFindByuserName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserName",
			new String[] {String.class.getName()}, new String[] {"userName"},
			true);

		_finderPathCountByuserName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserName",
			new String[] {String.class.getName()}, new String[] {"userName"},
			false);

		_finderPathFetchByemail = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByemail",
			new String[] {String.class.getName()}, new String[] {"email"},
			true);

		_finderPathCountByemail = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemail",
			new String[] {String.class.getName()}, new String[] {"email"},
			false);

		_setchannelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setchannelUtilPersistence(null);

		entityCache.removeCache(channelImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setchannelUtilPersistence(
		channelPersistence channelPersistence) {

		try {
			Field field = channelUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, channelPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = LiferayPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = LiferayPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = LiferayPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CHANNEL =
		"SELECT channel FROM channel channel";

	private static final String _SQL_SELECT_CHANNEL_WHERE =
		"SELECT channel FROM channel channel WHERE ";

	private static final String _SQL_COUNT_CHANNEL =
		"SELECT COUNT(channel) FROM channel channel";

	private static final String _SQL_COUNT_CHANNEL_WHERE =
		"SELECT COUNT(channel) FROM channel channel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "channel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No channel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No channel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		channelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "password"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class channelModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			channelModelImpl channelModelImpl = (channelModelImpl)baseModel;

			long columnBitmask = channelModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(channelModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						channelModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(channelPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(channelModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			channelModelImpl channelModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = channelModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = channelModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= channelModelImpl.getColumnBitmask("name");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}