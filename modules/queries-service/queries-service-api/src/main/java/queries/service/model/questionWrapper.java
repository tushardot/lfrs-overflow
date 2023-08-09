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

package queries.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link question}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see question
 * @generated
 */
public class questionWrapper
	extends BaseModelWrapper<question>
	implements ModelWrapper<question>, question {

	public questionWrapper(question question) {
		super(question);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("quesId", getQuesId());
		attributes.put("quesTitle", getQuesTitle());
		attributes.put("quesDesc", getQuesDesc());
		attributes.put("userName", getUserName());
		attributes.put("field1", getField1());
		attributes.put("field2", isField2());
		attributes.put("field3", getField3());
		attributes.put("field4", getField4());
		attributes.put("field5", getField5());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long quesId = (Long)attributes.get("quesId");

		if (quesId != null) {
			setQuesId(quesId);
		}

		String quesTitle = (String)attributes.get("quesTitle");

		if (quesTitle != null) {
			setQuesTitle(quesTitle);
		}

		String quesDesc = (String)attributes.get("quesDesc");

		if (quesDesc != null) {
			setQuesDesc(quesDesc);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String field1 = (String)attributes.get("field1");

		if (field1 != null) {
			setField1(field1);
		}

		Boolean field2 = (Boolean)attributes.get("field2");

		if (field2 != null) {
			setField2(field2);
		}

		Integer field3 = (Integer)attributes.get("field3");

		if (field3 != null) {
			setField3(field3);
		}

		Date field4 = (Date)attributes.get("field4");

		if (field4 != null) {
			setField4(field4);
		}

		String field5 = (String)attributes.get("field5");

		if (field5 != null) {
			setField5(field5);
		}
	}

	/**
	 * Returns the field1 of this question.
	 *
	 * @return the field1 of this question
	 */
	@Override
	public String getField1() {
		return model.getField1();
	}

	/**
	 * Returns the field2 of this question.
	 *
	 * @return the field2 of this question
	 */
	@Override
	public boolean getField2() {
		return model.getField2();
	}

	/**
	 * Returns the field3 of this question.
	 *
	 * @return the field3 of this question
	 */
	@Override
	public int getField3() {
		return model.getField3();
	}

	/**
	 * Returns the field4 of this question.
	 *
	 * @return the field4 of this question
	 */
	@Override
	public Date getField4() {
		return model.getField4();
	}

	/**
	 * Returns the field5 of this question.
	 *
	 * @return the field5 of this question
	 */
	@Override
	public String getField5() {
		return model.getField5();
	}

	/**
	 * Returns the primary key of this question.
	 *
	 * @return the primary key of this question
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ques desc of this question.
	 *
	 * @return the ques desc of this question
	 */
	@Override
	public String getQuesDesc() {
		return model.getQuesDesc();
	}

	/**
	 * Returns the ques ID of this question.
	 *
	 * @return the ques ID of this question
	 */
	@Override
	public long getQuesId() {
		return model.getQuesId();
	}

	/**
	 * Returns the ques title of this question.
	 *
	 * @return the ques title of this question
	 */
	@Override
	public String getQuesTitle() {
		return model.getQuesTitle();
	}

	/**
	 * Returns the user name of this question.
	 *
	 * @return the user name of this question
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the uuid of this question.
	 *
	 * @return the uuid of this question
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this question is field2.
	 *
	 * @return <code>true</code> if this question is field2; <code>false</code> otherwise
	 */
	@Override
	public boolean isField2() {
		return model.isField2();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the field1 of this question.
	 *
	 * @param field1 the field1 of this question
	 */
	@Override
	public void setField1(String field1) {
		model.setField1(field1);
	}

	/**
	 * Sets whether this question is field2.
	 *
	 * @param field2 the field2 of this question
	 */
	@Override
	public void setField2(boolean field2) {
		model.setField2(field2);
	}

	/**
	 * Sets the field3 of this question.
	 *
	 * @param field3 the field3 of this question
	 */
	@Override
	public void setField3(int field3) {
		model.setField3(field3);
	}

	/**
	 * Sets the field4 of this question.
	 *
	 * @param field4 the field4 of this question
	 */
	@Override
	public void setField4(Date field4) {
		model.setField4(field4);
	}

	/**
	 * Sets the field5 of this question.
	 *
	 * @param field5 the field5 of this question
	 */
	@Override
	public void setField5(String field5) {
		model.setField5(field5);
	}

	/**
	 * Sets the primary key of this question.
	 *
	 * @param primaryKey the primary key of this question
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ques desc of this question.
	 *
	 * @param quesDesc the ques desc of this question
	 */
	@Override
	public void setQuesDesc(String quesDesc) {
		model.setQuesDesc(quesDesc);
	}

	/**
	 * Sets the ques ID of this question.
	 *
	 * @param quesId the ques ID of this question
	 */
	@Override
	public void setQuesId(long quesId) {
		model.setQuesId(quesId);
	}

	/**
	 * Sets the ques title of this question.
	 *
	 * @param quesTitle the ques title of this question
	 */
	@Override
	public void setQuesTitle(String quesTitle) {
		model.setQuesTitle(quesTitle);
	}

	/**
	 * Sets the user name of this question.
	 *
	 * @param userName the user name of this question
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the uuid of this question.
	 *
	 * @param uuid the uuid of this question
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected questionWrapper wrap(question question) {
		return new questionWrapper(question);
	}

}