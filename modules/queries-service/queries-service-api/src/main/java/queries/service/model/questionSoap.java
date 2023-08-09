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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link queries.service.service.http.questionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class questionSoap implements Serializable {

	public static questionSoap toSoapModel(question model) {
		questionSoap soapModel = new questionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setQuesId(model.getQuesId());
		soapModel.setQuesTitle(model.getQuesTitle());
		soapModel.setQuesDesc(model.getQuesDesc());
		soapModel.setUserName(model.getUserName());
		soapModel.setField1(model.getField1());
		soapModel.setField2(model.isField2());
		soapModel.setField3(model.getField3());
		soapModel.setField4(model.getField4());
		soapModel.setField5(model.getField5());

		return soapModel;
	}

	public static questionSoap[] toSoapModels(question[] models) {
		questionSoap[] soapModels = new questionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static questionSoap[][] toSoapModels(question[][] models) {
		questionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new questionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new questionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static questionSoap[] toSoapModels(List<question> models) {
		List<questionSoap> soapModels = new ArrayList<questionSoap>(
			models.size());

		for (question model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new questionSoap[soapModels.size()]);
	}

	public questionSoap() {
	}

	public long getPrimaryKey() {
		return _quesId;
	}

	public void setPrimaryKey(long pk) {
		setQuesId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getQuesId() {
		return _quesId;
	}

	public void setQuesId(long quesId) {
		_quesId = quesId;
	}

	public String getQuesTitle() {
		return _quesTitle;
	}

	public void setQuesTitle(String quesTitle) {
		_quesTitle = quesTitle;
	}

	public String getQuesDesc() {
		return _quesDesc;
	}

	public void setQuesDesc(String quesDesc) {
		_quesDesc = quesDesc;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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
	private long _quesId;
	private String _quesTitle;
	private String _quesDesc;
	private String _userName;
	private String _field1;
	private boolean _field2;
	private int _field3;
	private Date _field4;
	private String _field5;

}