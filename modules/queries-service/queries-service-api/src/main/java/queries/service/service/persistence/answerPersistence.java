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

import queries.service.exception.NoSuchanswerException;
import queries.service.model.answer;

/**
 * The persistence interface for the answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see answerUtil
 * @generated
 */
@ProviderType
public interface answerPersistence extends BasePersistence<answer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link answerUtil} to access the answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the answers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching answers
	 */
	public java.util.List<answer> findByUuid(String uuid);

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
	public java.util.List<answer> findByUuid(String uuid, int start, int end);

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
	public java.util.List<answer> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator);

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
	public java.util.List<answer> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public answer findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<answer>
				orderByComparator)
		throws NoSuchanswerException;

	/**
	 * Returns the first answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public answer fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator);

	/**
	 * Returns the last answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public answer findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<answer>
				orderByComparator)
		throws NoSuchanswerException;

	/**
	 * Returns the last answer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public answer fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator);

	/**
	 * Returns the answers before and after the current answer in the ordered set where uuid = &#63;.
	 *
	 * @param ansId the primary key of the current answer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answer
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	public answer[] findByUuid_PrevAndNext(
			long ansId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<answer>
				orderByComparator)
		throws NoSuchanswerException;

	/**
	 * Removes all the answers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of answers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching answers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the answers where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching answers
	 */
	public java.util.List<answer> findByuserName(String userName);

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
	public java.util.List<answer> findByuserName(
		String userName, int start, int end);

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
	public java.util.List<answer> findByuserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator);

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
	public java.util.List<answer> findByuserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public answer findByuserName_First(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<answer>
				orderByComparator)
		throws NoSuchanswerException;

	/**
	 * Returns the first answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public answer fetchByuserName_First(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator);

	/**
	 * Returns the last answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public answer findByuserName_Last(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<answer>
				orderByComparator)
		throws NoSuchanswerException;

	/**
	 * Returns the last answer in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public answer fetchByuserName_Last(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator);

	/**
	 * Returns the answers before and after the current answer in the ordered set where userName = &#63;.
	 *
	 * @param ansId the primary key of the current answer
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answer
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	public answer[] findByuserName_PrevAndNext(
			long ansId, String userName,
			com.liferay.portal.kernel.util.OrderByComparator<answer>
				orderByComparator)
		throws NoSuchanswerException;

	/**
	 * Removes all the answers where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public void removeByuserName(String userName);

	/**
	 * Returns the number of answers where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching answers
	 */
	public int countByuserName(String userName);

	/**
	 * Returns all the answers where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @return the matching answers
	 */
	public java.util.List<answer> findByquesId(long quesId);

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
	public java.util.List<answer> findByquesId(long quesId, int start, int end);

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
	public java.util.List<answer> findByquesId(
		long quesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator);

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
	public java.util.List<answer> findByquesId(
		long quesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public answer findByquesId_First(
			long quesId,
			com.liferay.portal.kernel.util.OrderByComparator<answer>
				orderByComparator)
		throws NoSuchanswerException;

	/**
	 * Returns the first answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public answer fetchByquesId_First(
		long quesId,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator);

	/**
	 * Returns the last answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public answer findByquesId_Last(
			long quesId,
			com.liferay.portal.kernel.util.OrderByComparator<answer>
				orderByComparator)
		throws NoSuchanswerException;

	/**
	 * Returns the last answer in the ordered set where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public answer fetchByquesId_Last(
		long quesId,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator);

	/**
	 * Returns the answers before and after the current answer in the ordered set where quesId = &#63;.
	 *
	 * @param ansId the primary key of the current answer
	 * @param quesId the ques ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answer
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	public answer[] findByquesId_PrevAndNext(
			long ansId, long quesId,
			com.liferay.portal.kernel.util.OrderByComparator<answer>
				orderByComparator)
		throws NoSuchanswerException;

	/**
	 * Removes all the answers where quesId = &#63; from the database.
	 *
	 * @param quesId the ques ID
	 */
	public void removeByquesId(long quesId);

	/**
	 * Returns the number of answers where quesId = &#63;.
	 *
	 * @param quesId the ques ID
	 * @return the number of matching answers
	 */
	public int countByquesId(long quesId);

	/**
	 * Returns the answer where ansId = &#63; or throws a <code>NoSuchanswerException</code> if it could not be found.
	 *
	 * @param ansId the ans ID
	 * @return the matching answer
	 * @throws NoSuchanswerException if a matching answer could not be found
	 */
	public answer findByansId(long ansId) throws NoSuchanswerException;

	/**
	 * Returns the answer where ansId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ansId the ans ID
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public answer fetchByansId(long ansId);

	/**
	 * Returns the answer where ansId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ansId the ans ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching answer, or <code>null</code> if a matching answer could not be found
	 */
	public answer fetchByansId(long ansId, boolean useFinderCache);

	/**
	 * Removes the answer where ansId = &#63; from the database.
	 *
	 * @param ansId the ans ID
	 * @return the answer that was removed
	 */
	public answer removeByansId(long ansId) throws NoSuchanswerException;

	/**
	 * Returns the number of answers where ansId = &#63;.
	 *
	 * @param ansId the ans ID
	 * @return the number of matching answers
	 */
	public int countByansId(long ansId);

	/**
	 * Caches the answer in the entity cache if it is enabled.
	 *
	 * @param answer the answer
	 */
	public void cacheResult(answer answer);

	/**
	 * Caches the answers in the entity cache if it is enabled.
	 *
	 * @param answers the answers
	 */
	public void cacheResult(java.util.List<answer> answers);

	/**
	 * Creates a new answer with the primary key. Does not add the answer to the database.
	 *
	 * @param ansId the primary key for the new answer
	 * @return the new answer
	 */
	public answer create(long ansId);

	/**
	 * Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ansId the primary key of the answer
	 * @return the answer that was removed
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	public answer remove(long ansId) throws NoSuchanswerException;

	public answer updateImpl(answer answer);

	/**
	 * Returns the answer with the primary key or throws a <code>NoSuchanswerException</code> if it could not be found.
	 *
	 * @param ansId the primary key of the answer
	 * @return the answer
	 * @throws NoSuchanswerException if a answer with the primary key could not be found
	 */
	public answer findByPrimaryKey(long ansId) throws NoSuchanswerException;

	/**
	 * Returns the answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ansId the primary key of the answer
	 * @return the answer, or <code>null</code> if a answer with the primary key could not be found
	 */
	public answer fetchByPrimaryKey(long ansId);

	/**
	 * Returns all the answers.
	 *
	 * @return the answers
	 */
	public java.util.List<answer> findAll();

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
	public java.util.List<answer> findAll(int start, int end);

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
	public java.util.List<answer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator);

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
	public java.util.List<answer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<answer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the answers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of answers.
	 *
	 * @return the number of answers
	 */
	public int countAll();

}