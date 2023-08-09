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
 * This class is used by SOAP remote services, specifically {@link queries.service.service.http.answerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class answerSoap implements Serializable {

	public static answerSoap toSoapModel(answer model) {
		answerSoap soapModel = new answerSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAnsId(model.getAnsId());
		soapModel.setAnsTitle(model.getAnsTitle());
		soapModel.setAnsDesc(model.getAnsDesc());
		soapModel.setUserName(model.getUserName());
		soapModel.setQuesId(model.getQuesId());
		soapModel.setField1(model.getField1());
		soapModel.setField2(model.isField2());
		soapModel.setField3(model.getField3());
		soapModel.setField4(model.getField4());
		soapModel.setField5(model.getField5());

		return soapModel;
	}

	public static answerSoap[] toSoapModels(answer[] models) {
		answerSoap[] soapModels = new answerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static answerSoap[][] toSoapModels(answer[][] models) {
		answerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new answerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new answerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static answerSoap[] toSoapModels(List<answer> models) {
		List<answerSoap> soapModels = new ArrayList<answerSoap>(models.size());

		for (answer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new answerSoap[soapModels.size()]);
	}

	public answerSoap() {
	}

	public long getPrimaryKey() {
		return _ansId;
	}

	public void setPrimaryKey(long pk) {
		setAnsId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAnsId() {
		return _ansId;
	}

	public void setAnsId(long ansId) {
		_ansId = ansId;
	}

	public String getAnsTitle() {
		return _ansTitle;
	}

	public void setAnsTitle(String ansTitle) {
		_ansTitle = ansTitle;
	}

	public String getAnsDesc() {
		return _ansDesc;
	}

	public void setAnsDesc(String ansDesc) {
		_ansDesc = ansDesc;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getQuesId() {
		return _quesId;
	}

	public void setQuesId(long quesId) {
		_quesId = quesId;
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
	private long _ansId;
	private String _ansTitle;
	private String _ansDesc;
	private String _userName;
	private long _quesId;
	private String _field1;
	private boolean _field2;
	private int _field3;
	private Date _field4;
	private String _field5;

}