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
 * This class is a wrapper for {@link answer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see answer
 * @generated
 */
public class answerWrapper
	extends BaseModelWrapper<answer> implements answer, ModelWrapper<answer> {

	public answerWrapper(answer answer) {
		super(answer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ansId", getAnsId());
		attributes.put("ansTitle", getAnsTitle());
		attributes.put("ansDesc", getAnsDesc());
		attributes.put("userName", getUserName());
		attributes.put("quesId", getQuesId());
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

		Long ansId = (Long)attributes.get("ansId");

		if (ansId != null) {
			setAnsId(ansId);
		}

		String ansTitle = (String)attributes.get("ansTitle");

		if (ansTitle != null) {
			setAnsTitle(ansTitle);
		}

		String ansDesc = (String)attributes.get("ansDesc");

		if (ansDesc != null) {
			setAnsDesc(ansDesc);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long quesId = (Long)attributes.get("quesId");

		if (quesId != null) {
			setQuesId(quesId);
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
	 * Returns the ans desc of this answer.
	 *
	 * @return the ans desc of this answer
	 */
	@Override
	public String getAnsDesc() {
		return model.getAnsDesc();
	}

	/**
	 * Returns the ans ID of this answer.
	 *
	 * @return the ans ID of this answer
	 */
	@Override
	public long getAnsId() {
		return model.getAnsId();
	}

	/**
	 * Returns the ans title of this answer.
	 *
	 * @return the ans title of this answer
	 */
	@Override
	public String getAnsTitle() {
		return model.getAnsTitle();
	}

	/**
	 * Returns the field1 of this answer.
	 *
	 * @return the field1 of this answer
	 */
	@Override
	public String getField1() {
		return model.getField1();
	}

	/**
	 * Returns the field2 of this answer.
	 *
	 * @return the field2 of this answer
	 */
	@Override
	public boolean getField2() {
		return model.getField2();
	}

	/**
	 * Returns the field3 of this answer.
	 *
	 * @return the field3 of this answer
	 */
	@Override
	public int getField3() {
		return model.getField3();
	}

	/**
	 * Returns the field4 of this answer.
	 *
	 * @return the field4 of this answer
	 */
	@Override
	public Date getField4() {
		return model.getField4();
	}

	/**
	 * Returns the field5 of this answer.
	 *
	 * @return the field5 of this answer
	 */
	@Override
	public String getField5() {
		return model.getField5();
	}

	/**
	 * Returns the primary key of this answer.
	 *
	 * @return the primary key of this answer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ques ID of this answer.
	 *
	 * @return the ques ID of this answer
	 */
	@Override
	public long getQuesId() {
		return model.getQuesId();
	}

	/**
	 * Returns the user name of this answer.
	 *
	 * @return the user name of this answer
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the uuid of this answer.
	 *
	 * @return the uuid of this answer
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this answer is field2.
	 *
	 * @return <code>true</code> if this answer is field2; <code>false</code> otherwise
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
	 * Sets the ans desc of this answer.
	 *
	 * @param ansDesc the ans desc of this answer
	 */
	@Override
	public void setAnsDesc(String ansDesc) {
		model.setAnsDesc(ansDesc);
	}

	/**
	 * Sets the ans ID of this answer.
	 *
	 * @param ansId the ans ID of this answer
	 */
	@Override
	public void setAnsId(long ansId) {
		model.setAnsId(ansId);
	}

	/**
	 * Sets the ans title of this answer.
	 *
	 * @param ansTitle the ans title of this answer
	 */
	@Override
	public void setAnsTitle(String ansTitle) {
		model.setAnsTitle(ansTitle);
	}

	/**
	 * Sets the field1 of this answer.
	 *
	 * @param field1 the field1 of this answer
	 */
	@Override
	public void setField1(String field1) {
		model.setField1(field1);
	}

	/**
	 * Sets whether this answer is field2.
	 *
	 * @param field2 the field2 of this answer
	 */
	@Override
	public void setField2(boolean field2) {
		model.setField2(field2);
	}

	/**
	 * Sets the field3 of this answer.
	 *
	 * @param field3 the field3 of this answer
	 */
	@Override
	public void setField3(int field3) {
		model.setField3(field3);
	}

	/**
	 * Sets the field4 of this answer.
	 *
	 * @param field4 the field4 of this answer
	 */
	@Override
	public void setField4(Date field4) {
		model.setField4(field4);
	}

	/**
	 * Sets the field5 of this answer.
	 *
	 * @param field5 the field5 of this answer
	 */
	@Override
	public void setField5(String field5) {
		model.setField5(field5);
	}

	/**
	 * Sets the primary key of this answer.
	 *
	 * @param primaryKey the primary key of this answer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ques ID of this answer.
	 *
	 * @param quesId the ques ID of this answer
	 */
	@Override
	public void setQuesId(long quesId) {
		model.setQuesId(quesId);
	}

	/**
	 * Sets the user name of this answer.
	 *
	 * @param userName the user name of this answer
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the uuid of this answer.
	 *
	 * @param uuid the uuid of this answer
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected answerWrapper wrap(answer answer) {
		return new answerWrapper(answer);
	}

}