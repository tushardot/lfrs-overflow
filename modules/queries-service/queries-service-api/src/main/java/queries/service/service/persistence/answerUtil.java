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

package queries.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import queries.service.model.answer;

/**
 * The persistence utility for the answer service. This utility wraps <code>queries.service.service.persistence.impl.answerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see answerPersistence
 * @generated
 */
public class answerUtil {

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
	public static void clearCache(answer answer) {
		getPersistence().clearCache(answer);
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
	public static Map<Serializable, answer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<answer> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<answer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<answer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<answer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static answer update(answer answer) {
		return getPersistence().update(answer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static answer update(answer answer, ServiceContext serviceContext) {
		return getPersistence().update(answer, serviceContext);
	}

	/**
	 * Returns all the answers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching answers
	 */
	public static List<answer> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<answer> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<answer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<answer> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<answer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<answer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public static answer findByUuid_First(
			String uuid, OrderByComparator<answer> orderByComparator)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public static answer fetchByUuid_First(
		String uuid, OrderByComparator<answer> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public static answer findByUuid_Last(
			String uuid, OrderByComparator<answer> orderByComparator)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public static answer fetchByUuid_Last(
		String uuid, OrderByComparator<answer> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static answer[] findByUuid_PrevAndNext(
			long ansId, String uuid,
			OrderByComparator<answer> orderByComparator)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().findByUuid_PrevAndNext(
			ansId, uuid, orderByComparator);
	}

	/**
	 * Removes all the answers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of answers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching answers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the answers where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching answers
	 */
	public static List<answer> findByuserName(String userName) {
		return getPersistence().findByuserName(userName);
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
	public static List<answer> findByuserName(
		String userName, int start, int end) {

		return getPersistence().findByuserName(userName, start, end);
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
	public static List<answer> findByuserName(
		String userName, int start, int end,
		OrderByComparator<answer> orderByComparator) {

		return getPersistence().findByuserName(
			userName, start, end, orderByComparator);
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
	public static List<answer> findByuserName(
		String userName, int start, int end,
		OrderByComparator<answer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserName(
			userName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public static answer findByuserName_First(
			String userName, OrderByComparator<answer> orderByComparator)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().findByuserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the first answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public static answer fetchByuserName_First(
		String userName, OrderByComparator<answer> orderByComparator) {

		return getPersistence().fetchByuserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the last answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public static answer findByuserName_Last(
			String userName, OrderByComparator<answer> orderByComparator)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().findByuserName_Last(
			userName, orderByComparator);
	}

	/**
	 * Returns the last answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public static answer fetchByuserName_Last(
		String userName, OrderByComparator<answer> orderByComparator) {

		return getPersistence().fetchByuserName_Last(
			userName, orderByComparator);
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
	public static answer[] findByuserName_PrevAndNext(
			long ansId, String userName,
			OrderByComparator<answer> orderByComparator)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().findByuserName_PrevAndNext(
			ansId, userName, orderByComparator);
	}

	/**
	 * Removes all the answers where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public static void removeByuserName(String userName) {
		getPersistence().removeByuserName(userName);
	}

	/**
	 * Returns the number of answers where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching answers
	 */
	public static int countByuserName(String userName) {
		return getPersistence().countByuserName(userName);
	}

	/**
	 * Returns all the answers where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @return the matching answers
	 */
	public static List<answer> findByquesId(long quesId) {
		return getPersistence().findByquesId(quesId);
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
	public static List<answer> findByquesId(long quesId, int start, int end) {
		return getPersistence().findByquesId(quesId, start, end);
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
	public static List<answer> findByquesId(
		long quesId, int start, int end,
		OrderByComparator<answer> orderByComparator) {

		return getPersistence().findByquesId(
			quesId, start, end, orderByComparator);
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
	public static List<answer> findByquesId(
		long quesId, int start, int end,
		OrderByComparator<answer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByquesId(
			quesId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public static answer findByquesId_First(
			long quesId, OrderByComparator<answer> orderByComparator)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().findByquesId_First(quesId, orderByComparator);
	}

	/**
	 * Returns the first answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public static answer fetchByquesId_First(
		long quesId, OrderByComparator<answer> orderByComparator) {

		return getPersistence().fetchByquesId_First(quesId, orderByComparator);
	}

	/**
	 * Returns the last answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public static answer findByquesId_Last(
			long quesId, OrderByComparator<answer> orderByComparator)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().findByquesId_Last(quesId, orderByComparator);
	}

	/**
	 * Returns the last answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public static answer fetchByquesId_Last(
		long quesId, OrderByComparator<answer> orderByComparator) {

		return getPersistence().fetchByquesId_Last(quesId, orderByComparator);
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
	public static answer[] findByquesId_PrevAndNext(
			long ansId, long quesId,
			OrderByComparator<answer> orderByComparator)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().findByquesId_PrevAndNext(
			ansId, quesId, orderByComparator);
	}

	/**
	 * Removes all the answers where quesId = &#63; from the database.
	 *
	 * @param quesId the ques ID
	 */
	public static void removeByquesId(long quesId) {
		getPersistence().removeByquesId(quesId);
	}

	/**
	 * Returns the number of answers where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @return the number of matching answers
	 */
	public static int countByquesId(long quesId) {
		return getPersistence().countByquesId(quesId);
	}

	/**
	 * Returns the answer where ansId = &#63; or throws a <code>NoSuchanswerException</code> if it could not be found.
	 *
	 * @param ansId the ans ID
	 * @return the matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public static answer findByansId(long ansId)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().findByansId(ansId);
	}

	/**
	 * Returns the answer where ansId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ansId the ans ID
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public static answer fetchByansId(long ansId) {
		return getPersistence().fetchByansId(ansId);
	}

	/**
	 * Returns the answer where ansId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ansId the ans ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public static answer fetchByansId(long ansId, boolean useFinderCache) {
		return getPersistence().fetchByansId(ansId, useFinderCache);
	}

	/**
	 * Removes the answer where ansId = &#63; from the database.
	 *
	 * @param ansId the ans ID
	 * @return the answer that was removed
	 */
	public static answer removeByansId(long ansId)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().removeByansId(ansId);
	}

	/**
	 * Returns the number of answers where ansId = &#63;.
	 *
	 * @param ansId the ans ID
	 * @return the number of matching answers
	 */
	public static int countByansId(long ansId) {
		return getPersistence().countByansId(ansId);
	}

	/**
	 * Caches the answer in the entity cache if it is enabled.
	 *
	 * @param answer the answer
	 */
	public static void cacheResult(answer answer) {
		getPersistence().cacheResult(answer);
	}

	/**
	 * Caches the answers in the entity cache if it is enabled.
	 *
	 * @param answers the answers
	 */
	public static void cacheResult(List<answer> answers) {
		getPersistence().cacheResult(answers);
	}

	/**
	 * Creates a new answer with the primary key. Does not add the answer to the database.
	 *
	 * @param ansId the primary key for the new answer
	 * @return the new answer
	 */
	public static answer create(long ansId) {
		return getPersistence().create(ansId);
	}

	/**
	 * Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ansId the primary key of the answer
	 * @return the answer that was removed
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	public static answer remove(long ansId)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().remove(ansId);
	}

	public static answer updateImpl(answer answer) {
		return getPersistence().updateImpl(answer);
	}

	/**
	 * Returns the answer with the primary key or throws a <code>NoSuchanswerException</code> if it could not be found.
	 *
	 * @param ansId the primary key of the answer
	 * @return the answer
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	public static answer findByPrimaryKey(long ansId)
		throws queries.service.exception.NoSuchanswerException {

		return getPersistence().findByPrimaryKey(ansId);
	}

	/**
	 * Returns the answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ansId the primary key of the answer
	 * @return the answer, or <code>null</code> if a answer with the primary key could not be found
	 */
	public static answer fetchByPrimaryKey(long ansId) {
		return getPersistence().fetchByPrimaryKey(ansId);
	}

	/**
	 * Returns all the answers.
	 *
	 * @return the answers
	 */
	public static List<answer> findAll() {
		return getPersistence().findAll();
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
	public static List<answer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<answer> findAll(
		int start, int end, OrderByComparator<answer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<answer> findAll(
		int start, int end, OrderByComparator<answer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the answers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of answers.
	 *
	 * @return the number of answers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static answerPersistence getPersistence() {
		return _persistence;
	}

	private static volatile answerPersistence _persistence;

}