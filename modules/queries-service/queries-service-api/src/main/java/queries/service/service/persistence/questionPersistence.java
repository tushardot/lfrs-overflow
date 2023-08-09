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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import queries.service.exception.NoSuchquestionException;
import queries.service.model.question;

/**
 * The persistence interface for the question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see questionUtil
 * @generated
 */
@ProviderType
public interface questionPersistence extends BasePersistence<question> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link questionUtil} to access the question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the questions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching questions
	 */
	public java.util.List<question> findByUuid(String uuid);

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
	public java.util.List<question> findByUuid(String uuid, int start, int end);

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
	public java.util.List<question> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<question>
			orderByComparator);

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
	public java.util.List<question> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<question>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	public question findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<question>
				orderByComparator)
		throws NoSuchquestionException;

	/**
	 * Returns the first question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question, or <code>null</code> if a matching question could not be found
	 */
	public question fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<question>
			orderByComparator);

	/**
	 * Returns the last question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	public question findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<question>
				orderByComparator)
		throws NoSuchquestionException;

	/**
	 * Returns the last question in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question, or <code>null</code> if a matching question could not be found
	 */
	public question fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<question>
			orderByComparator);

	/**
	 * Returns the questions before and after the current question in the ordered set where uuid = &#63;.
	 *
	 * @param quesId the primary key of the current question
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next question
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	public question[] findByUuid_PrevAndNext(
			long quesId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<question>
				orderByComparator)
		throws NoSuchquestionException;

	/**
	 * Removes all the questions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of questions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching questions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the questions where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching questions
	 */
	public java.util.List<question> findByuserName(String userName);

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
	public java.util.List<question> findByuserName(
		String userName, int start, int end);

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
	public java.util.List<question> findByuserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<question>
			orderByComparator);

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
	public java.util.List<question> findByuserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<question>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first question in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	public question findByuserName_First(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<question>
				orderByComparator)
		throws NoSuchquestionException;

	/**
	 * Returns the first question in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question, or <code>null</code> if a matching question could not be found
	 */
	public question fetchByuserName_First(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<question>
			orderByComparator);

	/**
	 * Returns the last question in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	public question findByuserName_Last(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<question>
				orderByComparator)
		throws NoSuchquestionException;

	/**
	 * Returns the last question in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question, or <code>null</code> if a matching question could not be found
	 */
	public question fetchByuserName_Last(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<question>
			orderByComparator);

	/**
	 * Returns the questions before and after the current question in the ordered set where userName = &#63;.
	 *
	 * @param quesId the primary key of the current question
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next question
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	public question[] findByuserName_PrevAndNext(
			long quesId, String userName,
			com.liferay.portal.kernel.util.OrderByComparator<question>
				orderByComparator)
		throws NoSuchquestionException;

	/**
	 * Removes all the questions where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public void removeByuserName(String userName);

	/**
	 * Returns the number of questions where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching questions
	 */
	public int countByuserName(String userName);

	/**
	 * Returns the question where quesId = &#63; or throws a <code>NoSuchquestionException</code> if it could not be found.
	 *
	 * @param quesId the ques ID
	 * @return the matching question
	 * @throws NoSuchquestionException if a matching question could not be found
	 */
	public question findByquesId(long quesId) throws NoSuchquestionException;

	/**
	 * Returns the question where quesId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quesId the ques ID
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	public question fetchByquesId(long quesId);

	/**
	 * Returns the question where quesId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quesId the ques ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	public question fetchByquesId(long quesId, boolean useFinderCache);

	/**
	 * Removes the question where quesId = &#63; from the database.
	 *
	 * @param quesId the ques ID
	 * @return the question that was removed
	 */
	public question removeByquesId(long quesId) throws NoSuchquestionException;

	/**
	 * Returns the number of questions where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @return the number of matching questions
	 */
	public int countByquesId(long quesId);

	/**
	 * Caches the question in the entity cache if it is enabled.
	 *
	 * @param question the question
	 */
	public void cacheResult(question question);

	/**
	 * Caches the questions in the entity cache if it is enabled.
	 *
	 * @param questions the questions
	 */
	public void cacheResult(java.util.List<question> questions);

	/**
	 * Creates a new question with the primary key. Does not add the question to the database.
	 *
	 * @param quesId the primary key for the new question
	 * @return the new question
	 */
	public question create(long quesId);

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quesId the primary key of the question
	 * @return the question that was removed
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	public question remove(long quesId) throws NoSuchquestionException;

	public question updateImpl(question question);

	/**
	 * Returns the question with the primary key or throws a <code>NoSuchquestionException</code> if it could not be found.
	 *
	 * @param quesId the primary key of the question
	 * @return the question
	 * @throws NoSuchquestionException if a question with the primary key could not be found
	 */
	public question findByPrimaryKey(long quesId)
		throws NoSuchquestionException;

	/**
	 * Returns the question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quesId the primary key of the question
	 * @return the question, or <code>null</code> if a question with the primary key could not be found
	 */
	public question fetchByPrimaryKey(long quesId);

	/**
	 * Returns all the questions.
	 *
	 * @return the questions
	 */
	public java.util.List<question> findAll();

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
	public java.util.List<question> findAll(int start, int end);

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
	public java.util.List<question> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<question>
			orderByComparator);

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
	public java.util.List<question> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<question>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the questions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of questions.
	 *
	 * @return the number of questions
	 */
	public int countAll();

}