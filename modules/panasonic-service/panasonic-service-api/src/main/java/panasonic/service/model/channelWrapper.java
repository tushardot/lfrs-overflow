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

package panasonic.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link channel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see channel
 * @generated
 */
public class channelWrapper
	extends BaseModelWrapper<channel>
	implements channel, ModelWrapper<channel> {

	public channelWrapper(channel channel) {
		super(channel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userName", getUserName());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("password", getPassword());
		attributes.put("otp", getOtp());
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String otp = (String)attributes.get("otp");

		if (otp != null) {
			setOtp(otp);
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
	 * Returns the email of this channel.
	 *
	 * @return the email of this channel
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the field1 of this channel.
	 *
	 * @return the field1 of this channel
	 */
	@Override
	public String getField1() {
		return model.getField1();
	}

	/**
	 * Returns the field2 of this channel.
	 *
	 * @return the field2 of this channel
	 */
	@Override
	public boolean getField2() {
		return model.getField2();
	}

	/**
	 * Returns the field3 of this channel.
	 *
	 * @return the field3 of this channel
	 */
	@Override
	public int getField3() {
		return model.getField3();
	}

	/**
	 * Returns the field4 of this channel.
	 *
	 * @return the field4 of this channel
	 */
	@Override
	public Date getField4() {
		return model.getField4();
	}

	/**
	 * Returns the field5 of this channel.
	 *
	 * @return the field5 of this channel
	 */
	@Override
	public String getField5() {
		return model.getField5();
	}

	/**
	 * Returns the name of this channel.
	 *
	 * @return the name of this channel
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the otp of this channel.
	 *
	 * @return the otp of this channel
	 */
	@Override
	public String getOtp() {
		return model.getOtp();
	}

	/**
	 * Returns the password of this channel.
	 *
	 * @return the password of this channel
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the primary key of this channel.
	 *
	 * @return the primary key of this channel
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user name of this channel.
	 *
	 * @return the user name of this channel
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the uuid of this channel.
	 *
	 * @return the uuid of this channel
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this channel is field2.
	 *
	 * @return <code>true</code> if this channel is field2; <code>false</code> otherwise
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
	 * Sets the email of this channel.
	 *
	 * @param email the email of this channel
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the field1 of this channel.
	 *
	 * @param field1 the field1 of this channel
	 */
	@Override
	public void setField1(String field1) {
		model.setField1(field1);
	}

	/**
	 * Sets whether this channel is field2.
	 *
	 * @param field2 the field2 of this channel
	 */
	@Override
	public void setField2(boolean field2) {
		model.setField2(field2);
	}

	/**
	 * Sets the field3 of this channel.
	 *
	 * @param field3 the field3 of this channel
	 */
	@Override
	public void setField3(int field3) {
		model.setField3(field3);
	}

	/**
	 * Sets the field4 of this channel.
	 *
	 * @param field4 the field4 of this channel
	 */
	@Override
	public void setField4(Date field4) {
		model.setField4(field4);
	}

	/**
	 * Sets the field5 of this channel.
	 *
	 * @param field5 the field5 of this channel
	 */
	@Override
	public void setField5(String field5) {
		model.setField5(field5);
	}

	/**
	 * Sets the name of this channel.
	 *
	 * @param name the name of this channel
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the otp of this channel.
	 *
	 * @param otp the otp of this channel
	 */
	@Override
	public void setOtp(String otp) {
		model.setOtp(otp);
	}

	/**
	 * Sets the password of this channel.
	 *
	 * @param password the password of this channel
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the primary key of this channel.
	 *
	 * @param primaryKey the primary key of this channel
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user name of this channel.
	 *
	 * @param userName the user name of this channel
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the uuid of this channel.
	 *
	 * @param uuid the uuid of this channel
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected channelWrapper wrap(channel channel) {
		return new channelWrapper(channel);
	}

}