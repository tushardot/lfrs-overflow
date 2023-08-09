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

import queries.service.model.question;

/**
 * The persistence utility for the question service. This utility wraps <code>queries.service.service.persistence.impl.questionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see questionPersistence
 * @generated
 */
public class questionUtil {

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
	public static void clearCache(question question) {
		getPersistence().clearCache(question);
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
	public static Map<Serializable, question> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<question> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<question> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<question> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<question> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static question update(question question) {
		return getPersistence().update(question);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static question update(
		question question, ServiceContext serviceContext) {

		return getPersistence().update(question, serviceContext);
	}

	/**
	 * Returns all the questions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching questions
	 */
	public static List<question> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<question> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<question> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<question> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<question> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<question> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	public static question findByUuid_First(
			String uuid, OrderByComparator<question> orderByComparator)
		throws queries.service.exception.NoSuchquestionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question, or <code>null</code> if a matching question could not be found
	 */
	public static question fetchByUuid_First(
		String uuid, OrderByComparator<question> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	public static question findByUuid_Last(
			String uuid, OrderByComparator<question> orderByComparator)
		throws queries.service.exception.NoSuchquestionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question, or <code>null</code> if a matching question could not be found
	 */
	public static question fetchByUuid_Last(
		String uuid, OrderByComparator<question> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static question[] findByUuid_PrevAndNext(
			long quesId, String uuid,
			OrderByComparator<question> orderByComparator)
		throws queries.service.exception.NoSuchquestionException {

		return getPersistence().findByUuid_PrevAndNext(
			quesId, uuid, orderByComparator);
	}

	/**
	 * Removes all the questions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of questions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching questions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the questions where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching questions
	 */
	public static List<question> findByuserName(String userName) {
		return getPersistence().findByuserName(userName);
	}

	/**
	 * Returns a range of all the questions where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>questionModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of matching questions
	 */
	public static List<question> findByuserName(
		String userName, int start, int end) {

		return getPersistence().findByuserName(userName, start, end);
	}

	/**
	 * Returns an ordered range of all the questions where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>questionModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching questions
	 */
	public static List<question> findByuserName(
		String userName, int start, int end,
		OrderByComparator<question> orderByComparator) {

		return getPersistence().findByuserName(
			userName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the questions where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>questionModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching questions
	 */
	public static List<question> findByuserName(
		String userName, int start, int end,
		OrderByComparator<question> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserName(
			userName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first question in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	public static question findByuserName_First(
			String userName, OrderByComparator<question> orderByComparator)
		throws queries.service.exception.NoSuchquestionException {

		return getPersistence().findByuserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the first question in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question, or <code>null</code> if a matching question could not be found
	 */
	public static question fetchByuserName_First(
		String userName, OrderByComparator<question> orderByComparator) {

		return getPersistence().fetchByuserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the last question in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	public static question findByuserName_Last(
			String userName, OrderByComparator<question> orderByComparator)
		throws queries.service.exception.NoSuchquestionException {

		return getPersistence().findByuserName_Last(
			userName, orderByComparator);
	}

	/**
	 * Returns the last question in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question, or <code>null</code> if a matching question could not be found
	 */
	public static question fetchByuserName_Last(
		String userName, OrderByComparator<question> orderByComparator) {

		return getPersistence().fetchByuserName_Last(
			userName, orderByComparator);
	}

	/**
	 * Returns the questions before and after the current question in the ordered set where userName = &#63;.
	 *
	 * @param quesId the primary key of the current question
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next question
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	public static question[] findByuserName_PrevAndNext(
			long quesId, String userName,
			OrderByComparator<question> orderByComparator)
		throws queries.service.exception.NoSuchquestionException {

		return getPersistence().findByuserName_PrevAndNext(
			quesId, userName, orderByComparator);
	}

	/**
	 * Removes all the questions where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public static void removeByuserName(String userName) {
		getPersistence().removeByuserName(userName);
	}

	/**
	 * Returns the number of questions where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching questions
	 */
	public static int countByuserName(String userName) {
		return getPersistence().countByuserName(userName);
	}

	/**
	 * Returns the question where quesId = &#63; or throws a <code>NoSuchquestionException</code> if it could not be found.
	 *
	 * @param quesId the ques ID
	 * @return the matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	public static question findByquesId(long quesId)
		throws queries.service.exception.NoSuchquestionException {

		return getPersistence().findByquesId(quesId);
	}

	/**
	 * Returns the question where quesId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quesId the ques ID
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	public static question fetchByquesId(long quesId) {
		return getPersistence().fetchByquesId(quesId);
	}

	/**
	 * Returns the question where quesId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quesId the ques ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	public static question fetchByquesId(long quesId, boolean useFinderCache) {
		return getPersistence().fetchByquesId(quesId, useFinderCache);
	}

	/**
	 * Removes the question where quesId = &#63; from the database.
	 *
	 * @param quesId the ques ID
	 * @return the question that was removed
	 */
	public static question removeByquesId(long quesId)
		throws queries.service.exception.NoSuchquestionException {

		return getPersistence().removeByquesId(quesId);
	}

	/**
	 * Returns the number of questions where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @return the number of matching questions
	 */
	public static int countByquesId(long quesId) {
		return getPersistence().countByquesId(quesId);
	}

	/**
	 * Caches the question in the entity cache if it is enabled.
	 *
	 * @param question the question
	 */
	public static void cacheResult(question question) {
		getPersistence().cacheResult(question);
	}

	/**
	 * Caches the questions in the entity cache if it is enabled.
	 *
	 * @param questions the questions
	 */
	public static void cacheResult(List<question> questions) {
		getPersistence().cacheResult(questions);
	}

	/**
	 * Creates a new question with the primary key. Does not add the question to the database.
	 *
	 * @param quesId the primary key for the new question
	 * @return the new question
	 */
	public static question create(long quesId) {
		return getPersistence().create(quesId);
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quesId the primary key of the question
	 * @return the question that was removed
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	public static question remove(long quesId)
		throws queries.service.exception.NoSuchquestionException {

		return getPersistence().remove(quesId);
	}

	public static question updateImpl(question question) {
		return getPersistence().updateImpl(question);
	}

	/**
	 * Returns the question with the primary key or throws a <code>NoSuchquestionException</code> if it could not be found.
	 *
	 * @param quesId the primary key of the question
	 * @return the question
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	public static question findByPrimaryKey(long quesId)
		throws queries.service.exception.NoSuchquestionException {

		return getPersistence().findByPrimaryKey(quesId);
	}

	/**
	 * Returns the question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quesId the primary key of the question
	 * @return the question, or <code>null</code> if a question with the primary key could not be found
	 */
	public static question fetchByPrimaryKey(long quesId) {
		return getPersistence().fetchByPrimaryKey(quesId);
	}

	/**
	 * Returns all the questions.
	 *
	 * @return the questions
	 */
	public static List<question> findAll() {
		return getPersistence().findAll();
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
	public static List<question> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<question> findAll(
		int start, int end, OrderByComparator<question> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<question> findAll(
		int start, int end, OrderByComparator<question> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the questions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of questions.
	 *
	 * @return the number of questions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static questionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile questionPersistence _persistence;

}