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

package panasonic.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import panasonic.service.model.channel;

/**
 * The cache model class for representing channel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class channelCacheModel implements CacheModel<channel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof channelCacheModel)) {
			return false;
		}

		channelCacheModel channelCacheModel = (channelCacheModel)object;

		if (userName.equals(channelCacheModel.userName)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userName);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", password=");
		sb.append(password);
		sb.append(", otp=");
		sb.append(otp);
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
	public channel toEntityModel() {
		channelImpl channelImpl = new channelImpl();

		if (uuid == null) {
			channelImpl.setUuid("");
		}
		else {
			channelImpl.setUuid(uuid);
		}

		if (userName == null) {
			channelImpl.setUserName("");
		}
		else {
			channelImpl.setUserName(userName);
		}

		if (name == null) {
			channelImpl.setName("");
		}
		else {
			channelImpl.setName(name);
		}

		if (email == null) {
			channelImpl.setEmail("");
		}
		else {
			channelImpl.setEmail(email);
		}

		if (password == null) {
			channelImpl.setPassword("");
		}
		else {
			channelImpl.setPassword(password);
		}

		if (otp == null) {
			channelImpl.setOtp("");
		}
		else {
			channelImpl.setOtp(otp);
		}

		if (field1 == null) {
			channelImpl.setField1("");
		}
		else {
			channelImpl.setField1(field1);
		}

		channelImpl.setField2(field2);
		channelImpl.setField3(field3);

		if (field4 == Long.MIN_VALUE) {
			channelImpl.setField4(null);
		}
		else {
			channelImpl.setField4(new Date(field4));
		}

		if (field5 == null) {
			channelImpl.setField5("");
		}
		else {
			channelImpl.setField5(field5);
		}

		channelImpl.resetOriginalValues();

		return channelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		userName = objectInput.readUTF();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		password = objectInput.readUTF();
		otp = objectInput.readUTF();
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

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (otp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(otp);
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
	public String userName;
	public String name;
	public String email;
	public String password;
	public String otp;
	public String field1;
	public boolean field2;
	public int field3;
	public long field4;
	public String field5;

}