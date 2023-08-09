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
import com.liferay.customer.support.service.base.supportServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=panasonic",
		"json.web.service.context.path=support"
	},
	service = AopService.class
)
public class supportServiceImpl extends supportServiceBaseImpl {
	
	public support createsupport1(String claim, String query, String suggestioncomplaint, String BU, String channel,
			long invoiceNumber, Date invoiceDate, long itemvalueinvoice, long itemvalueyou , long claimvalue, String detailclaim, String querybox,
			String scbox) {
		return supportLocalServiceUtil.createsupportinfo(claim, query, suggestioncomplaint, BU, channel, invoiceNumber, invoiceDate, itemvalueinvoice, itemvalueyou, claimvalue, detailclaim, querybox, scbox);
	}
}