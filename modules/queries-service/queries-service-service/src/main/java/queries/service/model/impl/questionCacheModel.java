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

package queries.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import queries.service.model.question;

/**
 * The cache model class for representing question in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class questionCacheModel
	implements CacheModel<question>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof questionCacheModel)) {
			return false;
		}

		questionCacheModel questionCacheModel = (questionCacheModel)object;

		if (quesId == questionCacheModel.quesId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, quesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", quesId=");
		sb.append(quesId);
		sb.append(", quesTitle=");
		sb.append(quesTitle);
		sb.append(", quesDesc=");
		sb.append(quesDesc);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", field1=");
		sb.append(field1);
		sb.append(", field2=");
		sb.append(field2);
		sb.append(", field3=");
		sb.append(field3);
		sb.append(", field4=");
		sb.append(field4);
		sb.append(", field5=");
		sb.append(field5);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public question toEntityModel() {
		questionImpl questionImpl = new questionImpl();

		if (uuid == null) {
			questionImpl.setUuid("");
		}
		else {
			questionImpl.setUuid(uuid);
		}

		questionImpl.setQuesId(quesId);

		if (quesTitle == null) {
			questionImpl.setQuesTitle("");
		}
		else {
			questionImpl.setQuesTitle(quesTitle);
		}

		if (quesDesc == null) {
			questionImpl.setQuesDesc("");
		}
		else {
			questionImpl.setQuesDesc(quesDesc);
		}

		if (userName == null) {
			questionImpl.setUserName("");
		}
		else {
			questionImpl.setUserName(userName);
		}

		if (field1 == null) {
			questionImpl.setField1("");
		}
		else {
			questionImpl.setField1(field1);
		}

		questionImpl.setField2(field2);
		questionImpl.setField3(field3);

		if (field4 == Long.MIN_VALUE) {
			questionImpl.setField4(null);
		}
		else {
			questionImpl.setField4(new Date(field4));
		}

		if (field5 == null) {
			questionImpl.setField5("");
		}
		else {
			questionImpl.setField5(field5);
		}

		questionImpl.resetOriginalValues();

		return questionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		quesId = objectInput.readLong();
		quesTitle = objectInput.readUTF();
		quesDesc = objectInput.readUTF();
		userName = objectInput.readUTF();
		field1 = objectInput.readUTF();

		field2 = objectInput.readBoolean();

		field3 = objectInput.readInt();
		field4 = objectInput.readLong();
		field5 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(quesId);

		if (quesTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quesTitle);
		}

		if (quesDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quesDesc);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (field1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(field1);
		}

		objectOutput.writeBoolean(field2);

		objectOutput.writeInt(field3);
		objectOutput.writeLong(field4);

		if (field5 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(field5);
		}
	}

	public String uuid;
	public long quesId;
	public String quesTitle;
	public String quesDesc;
	public String userName;
	public String field1;
	public boolean field2;
	public int field3;
	public long field4;
	public String field5;

}