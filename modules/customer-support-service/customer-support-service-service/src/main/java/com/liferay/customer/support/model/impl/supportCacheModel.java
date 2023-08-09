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

package com.liferay.customer.support.model.impl;

import com.liferay.customer.support.model.support;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing support in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class supportCacheModel implements CacheModel<support>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof supportCacheModel)) {
			return false;
		}

		supportCacheModel supportCacheModel = (supportCacheModel)object;

		if (spportId == supportCacheModel.spportId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, spportId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{spportId=");
		sb.append(spportId);
		sb.append(", claim=");
		sb.append(claim);
		sb.append(", query=");
		sb.append(query);
		sb.append(", suggestioncomplaint=");
		sb.append(suggestioncomplaint);
		sb.append(", BU=");
		sb.append(BU);
		sb.append(", channel=");
		sb.append(channel);
		sb.append(", invoiceNumber=");
		sb.append(invoiceNumber);
		sb.append(", invoiceDate=");
		sb.append(invoiceDate);
		sb.append(", itemValueInvoice=");
		sb.append(itemValueInvoice);
		sb.append(", itemValueYou=");
		sb.append(itemValueYou);
		sb.append(", claimValue=");
		sb.append(claimValue);
		sb.append(", detailClaim=");
		sb.append(detailClaim);
		sb.append(", querybox=");
		sb.append(querybox);
		sb.append(", scBox=");
		sb.append(scBox);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public support toEntityModel() {
		supportImpl supportImpl = new supportImpl();

		supportImpl.setSpportId(spportId);

		if (claim == null) {
			supportImpl.setClaim("");
		}
		else {
			supportImpl.setClaim(claim);
		}

		if (query == null) {
			supportImpl.setQuery("");
		}
		else {
			supportImpl.setQuery(query);
		}

		if (suggestioncomplaint == null) {
			supportImpl.setSuggestioncomplaint("");
		}
		else {
			supportImpl.setSuggestioncomplaint(suggestioncomplaint);
		}

		if (BU == null) {
			supportImpl.setBU("");
		}
		else {
			supportImpl.setBU(BU);
		}

		if (channel == null) {
			supportImpl.setChannel("");
		}
		else {
			supportImpl.setChannel(channel);
		}

		supportImpl.setInvoiceNumber(invoiceNumber);

		if (invoiceDate == Long.MIN_VALUE) {
			supportImpl.setInvoiceDate(null);
		}
		else {
			supportImpl.setInvoiceDate(new Date(invoiceDate));
		}

		supportImpl.setItemValueInvoice(itemValueInvoice);
		supportImpl.setItemValueYou(itemValueYou);
		supportImpl.setClaimValue(claimValue);

		if (detailClaim == null) {
			supportImpl.setDetailClaim("");
		}
		else {
			supportImpl.setDetailClaim(detailClaim);
		}

		if (querybox == null) {
			supportImpl.setQuerybox("");
		}
		else {
			supportImpl.setQuerybox(querybox);
		}

		if (scBox == null) {
			supportImpl.setScBox("");
		}
		else {
			supportImpl.setScBox(scBox);
		}

		supportImpl.resetOriginalValues();

		return supportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spportId = objectInput.readLong();
		claim = objectInput.readUTF();
		query = objectInput.readUTF();
		suggestioncomplaint = objectInput.readUTF();
		BU = objectInput.readUTF();
		channel = objectInput.readUTF();

		invoiceNumber = objectInput.readLong();
		invoiceDate = objectInput.readLong();

		itemValueInvoice = objectInput.readLong();

		itemValueYou = objectInput.readLong();

		claimValue = objectInput.readLong();
		detailClaim = objectInput.readUTF();
		querybox = objectInput.readUTF();
		scBox = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(spportId);

		if (claim == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claim);
		}

		if (query == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(query);
		}

		if (suggestioncomplaint == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(suggestioncomplaint);
		}

		if (BU == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(BU);
		}

		if (channel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(channel);
		}

		objectOutput.writeLong(invoiceNumber);
		objectOutput.writeLong(invoiceDate);

		objectOutput.writeLong(itemValueInvoice);

		objectOutput.writeLong(itemValueYou);

		objectOutput.writeLong(claimValue);

		if (detailClaim == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detailClaim);
		}

		if (querybox == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(querybox);
		}

		if (scBox == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(scBox);
		}
	}

	public long spportId;
	public String claim;
	public String query;
	public String suggestioncomplaint;

	public String BU;

	public String channel;
	public long invoiceNumber;
	public long invoiceDate;
	public long itemValueInvoice;
	public long itemValueYou;
	public long claimValue;
	public String detailClaim;
	public String querybox;
	public String scBox;

}