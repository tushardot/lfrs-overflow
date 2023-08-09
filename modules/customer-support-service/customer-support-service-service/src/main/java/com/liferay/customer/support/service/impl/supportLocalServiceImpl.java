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

package com.liferay.customer.support.service.impl;

import com.liferay.customer.support.model.support;
import com.liferay.customer.support.service.supportLocalServiceUtil;
import com.liferay.customer.support.service.base.supportLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.customer.support.model.support",
	service = AopService.class
)
public class supportLocalServiceImpl extends supportLocalServiceBaseImpl {
	
	
	
	public support createsupportinfo(String claim, String query, String suggestioncomplaint, String BU, String channel,
			long invoiceNumber, Date invoiceDate, long itemvalueinvoice, long itemvalueyou , long claimvalue, String detailclaim, String querybox,
			String scbox) {
		     long spportId=System.currentTimeMillis();
		     support cs = supportLocalServiceUtil.createsupport(spportId);
		     cs.setClaim(claim);
		     cs.setQuery(query);
		     cs.setSuggestioncomplaint(suggestioncomplaint);
		     cs.setBU(BU);
		     cs.setChannel(channel);
		     cs.setInvoiceNumber(invoiceNumber);
		     cs.setInvoiceDate(invoiceDate);
		     cs.setItemValueInvoice(itemvalueinvoice);
		     cs.setItemValueYou(itemvalueyou);
		     cs.setClaimValue(claimvalue);
		     cs.setDetailClaim(detailclaim);
		     cs.setQuerybox(querybox);
		     cs.setScBox(scbox);
		    System.out.println("Data stored successfully....");
			return supportLocalServiceUtil.addsupport(cs);
		
	}
}