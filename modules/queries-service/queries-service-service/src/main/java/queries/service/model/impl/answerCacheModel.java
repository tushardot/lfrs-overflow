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

import queries.service.model.answer;

/**
 * The cache model class for representing answer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class answerCacheModel implements CacheModel<answer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof answerCacheModel)) {
			return false;
		}

		answerCacheModel answerCacheModel = (answerCacheModel)object;

		if (ansId == answerCacheModel.ansId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ansId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ansId=");
		sb.append(ansId);
		sb.append(", ansTitle=");
		sb.append(ansTitle);
		sb.append(", ansDesc=");
		sb.append(ansDesc);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", quesId=");
		sb.append(quesId);
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
	public answer toEntityModel() {
		answerImpl answerImpl = new answerImpl();

		if (uuid == null) {
			answerImpl.setUuid("");
		}
		else {
			answerImpl.setUuid(uuid);
		}

		answerImpl.setAnsId(ansId);

		if (ansTitle == null) {
			answerImpl.setAnsTitle("");
		}
		else {
			answerImpl.setAnsTitle(ansTitle);
		}

		if (ansDesc == null) {
			answerImpl.setAnsDesc("");
		}
		else {
			answerImpl.setAnsDesc(ansDesc);
		}

		if (userName == null) {
			answerImpl.setUserName("");
		}
		else {
			answerImpl.setUserName(userName);
		}

		answerImpl.setQuesId(quesId);

		if (field1 == null) {
			answerImpl.setField1("");
		}
		else {
			answerImpl.setField1(field1);
		}

		answerImpl.setField2(field2);
		answerImpl.setField3(field3);

		if (field4 == Long.MIN_VALUE) {
			answerImpl.setField4(null);
		}
		else {
			answerImpl.setField4(new Date(field4));
		}

		if (field5 == null) {
			answerImpl.setField5("");
		}
		else {
			answerImpl.setField5(field5);
		}

		answerImpl.resetOriginalValues();

		return answerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ansId = objectInput.readLong();
		ansTitle = objectInput.readUTF();
		ansDesc = objectInput.readUTF();
		userName = objectInput.readUTF();

		quesId = objectInput.readLong();
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

		objectOutput.writeLong(ansId);

		if (ansTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ansTitle);
		}

		if (ansDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ansDesc);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(quesId);

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
	public long ansId;
	public String ansTitle;
	public String ansDesc;
	public String userName;
	public long quesId;
	public String field1;
	public boolean field2;
	public int field3;
	public long field4;
	public String field5;

}