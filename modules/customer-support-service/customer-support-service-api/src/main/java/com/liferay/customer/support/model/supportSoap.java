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

package com.liferay.customer.support.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.customer.support.service.http.supportServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class supportSoap implements Serializable {

	public static supportSoap toSoapModel(support model) {
		supportSoap soapModel = new supportSoap();

		soapModel.setSpportId(model.getSpportId());
		soapModel.setClaim(model.getClaim());
		soapModel.setQuery(model.getQuery());
		soapModel.setSuggestioncomplaint(model.getSuggestioncomplaint());
		soapModel.setBU(model.getBU());
		soapModel.setChannel(model.getChannel());
		soapModel.setInvoiceNumber(model.getInvoiceNumber());
		soapModel.setInvoiceDate(model.getInvoiceDate());
		soapModel.setItemValueInvoice(model.getItemValueInvoice());
		soapModel.setItemValueYou(model.getItemValueYou());
		soapModel.setClaimValue(model.getClaimValue());
		soapModel.setDetailClaim(model.getDetailClaim());
		soapModel.setQuerybox(model.getQuerybox());
		soapModel.setScBox(model.getScBox());

		return soapModel;
	}

	public static supportSoap[] toSoapModels(support[] models) {
		supportSoap[] soapModels = new supportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static supportSoap[][] toSoapModels(support[][] models) {
		supportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new supportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new supportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static supportSoap[] toSoapModels(List<support> models) {
		List<supportSoap> soapModels = new ArrayList<supportSoap>(
			models.size());

		for (support model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new supportSoap[soapModels.size()]);
	}

	public supportSoap() {
	}

	public long getPrimaryKey() {
		return _spportId;
	}

	public void setPrimaryKey(long pk) {
		setSpportId(pk);
	}

	public long getSpportId() {
		return _spportId;
	}

	public void setSpportId(long spportId) {
		_spportId = spportId;
	}

	public String getClaim() {
		return _claim;
	}

	public void setClaim(String claim) {
		_claim = claim;
	}

	public String getQuery() {
		return _query;
	}

	public void setQuery(String query) {
		_query = query;
	}

	public String getSuggestioncomplaint() {
		return _suggestioncomplaint;
	}

	public void setSuggestioncomplaint(String suggestioncomplaint) {
		_suggestioncomplaint = suggestioncomplaint;
	}

	public String getBU() {
		return _BU;
	}

	public void setBU(String BU) {
		_BU = BU;
	}

	public String getChannel() {
		return _channel;
	}

	public void setChannel(String channel) {
		_channel = channel;
	}

	public long getInvoiceNumber() {
		return _invoiceNumber;
	}

	public void setInvoiceNumber(long invoiceNumber) {
		_invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return _invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		_invoiceDate = invoiceDate;
	}

	public long getItemValueInvoice() {
		return _itemValueInvoice;
	}

	public void setItemValueInvoice(long itemValueInvoice) {
		_itemValueInvoice = itemValueInvoice;
	}

	public long getItemValueYou() {
		return _itemValueYou;
	}

	public void setItemValueYou(long itemValueYou) {
		_itemValueYou = itemValueYou;
	}

	public long getClaimValue() {
		return _claimValue;
	}

	public void setClaimValue(long claimValue) {
		_claimValue = claimValue;
	}

	public String getDetailClaim() {
		return _detailClaim;
	}

	public void setDetailClaim(String detailClaim) {
		_detailClaim = detailClaim;
	}

	public String getQuerybox() {
		return _querybox;
	}

	public void setQuerybox(String querybox) {
		_querybox = querybox;
	}

	public String getScBox() {
		return _scBox;
	}

	public void setScBox(String scBox) {
		_scBox = scBox;
	}

	private long _spportId;
	private String _claim;
	private String _query;
	private String _suggestioncomplaint;

	private String _BU;

	private String _channel;
	private long _invoiceNumber;
	private Date _invoiceDate;
	private long _itemValueInvoice;
	private long _itemValueYou;
	private long _claimValue;
	private String _detailClaim;
	private String _querybox;
	private String _scBox;

}