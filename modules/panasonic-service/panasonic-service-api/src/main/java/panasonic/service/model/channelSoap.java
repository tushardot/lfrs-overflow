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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link panasonic.service.service.http.channelServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class channelSoap implements Serializable {

	public static channelSoap toSoapModel(channel model) {
		channelSoap soapModel = new channelSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserName(model.getUserName());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setPassword(model.getPassword());
		soapModel.setOtp(model.getOtp());
		soapModel.setField1(model.getField1());
		soapModel.setField2(model.isField2());
		soapModel.setField3(model.getField3());
		soapModel.setField4(model.getField4());
		soapModel.setField5(model.getField5());

		return soapModel;
	}

	public static channelSoap[] toSoapModels(channel[] models) {
		channelSoap[] soapModels = new channelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static channelSoap[][] toSoapModels(channel[][] models) {
		channelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new channelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new channelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static channelSoap[] toSoapModels(List<channel> models) {
		List<channelSoap> soapModels = new ArrayList<channelSoap>(
			models.size());

		for (channel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new channelSoap[soapModels.size()]);
	}

	public channelSoap() {
	}

	public String getPrimaryKey() {
		return _userName;
	}

	public void setPrimaryKey(String pk) {
		setUserName(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getOtp() {
		return _otp;
	}

	public void setOtp(String otp) {
		_otp = otp;
	}

	public String getField1() {
		return _field1;
	}

	public void setField1(String field1) {
		_field1 = field1;
	}

	public boolean getField2() {
		return _field2;
	}

	public boolean isField2() {
		return _field2;
	}

	public void setField2(boolean field2) {
		_field2 = field2;
	}

	public int getField3() {
		return _field3;
	}

	public void setField3(int field3) {
		_field3 = field3;
	}

	public Date getField4() {
		return _field4;
	}

	public void setField4(Date field4) {
		_field4 = field4;
	}

	public String getField5() {
		return _field5;
	}

	public void setField5(String field5) {
		_field5 = field5;
	}

	private String _uuid;
	private String _userName;
	private String _name;
	private String _email;
	private String _password;
	private String _otp;
	private String _field1;
	private boolean _field2;
	private int _field3;
	private Date _field4;
	private String _field5;

}