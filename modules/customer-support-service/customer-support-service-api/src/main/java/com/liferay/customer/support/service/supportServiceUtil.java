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

package com.liferay.customer.support.service;

import com.liferay.customer.support.model.support;

/**
 * Provides the remote service utility for support. This utility wraps
 * <code>com.liferay.customer.support.service.impl.supportServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see supportService
 * @generated
 */
public class supportServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.customer.support.service.impl.supportServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static support createsupport1(
		String claim, String query, String suggestioncomplaint, String BU,
		String channel, long invoiceNumber, java.util.Date invoiceDate,
		long itemvalueinvoice, long itemvalueyou, long claimvalue,
		String detailclaim, String querybox, String scbox) {

		return getService().createsupport1(
			claim, query, suggestioncomplaint, BU, channel, invoiceNumber,
			invoiceDate, itemvalueinvoice, itemvalueyou, claimvalue,
			detailclaim, querybox, scbox);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static supportService getService() {
		return _service;
	}

	private static volatile supportService _service;

}