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

package queries.service.service.persistence.impl;

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

import queries.service.exception.NoSuchanswerException;
import queries.service.model.answer;
import queries.service.model.impl.answerImpl;
import queries.service.model.impl.answerModelImpl;
import queries.service.service.persistence.answerPersistence;
import queries.service.service.persistence.answerUtil;
import queries.service.service.persistence.impl.constants.queriesPersistenceConstants;

/**
 * The persistence implementation for the answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = answerPersistence.class)
public class answerPersistenceImpl
	extends BasePersistenceImpl<answer> implements answerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>answerUtil</code> to access the answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		answerImpl.class.getName();

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
	 * Returns all the answers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching answers
	 */
	@Override
	public List<answer> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @return the range of matching answers
	 */
	@Override
	public List<answer> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers
	 */
	@Override
	public List<answer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<answer> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the answers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers
	 */
	@Override
	public List<answer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<answer> orderByComparator, boolean useFinderCache) {

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

		List<answer> list = null;

		if (useFinderCache) {
			list = (List<answer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (answer answer : list) {
					if (!uuid.equals(answer.getUuid())) {
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

			sb.append(_SQL_SELECT_ANSWER_WHERE);

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
				sb.append(answerModelImpl.ORDER_BY_JPQL);
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

				list = (List<answer>)QueryUtil.list(
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
	 * Returns the first answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	@Override
	public answer findByUuid_First(
			String uuid, OrderByComparator<answer> orderByComparator)
		throws NoSuchanswerException {

		answer answer = fetchByUuid_First(uuid, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchanswerException(sb.toString());
	}

	/**
	 * Returns the first answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer, or <code>null</code> if a matching answer could not be found
	 */
	@Override
	public answer fetchByUuid_First(
		String uuid, OrderByComparator<answer> orderByComparator) {

		List<answer> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	@Override
	public answer findByUuid_Last(
			String uuid, OrderByComparator<answer> orderByComparator)
		throws NoSuchanswerException {

		answer answer = fetchByUuid_Last(uuid, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchanswerException(sb.toString());
	}

	/**
	 * Returns the last answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer, or <code>null</code> if a matching answer could not be found
	 */
	@Override
	public answer fetchByUuid_Last(
		String uuid, OrderByComparator<answer> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<answer> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the answers before and after the current answer in the ordered set where uuid = &#63;.
	 *
	 * @param ansId the primary key of the current answer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answer
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	@Override
	public answer[] findByUuid_PrevAndNext(
			long ansId, String uuid,
			OrderByComparator<answer> orderByComparator)
		throws NoSuchanswerException {

		uuid = Objects.toString(uuid, "");

		answer answer = findByPrimaryKey(ansId);

		Session session = null;

		try {
			session = openSession();

			answer[] array = new answerImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, answer, uuid, orderByComparator, true);

			array[1] = answer;

			array[2] = getByUuid_PrevAndNext(
				session, answer, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected answer getByUuid_PrevAndNext(
		Session session, answer answer, String uuid,
		OrderByComparator<answer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ANSWER_WHERE);

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
			sb.append(answerModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(answer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<answer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the answers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (answer answer :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(answer);
		}
	}

	/**
	 * Returns the number of answers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching answers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANSWER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "answer.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(answer.uuid IS NULL OR answer.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByuserName;
	private FinderPath _finderPathWithoutPaginationFindByuserName;
	private FinderPath _finderPathCountByuserName;

	/**
	 * Returns all the answers where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching answers
	 */
	@Override
	public List<answer> findByuserName(String userName) {
		return findByuserName(
			userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @return the range of matching answers
	 */
	@Override
	public List<answer> findByuserName(String userName, int start, int end) {
		return findByuserName(userName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers
	 */
	@Override
	public List<answer> findByuserName(
		String userName, int start, int end,
		OrderByComparator<answer> orderByComparator) {

		return findByuserName(userName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the answers where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers
	 */
	@Override
	public List<answer> findByuserName(
		String userName, int start, int end,
		OrderByComparator<answer> orderByComparator, boolean useFinderCache) {

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

		List<answer> list = null;

		if (useFinderCache) {
			list = (List<answer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (answer answer : list) {
					if (!userName.equals(answer.getUserName())) {
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

			sb.append(_SQL_SELECT_ANSWER_WHERE);

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
				sb.append(answerModelImpl.ORDER_BY_JPQL);
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

				list = (List<answer>)QueryUtil.list(
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
	 * Returns the first answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	@Override
	public answer findByuserName_First(
			String userName, OrderByComparator<answer> orderByComparator)
		throws NoSuchanswerException {

		answer answer = fetchByuserName_First(userName, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userName=");
		sb.append(userName);

		sb.append("}");

		throw new NoSuchanswerException(sb.toString());
	}

	/**
	 * Returns the first answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer, or <code>null</code> if a matching answer could not be found
	 */
	@Override
	public answer fetchByuserName_First(
		String userName, OrderByComparator<answer> orderByComparator) {

		List<answer> list = findByuserName(userName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	@Override
	public answer findByuserName_Last(
			String userName, OrderByComparator<answer> orderByComparator)
		throws NoSuchanswerException {

		answer answer = fetchByuserName_Last(userName, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userName=");
		sb.append(userName);

		sb.append("}");

		throw new NoSuchanswerException(sb.toString());
	}

	/**
	 * Returns the last answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer, or <code>null</code> if a matching answer could not be found
	 */
	@Override
	public answer fetchByuserName_Last(
		String userName, OrderByComparator<answer> orderByComparator) {

		int count = countByuserName(userName);

		if (count == 0) {
			return null;
		}

		List<answer> list = findByuserName(
			userName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the answers before and after the current answer in the ordered set where userName = &#63;.
	 *
	 * @param ansId the primary key of the current answer
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answer
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	@Override
	public answer[] findByuserName_PrevAndNext(
			long ansId, String userName,
			OrderByComparator<answer> orderByComparator)
		throws NoSuchanswerException {

		userName = Objects.toString(userName, "");

		answer answer = findByPrimaryKey(ansId);

		Session session = null;

		try {
			session = openSession();

			answer[] array = new answerImpl[3];

			array[0] = getByuserName_PrevAndNext(
				session, answer, userName, orderByComparator, true);

			array[1] = answer;

			array[2] = getByuserName_PrevAndNext(
				session, answer, userName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected answer getByuserName_PrevAndNext(
		Session session, answer answer, String userName,
		OrderByComparator<answer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ANSWER_WHERE);

		boolean bindUserName = false;

		if (userName.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
		}
		else {
			bindUserName = true;

			sb.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
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
			sb.append(answerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUserName) {
			queryPos.add(userName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(answer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<answer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the answers where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	@Override
	public void removeByuserName(String userName) {
		for (answer answer :
				findByuserName(
					userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(answer);
		}
	}

	/**
	 * Returns the number of answers where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching answers
	 */
	@Override
	public int countByuserName(String userName) {
		userName = Objects.toString(userName, "");

		FinderPath finderPath = _finderPathCountByuserName;

		Object[] finderArgs = new Object[] {userName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANSWER_WHERE);

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
		"answer.userName = ?";

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 =
		"(answer.userName IS NULL OR answer.userName = '')";

	private FinderPath _finderPathWithPaginationFindByquesId;
	private FinderPath _finderPathWithoutPaginationFindByquesId;
	private FinderPath _finderPathCountByquesId;

	/**
	 * Returns all the answers where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @return the matching answers
	 */
	@Override
	public List<answer> findByquesId(long quesId) {
		return findByquesId(quesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers where quesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param quesId the ques ID
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @return the range of matching answers
	 */
	@Override
	public List<answer> findByquesId(long quesId, int start, int end) {
		return findByquesId(quesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers where quesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param quesId the ques ID
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers
	 */
	@Override
	public List<answer> findByquesId(
		long quesId, int start, int end,
		OrderByComparator<answer> orderByComparator) {

		return findByquesId(quesId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the answers where quesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param quesId the ques ID
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers
	 */
	@Override
	public List<answer> findByquesId(
		long quesId, int start, int end,
		OrderByComparator<answer> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByquesId;
				finderArgs = new Object[] {quesId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByquesId;
			finderArgs = new Object[] {quesId, start, end, orderByComparator};
		}

		List<answer> list = null;

		if (useFinderCache) {
			list = (List<answer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (answer answer : list) {
					if (quesId != answer.getQuesId()) {
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

			sb.append(_SQL_SELECT_ANSWER_WHERE);

			sb.append(_FINDER_COLUMN_QUESID_QUESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(answerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quesId);

				list = (List<answer>)QueryUtil.list(
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
	 * Returns the first answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	@Override
	public answer findByquesId_First(
			long quesId, OrderByComparator<answer> orderByComparator)
		throws NoSuchanswerException {

		answer answer = fetchByquesId_First(quesId, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quesId=");
		sb.append(quesId);

		sb.append("}");

		throw new NoSuchanswerException(sb.toString());
	}

	/**
	 * Returns the first answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer, or <code>null</code> if a matching answer could not be found
	 */
	@Override
	public answer fetchByquesId_First(
		long quesId, OrderByComparator<answer> orderByComparator) {

		List<answer> list = findByquesId(quesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	@Override
	public answer findByquesId_Last(
			long quesId, OrderByComparator<answer> orderByComparator)
		throws NoSuchanswerException {

		answer answer = fetchByquesId_Last(quesId, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quesId=");
		sb.append(quesId);

		sb.append("}");

		throw new NoSuchanswerException(sb.toString());
	}

	/**
	 * Returns the last answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer, or <code>null</code> if a matching answer could not be found
	 */
	@Override
	public answer fetchByquesId_Last(
		long quesId, OrderByComparator<answer> orderByComparator) {

		int count = countByquesId(quesId);

		if (count == 0) {
			return null;
		}

		List<answer> list = findByquesId(
			quesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the answers before and after the current answer in the ordered set where quesId = &#63;.
	 *
	 * @param ansId the primary key of the current answer
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answer
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	@Override
	public answer[] findByquesId_PrevAndNext(
			long ansId, long quesId,
			OrderByComparator<answer> orderByComparator)
		throws NoSuchanswerException {

		answer answer = findByPrimaryKey(ansId);

		Session session = null;

		try {
			session = openSession();

			answer[] array = new answerImpl[3];

			array[0] = getByquesId_PrevAndNext(
				session, answer, quesId, orderByComparator, true);

			array[1] = answer;

			array[2] = getByquesId_PrevAndNext(
				session, answer, quesId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected answer getByquesId_PrevAndNext(
		Session session, answer answer, long quesId,
		OrderByComparator<answer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ANSWER_WHERE);

		sb.append(_FINDER_COLUMN_QUESID_QUESID_2);

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
			sb.append(answerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(quesId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(answer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<answer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the answers where quesId = &#63; from the database.
	 *
	 * @param quesId the ques ID
	 */
	@Override
	public void removeByquesId(long quesId) {
		for (answer answer :
				findByquesId(
					quesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(answer);
		}
	}

	/**
	 * Returns the number of answers where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @return the number of matching answers
	 */
	@Override
	public int countByquesId(long quesId) {
		FinderPath finderPath = _finderPathCountByquesId;

		Object[] finderArgs = new Object[] {quesId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANSWER_WHERE);

			sb.append(_FINDER_COLUMN_QUESID_QUESID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quesId);

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

	private static final String _FINDER_COLUMN_QUESID_QUESID_2 =
		"answer.quesId = ?";

	private FinderPath _finderPathFetchByansId;
	private FinderPath _finderPathCountByansId;

	/**
	 * Returns the answer where ansId = &#63; or throws a <code>NoSuchanswerException</code> if it could not be found.
	 *
	 * @param ansId the ans ID
	 * @return the matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	@Override
	public answer findByansId(long ansId) throws NoSuchanswerException {
		answer answer = fetchByansId(ansId);

		if (answer == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("ansId=");
			sb.append(ansId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchanswerException(sb.toString());
		}

		return answer;
	}

	/**
	 * Returns the answer where ansId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ansId the ans ID
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 */
	@Override
	public answer fetchByansId(long ansId) {
		return fetchByansId(ansId, true);
	}

	/**
	 * Returns the answer where ansId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ansId the ans ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 */
	@Override
	public answer fetchByansId(long ansId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {ansId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByansId, finderArgs, this);
		}

		if (result instanceof answer) {
			answer answer = (answer)result;

			if (ansId != answer.getAnsId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ANSWER_WHERE);

			sb.append(_FINDER_COLUMN_ANSID_ANSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ansId);

				List<answer> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByansId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {ansId};
							}

							_log.warn(
								"answerPersistenceImpl.fetchByansId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					answer answer = list.get(0);

					result = answer;

					cacheResult(answer);
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
			return (answer)result;
		}
	}

	/**
	 * Removes the answer where ansId = &#63; from the database.
	 *
	 * @param ansId the ans ID
	 * @return the answer that was removed
	 */
	@Override
	public answer removeByansId(long ansId) throws NoSuchanswerException {
		answer answer = findByansId(ansId);

		return remove(answer);
	}

	/**
	 * Returns the number of answers where ansId = &#63;.
	 *
	 * @param ansId the ans ID
	 * @return the number of matching answers
	 */
	@Override
	public int countByansId(long ansId) {
		FinderPath finderPath = _finderPathCountByansId;

		Object[] finderArgs = new Object[] {ansId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ANSWER_WHERE);

			sb.append(_FINDER_COLUMN_ANSID_ANSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ansId);

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

	private static final String _FINDER_COLUMN_ANSID_ANSID_2 =
		"answer.ansId = ?";

	public answerPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(answer.class);

		setModelImplClass(answerImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the answer in the entity cache if it is enabled.
	 *
	 * @param answer the answer
	 */
	@Override
	public void cacheResult(answer answer) {
		entityCache.putResult(answerImpl.class, answer.getPrimaryKey(), answer);

		finderCache.putResult(
			_finderPathFetchByansId, new Object[] {answer.getAnsId()}, answer);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the answers in the entity cache if it is enabled.
	 *
	 * @param answers the answers
	 */
	@Override
	public void cacheResult(List<answer> answers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (answers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (answer answer : answers) {
			if (entityCache.getResult(
					answerImpl.class, answer.getPrimaryKey()) == null) {

				cacheResult(answer);
			}
		}
	}

	/**
	 * Clears the cache for all answers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(answerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the answer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(answer answer) {
		entityCache.removeResult(answerImpl.class, answer);
	}

	@Override
	public void clearCache(List<answer> answers) {
		for (answer answer : answers) {
			entityCache.removeResult(answerImpl.class, answer);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(answerImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(answerModelImpl answerModelImpl) {
		Object[] args = new Object[] {answerModelImpl.getAnsId()};

		finderCache.putResult(
			_finderPathCountByansId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByansId, args, answerModelImpl, false);
	}

	/**
	 * Creates a new answer with the primary key. Does not add the answer to the database.
	 *
	 * @param ansId the primary key for the new answer
	 * @return the new answer
	 */
	@Override
	public answer create(long ansId) {
		answer answer = new answerImpl();

		answer.setNew(true);
		answer.setPrimaryKey(ansId);

		String uuid = PortalUUIDUtil.generate();

		answer.setUuid(uuid);

		return answer;
	}

	/**
	 * Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ansId the primary key of the answer
	 * @return the answer that was removed
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	@Override
	public answer remove(long ansId) throws NoSuchanswerException {
		return remove((Serializable)ansId);
	}

	/**
	 * Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the answer
	 * @return the answer that was removed
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	@Override
	public answer remove(Serializable primaryKey) throws NoSuchanswerException {
		Session session = null;

		try {
			session = openSession();

			answer answer = (answer)session.get(answerImpl.class, primaryKey);

			if (answer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchanswerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(answer);
		}
		catch (NoSuchanswerException noSuchEntityException) {
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
	protected answer removeImpl(answer answer) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(answer)) {
				answer = (answer)session.get(
					answerImpl.class, answer.getPrimaryKeyObj());
			}

			if (answer != null) {
				session.delete(answer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (answer != null) {
			clearCache(answer);
		}

		return answer;
	}

	@Override
	public answer updateImpl(answer answer) {
		boolean isNew = answer.isNew();

		if (!(answer instanceof answerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(answer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(answer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in answer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom answer implementation " +
					answer.getClass());
		}

		answerModelImpl answerModelImpl = (answerModelImpl)answer;

		if (Validator.isNull(answer.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			answer.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(answer);
			}
			else {
				answer = (answer)session.merge(answer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(answerImpl.class, answerModelImpl, false, true);

		cacheUniqueFindersCache(answerModelImpl);

		if (isNew) {
			answer.setNew(false);
		}

		answer.resetOriginalValues();

		return answer;
	}

	/**
	 * Returns the answer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the answer
	 * @return the answer
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	@Override
	public answer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchanswerException {

		answer answer = fetchByPrimaryKey(primaryKey);

		if (answer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchanswerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return answer;
	}

	/**
	 * Returns the answer with the primary key or throws a <code>NoSuchanswerException</code> if it could not be found.
	 *
	 * @param ansId the primary key of the answer
	 * @return the answer
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	@Override
	public answer findByPrimaryKey(long ansId) throws NoSuchanswerException {
		return findByPrimaryKey((Serializable)ansId);
	}

	/**
	 * Returns the answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ansId the primary key of the answer
	 * @return the answer, or <code>null</code> if a answer with the primary key could not be found
	 */
	@Override
	public answer fetchByPrimaryKey(long ansId) {
		return fetchByPrimaryKey((Serializable)ansId);
	}

	/**
	 * Returns all the answers.
	 *
	 * @return the answers
	 */
	@Override
	public List<answer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @return the range of answers
	 */
	@Override
	public List<answer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of answers
	 */
	@Override
	public List<answer> findAll(
		int start, int end, OrderByComparator<answer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>answerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of answers
	 */
	@Override
	public List<answer> findAll(
		int start, int end, OrderByComparator<answer> orderByComparator,
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

		List<answer> list = null;

		if (useFinderCache) {
			list = (List<answer>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ANSWER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ANSWER;

				sql = sql.concat(answerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<answer>)QueryUtil.list(
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
	 * Removes all the answers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (answer answer : findAll()) {
			remove(answer);
		}
	}

	/**
	 * Returns the number of answers.
	 *
	 * @return the number of answers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ANSWER);

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
		return "ansId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ANSWER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return answerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the answer persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new answerModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", answer.class.getName()));

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

		_finderPathWithPaginationFindByquesId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByquesId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"quesId"}, true);

		_finderPathWithoutPaginationFindByquesId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByquesId",
			new String[] {Long.class.getName()}, new String[] {"quesId"}, true);

		_finderPathCountByquesId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByquesId",
			new String[] {Long.class.getName()}, new String[] {"quesId"},
			false);

		_finderPathFetchByansId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByansId",
			new String[] {Long.class.getName()}, new String[] {"ansId"}, true);

		_finderPathCountByansId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByansId",
			new String[] {Long.class.getName()}, new String[] {"ansId"}, false);

		_setanswerUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setanswerUtilPersistence(null);

		entityCache.removeCache(answerImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setanswerUtilPersistence(
		answerPersistence answerPersistence) {

		try {
			Field field = answerUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, answerPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = queriesPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = queriesPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = queriesPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_ANSWER =
		"SELECT answer FROM answer answer";

	private static final String _SQL_SELECT_ANSWER_WHERE =
		"SELECT answer FROM answer answer WHERE ";

	private static final String _SQL_COUNT_ANSWER =
		"SELECT COUNT(answer) FROM answer answer";

	private static final String _SQL_COUNT_ANSWER_WHERE =
		"SELECT COUNT(answer) FROM answer answer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "answer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No answer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No answer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		answerPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

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

	private static class answerModelArgumentsResolver
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

			answerModelImpl answerModelImpl = (answerModelImpl)baseModel;

			long columnBitmask = answerModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(answerModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= answerModelImpl.getColumnBitmask(
						columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(answerPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(answerModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			answerModelImpl answerModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = answerModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = answerModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}