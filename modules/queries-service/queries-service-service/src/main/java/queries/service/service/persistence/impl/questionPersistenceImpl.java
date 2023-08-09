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

import queries.service.exception.NoSuchquestionException;
import queries.service.model.impl.questionImpl;
import queries.service.model.impl.questionModelImpl;
import queries.service.model.question;
import queries.service.service.persistence.impl.constants.queriesPersistenceConstants;
import queries.service.service.persistence.questionPersistence;
import queries.service.service.persistence.questionUtil;

/**
 * The persistence implementation for the question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = questionPersistence.class)
public class questionPersistenceImpl
	extends BasePersistenceImpl<question> implements questionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>questionUtil</code> to access the question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		questionImpl.class.getName();

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
	 * Returns all the questions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching questions
	 */
	@Override
	public List<question> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the questions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>questionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of matching questions
	 */
	@Override
	public List<question> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the questions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>questionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching questions
	 */
	@Override
	public List<question> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<question> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the questions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>questionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching questions
	 */
	@Override
	public List<question> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<question> orderByComparator, boolean useFinderCache) {

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

		List<question> list = null;

		if (useFinderCache) {
			list = (List<question>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (question question : list) {
					if (!uuid.equals(question.getUuid())) {
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

			sb.append(_SQL_SELECT_QUESTION_WHERE);

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
				sb.append(questionModelImpl.ORDER_BY_JPQL);
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

				list = (List<question>)QueryUtil.list(
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
	 * Returns the first question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	@Override
	public question findByUuid_First(
			String uuid, OrderByComparator<question> orderByComparator)
		throws NoSuchquestionException {

		question question = fetchByUuid_First(uuid, orderByComparator);

		if (question != null) {
			return question;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchquestionException(sb.toString());
	}

	/**
	 * Returns the first question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public question fetchByUuid_First(
		String uuid, OrderByComparator<question> orderByComparator) {

		List<question> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	@Override
	public question findByUuid_Last(
			String uuid, OrderByComparator<question> orderByComparator)
		throws NoSuchquestionException {

		question question = fetchByUuid_Last(uuid, orderByComparator);

		if (question != null) {
			return question;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchquestionException(sb.toString());
	}

	/**
	 * Returns the last question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public question fetchByUuid_Last(
		String uuid, OrderByComparator<question> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<question> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the questions before and after the current question in the ordered set where uuid = &#63;.
	 *
	 * @param quesId the primary key of the current question
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next question
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	@Override
	public question[] findByUuid_PrevAndNext(
			long quesId, String uuid,
			OrderByComparator<question> orderByComparator)
		throws NoSuchquestionException {

		uuid = Objects.toString(uuid, "");

		question question = findByPrimaryKey(quesId);

		Session session = null;

		try {
			session = openSession();

			question[] array = new questionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, question, uuid, orderByComparator, true);

			array[1] = question;

			array[2] = getByUuid_PrevAndNext(
				session, question, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected question getByUuid_PrevAndNext(
		Session session, question question, String uuid,
		OrderByComparator<question> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_QUESTION_WHERE);

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
			sb.append(questionModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(question)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<question> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the questions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (question question :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(question);
		}
	}

	/**
	 * Returns the number of questions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching questions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUESTION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"question.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(question.uuid IS NULL OR question.uuid = '')";

	private FinderPath _finderPathFetchByuserName;
	private FinderPath _finderPathCountByuserName;

	/**
	 * Returns the question where userName = &#63; or throws a <code>NoSuchquestionException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	@Override
	public question findByuserName(String userName)
		throws NoSuchquestionException {

		question question = fetchByuserName(userName);

		if (question == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userName=");
			sb.append(userName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchquestionException(sb.toString());
		}

		return question;
	}

	/**
	 * Returns the question where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public question fetchByuserName(String userName) {
		return fetchByuserName(userName, true);
	}

	/**
	 * Returns the question where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public question fetchByuserName(String userName, boolean useFinderCache) {
		userName = Objects.toString(userName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByuserName, finderArgs, this);
		}

		if (result instanceof question) {
			question question = (question)result;

			if (!Objects.equals(userName, question.getUserName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_QUESTION_WHERE);

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

				List<question> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByuserName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userName};
							}

							_log.warn(
								"questionPersistenceImpl.fetchByuserName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					question question = list.get(0);

					result = question;

					cacheResult(question);
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
			return (question)result;
		}
	}

	/**
	 * Removes the question where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the question that was removed
	 */
	@Override
	public question removeByuserName(String userName)
		throws NoSuchquestionException {

		question question = findByuserName(userName);

		return remove(question);
	}

	/**
	 * Returns the number of questions where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching questions
	 */
	@Override
	public int countByuserName(String userName) {
		userName = Objects.toString(userName, "");

		FinderPath finderPath = _finderPathCountByuserName;

		Object[] finderArgs = new Object[] {userName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUESTION_WHERE);

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
		"question.userName = ?";

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 =
		"(question.userName IS NULL OR question.userName = '')";

	private FinderPath _finderPathFetchByquesId;
	private FinderPath _finderPathCountByquesId;

	/**
	 * Returns the question where quesId = &#63; or throws a <code>NoSuchquestionException</code> if it could not be found.
	 *
	 * @param quesId the ques ID
	 * @return the matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	@Override
	public question findByquesId(long quesId) throws NoSuchquestionException {
		question question = fetchByquesId(quesId);

		if (question == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("quesId=");
			sb.append(quesId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchquestionException(sb.toString());
		}

		return question;
	}

	/**
	 * Returns the question where quesId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quesId the ques ID
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public question fetchByquesId(long quesId) {
		return fetchByquesId(quesId, true);
	}

	/**
	 * Returns the question where quesId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quesId the ques ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public question fetchByquesId(long quesId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {quesId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByquesId, finderArgs, this);
		}

		if (result instanceof question) {
			question question = (question)result;

			if (quesId != question.getQuesId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_QUESTION_WHERE);

			sb.append(_FINDER_COLUMN_QUESID_QUESID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quesId);

				List<question> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByquesId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {quesId};
							}

							_log.warn(
								"questionPersistenceImpl.fetchByquesId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					question question = list.get(0);

					result = question;

					cacheResult(question);
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
			return (question)result;
		}
	}

	/**
	 * Removes the question where quesId = &#63; from the database.
	 *
	 * @param quesId the ques ID
	 * @return the question that was removed
	 */
	@Override
	public question removeByquesId(long quesId) throws NoSuchquestionException {
		question question = findByquesId(quesId);

		return remove(question);
	}

	/**
	 * Returns the number of questions where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @return the number of matching questions
	 */
	@Override
	public int countByquesId(long quesId) {
		FinderPath finderPath = _finderPathCountByquesId;

		Object[] finderArgs = new Object[] {quesId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUESTION_WHERE);

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
		"question.quesId = ?";

	public questionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(question.class);

		setModelImplClass(questionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the question in the entity cache if it is enabled.
	 *
	 * @param question the question
	 */
	@Override
	public void cacheResult(question question) {
		entityCache.putResult(
			questionImpl.class, question.getPrimaryKey(), question);

		finderCache.putResult(
			_finderPathFetchByuserName, new Object[] {question.getUserName()},
			question);

		finderCache.putResult(
			_finderPathFetchByquesId, new Object[] {question.getQuesId()},
			question);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the questions in the entity cache if it is enabled.
	 *
	 * @param questions the questions
	 */
	@Override
	public void cacheResult(List<question> questions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (questions.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (question question : questions) {
			if (entityCache.getResult(
					questionImpl.class, question.getPrimaryKey()) == null) {

				cacheResult(question);
			}
		}
	}

	/**
	 * Clears the cache for all questions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(questionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(question question) {
		entityCache.removeResult(questionImpl.class, question);
	}

	@Override
	public void clearCache(List<question> questions) {
		for (question question : questions) {
			entityCache.removeResult(questionImpl.class, question);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(questionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		questionModelImpl questionModelImpl) {

		Object[] args = new Object[] {questionModelImpl.getUserName()};

		finderCache.putResult(
			_finderPathCountByuserName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByuserName, args, questionModelImpl, false);

		args = new Object[] {questionModelImpl.getQuesId()};

		finderCache.putResult(
			_finderPathCountByquesId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByquesId, args, questionModelImpl, false);
	}

	/**
	 * Creates a new question with the primary key. Does not add the question to the database.
	 *
	 * @param quesId the primary key for the new question
	 * @return the new question
	 */
	@Override
	public question create(long quesId) {
		question question = new questionImpl();

		question.setNew(true);
		question.setPrimaryKey(quesId);

		String uuid = PortalUUIDUtil.generate();

		question.setUuid(uuid);

		return question;
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quesId the primary key of the question
	 * @return the question that was removed
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	@Override
	public question remove(long quesId) throws NoSuchquestionException {
		return remove((Serializable)quesId);
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question that was removed
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	@Override
	public question remove(Serializable primaryKey)
		throws NoSuchquestionException {

		Session session = null;

		try {
			session = openSession();

			question question = (question)session.get(
				questionImpl.class, primaryKey);

			if (question == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchquestionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(question);
		}
		catch (NoSuchquestionException noSuchEntityException) {
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
	protected question removeImpl(question question) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(question)) {
				question = (question)session.get(
					questionImpl.class, question.getPrimaryKeyObj());
			}

			if (question != null) {
				session.delete(question);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (question != null) {
			clearCache(question);
		}

		return question;
	}

	@Override
	public question updateImpl(question question) {
		boolean isNew = question.isNew();

		if (!(question instanceof questionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(question.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(question);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in question proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom question implementation " +
					question.getClass());
		}

		questionModelImpl questionModelImpl = (questionModelImpl)question;

		if (Validator.isNull(question.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			question.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(question);
			}
			else {
				question = (question)session.merge(question);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			questionImpl.class, questionModelImpl, false, true);

		cacheUniqueFindersCache(questionModelImpl);

		if (isNew) {
			question.setNew(false);
		}

		question.resetOriginalValues();

		return question;
	}

	/**
	 * Returns the question with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	@Override
	public question findByPrimaryKey(Serializable primaryKey)
		throws NoSuchquestionException {

		question question = fetchByPrimaryKey(primaryKey);

		if (question == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchquestionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return question;
	}

	/**
	 * Returns the question with the primary key or throws a <code>NoSuchquestionException</code> if it could not be found.
	 *
	 * @param quesId the primary key of the question
	 * @return the question
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	@Override
	public question findByPrimaryKey(long quesId)
		throws NoSuchquestionException {

		return findByPrimaryKey((Serializable)quesId);
	}

	/**
	 * Returns the question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quesId the primary key of the question
	 * @return the question, or <code>null</code> if a question with the primary key could not be found
	 */
	@Override
	public question fetchByPrimaryKey(long quesId) {
		return fetchByPrimaryKey((Serializable)quesId);
	}

	/**
	 * Returns all the questions.
	 *
	 * @return the questions
	 */
	@Override
	public List<question> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>questionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of questions
	 */
	@Override
	public List<question> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>questionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of questions
	 */
	@Override
	public List<question> findAll(
		int start, int end, OrderByComparator<question> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>questionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of questions
	 */
	@Override
	public List<question> findAll(
		int start, int end, OrderByComparator<question> orderByComparator,
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

		List<question> list = null;

		if (useFinderCache) {
			list = (List<question>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUESTION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTION;

				sql = sql.concat(questionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<question>)QueryUtil.list(
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
	 * Removes all the questions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (question question : findAll()) {
			remove(question);
		}
	}

	/**
	 * Returns the number of questions.
	 *
	 * @return the number of questions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_QUESTION);

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
		return "quesId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUESTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return questionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the question persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new questionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", question.class.getName()));

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

		_finderPathFetchByuserName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByuserName",
			new String[] {String.class.getName()}, new String[] {"userName"},
			true);

		_finderPathCountByuserName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserName",
			new String[] {String.class.getName()}, new String[] {"userName"},
			false);

		_finderPathFetchByquesId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByquesId",
			new String[] {Long.class.getName()}, new String[] {"quesId"}, true);

		_finderPathCountByquesId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByquesId",
			new String[] {Long.class.getName()}, new String[] {"quesId"},
			false);

		_setquestionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setquestionUtilPersistence(null);

		entityCache.removeCache(questionImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setquestionUtilPersistence(
		questionPersistence questionPersistence) {

		try {
			Field field = questionUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, questionPersistence);
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

	private static final String _SQL_SELECT_QUESTION =
		"SELECT question FROM question question";

	private static final String _SQL_SELECT_QUESTION_WHERE =
		"SELECT question FROM question question WHERE ";

	private static final String _SQL_COUNT_QUESTION =
		"SELECT COUNT(question) FROM question question";

	private static final String _SQL_COUNT_QUESTION_WHERE =
		"SELECT COUNT(question) FROM question question WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "question.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No question exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No question exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		questionPersistenceImpl.class);

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

	private static class questionModelArgumentsResolver
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

			questionModelImpl questionModelImpl = (questionModelImpl)baseModel;

			long columnBitmask = questionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(questionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						questionModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(questionPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(questionModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			questionModelImpl questionModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = questionModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = questionModelImpl.getColumnValue(columnName);
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