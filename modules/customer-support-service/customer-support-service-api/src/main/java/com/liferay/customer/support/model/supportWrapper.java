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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link support}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see support
 * @generated
 */
public class supportWrapper
	extends BaseModelWrapper<support>
	implements ModelWrapper<support>, support {

	public supportWrapper(support support) {
		super(support);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spportId", getSpportId());
		attributes.put("claim", getClaim());
		attributes.put("query", getQuery());
		attributes.put("suggestioncomplaint", getSuggestioncomplaint());
		attributes.put("BU", getBU());
		attributes.put("channel", getChannel());
		attributes.put("invoiceNumber", getInvoiceNumber());
		attributes.put("invoiceDate", getInvoiceDate());
		attributes.put("itemValueInvoice", getItemValueInvoice());
		attributes.put("itemValueYou", getItemValueYou());
		attributes.put("claimValue", getClaimValue());
		attributes.put("detailClaim", getDetailClaim());
		attributes.put("querybox", getQuerybox());
		attributes.put("scBox", getScBox());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spportId = (Long)attributes.get("spportId");

		if (spportId != null) {
			setSpportId(spportId);
		}

		String claim = (String)attributes.get("claim");

		if (claim != null) {
			setClaim(claim);
		}

		String query = (String)attributes.get("query");

		if (query != null) {
			setQuery(query);
		}

		String suggestioncomplaint = (String)attributes.get(
			"suggestioncomplaint");

		if (suggestioncomplaint != null) {
			setSuggestioncomplaint(suggestioncomplaint);
		}

		String BU = (String)attributes.get("BU");

		if (BU != null) {
			setBU(BU);
		}

		String channel = (String)attributes.get("channel");

		if (channel != null) {
			setChannel(channel);
		}

		Long invoiceNumber = (Long)attributes.get("invoiceNumber");

		if (invoiceNumber != null) {
			setInvoiceNumber(invoiceNumber);
		}

		Date invoiceDate = (Date)attributes.get("invoiceDate");

		if (invoiceDate != null) {
			setInvoiceDate(invoiceDate);
		}

		Long itemValueInvoice = (Long)attributes.get("itemValueInvoice");

		if (itemValueInvoice != null) {
			setItemValueInvoice(itemValueInvoice);
		}

		Long itemValueYou = (Long)attributes.get("itemValueYou");

		if (itemValueYou != null) {
			setItemValueYou(itemValueYou);
		}

		Long claimValue = (Long)attributes.get("claimValue");

		if (claimValue != null) {
			setClaimValue(claimValue);
		}

		String detailClaim = (String)attributes.get("detailClaim");

		if (detailClaim != null) {
			setDetailClaim(detailClaim);
		}

		String querybox = (String)attributes.get("querybox");

		if (querybox != null) {
			setQuerybox(querybox);
		}

		String scBox = (String)attributes.get("scBox");

		if (scBox != null) {
			setScBox(scBox);
		}
	}

	/**
	 * Returns the bu of this support.
	 *
	 * @return the bu of this support
	 */
	@Override
	public String getBU() {
		return model.getBU();
	}

	/**
	 * Returns the channel of this support.
	 *
	 * @return the channel of this support
	 */
	@Override
	public String getChannel() {
		return model.getChannel();
	}

	/**
	 * Returns the claim of this support.
	 *
	 * @return the claim of this support
	 */
	@Override
	public String getClaim() {
		return model.getClaim();
	}

	/**
	 * Returns the claim value of this support.
	 *
	 * @return the claim value of this support
	 */
	@Override
	public long getClaimValue() {
		return model.getClaimValue();
	}

	/**
	 * Returns the detail claim of this support.
	 *
	 * @return the detail claim of this support
	 */
	@Override
	public String getDetailClaim() {
		return model.getDetailClaim();
	}

	/**
	 * Returns the invoice date of this support.
	 *
	 * @return the invoice date of this support
	 */
	@Override
	public Date getInvoiceDate() {
		return model.getInvoiceDate();
	}

	/**
	 * Returns the invoice number of this support.
	 *
	 * @return the invoice number of this support
	 */
	@Override
	public long getInvoiceNumber() {
		return model.getInvoiceNumber();
	}

	/**
	 * Returns the item value invoice of this support.
	 *
	 * @return the item value invoice of this support
	 */
	@Override
	public long getItemValueInvoice() {
		return model.getItemValueInvoice();
	}

	/**
	 * Returns the item value you of this support.
	 *
	 * @return the item value you of this support
	 */
	@Override
	public long getItemValueYou() {
		return model.getItemValueYou();
	}

	/**
	 * Returns the primary key of this support.
	 *
	 * @return the primary key of this support
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the query of this support.
	 *
	 * @return the query of this support
	 */
	@Override
	public String getQuery() {
		return model.getQuery();
	}

	/**
	 * Returns the querybox of this support.
	 *
	 * @return the querybox of this support
	 */
	@Override
	public String getQuerybox() {
		return model.getQuerybox();
	}

	/**
	 * Returns the sc box of this support.
	 *
	 * @return the sc box of this support
	 */
	@Override
	public String getScBox() {
		return model.getScBox();
	}

	/**
	 * Returns the spport ID of this support.
	 *
	 * @return the spport ID of this support
	 */
	@Override
	public long getSpportId() {
		return model.getSpportId();
	}

	/**
	 * Returns the suggestioncomplaint of this support.
	 *
	 * @return the suggestioncomplaint of this support
	 */
	@Override
	public String getSuggestioncomplaint() {
		return model.getSuggestioncomplaint();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bu of this support.
	 *
	 * @param BU the bu of this support
	 */
	@Override
	public void setBU(String BU) {
		model.setBU(BU);
	}

	/**
	 * Sets the channel of this support.
	 *
	 * @param channel the channel of this support
	 */
	@Override
	public void setChannel(String channel) {
		model.setChannel(channel);
	}

	/**
	 * Sets the claim of this support.
	 *
	 * @param claim the claim of this support
	 */
	@Override
	public void setClaim(String claim) {
		model.setClaim(claim);
	}

	/**
	 * Sets the claim value of this support.
	 *
	 * @param claimValue the claim value of this support
	 */
	@Override
	public void setClaimValue(long claimValue) {
		model.setClaimValue(claimValue);
	}

	/**
	 * Sets the detail claim of this support.
	 *
	 * @param detailClaim the detail claim of this support
	 */
	@Override
	public void setDetailClaim(String detailClaim) {
		model.setDetailClaim(detailClaim);
	}

	/**
	 * Sets the invoice date of this support.
	 *
	 * @param invoiceDate the invoice date of this support
	 */
	@Override
	public void setInvoiceDate(Date invoiceDate) {
		model.setInvoiceDate(invoiceDate);
	}

	/**
	 * Sets the invoice number of this support.
	 *
	 * @param invoiceNumber the invoice number of this support
	 */
	@Override
	public void setInvoiceNumber(long invoiceNumber) {
		model.setInvoiceNumber(invoiceNumber);
	}

	/**
	 * Sets the item value invoice of this support.
	 *
	 * @param itemValueInvoice the item value invoice of this support
	 */
	@Override
	public void setItemValueInvoice(long itemValueInvoice) {
		model.setItemValueInvoice(itemValueInvoice);
	}

	/**
	 * Sets the item value you of this support.
	 *
	 * @param itemValueYou the item value you of this support
	 */
	@Override
	public void setItemValueYou(long itemValueYou) {
		model.setItemValueYou(itemValueYou);
	}

	/**
	 * Sets the primary key of this support.
	 *
	 * @param primaryKey the primary key of this support
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the query of this support.
	 *
	 * @param query the query of this support
	 */
	@Override
	public void setQuery(String query) {
		model.setQuery(query);
	}

	/**
	 * Sets the querybox of this support.
	 *
	 * @param querybox the querybox of this support
	 */
	@Override
	public void setQuerybox(String querybox) {
		model.setQuerybox(querybox);
	}

	/**
	 * Sets the sc box of this support.
	 *
	 * @param scBox the sc box of this support
	 */
	@Override
	public void setScBox(String scBox) {
		model.setScBox(scBox);
	}

	/**
	 * Sets the spport ID of this support.
	 *
	 * @param spportId the spport ID of this support
	 */
	@Override
	public void setSpportId(long spportId) {
		model.setSpportId(spportId);
	}

	/**
	 * Sets the suggestioncomplaint of this support.
	 *
	 * @param suggestioncomplaint the suggestioncomplaint of this support
	 */
	@Override
	public void setSuggestioncomplaint(String suggestioncomplaint) {
		model.setSuggestioncomplaint(suggestioncomplaint);
	}

	@Override
	protected supportWrapper wrap(support support) {
		return new supportWrapper(support);
	}

}