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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link supportService}.
 *
 * @author Brian Wing Shun Chan
 * @see supportService
 * @generated
 */
public class supportServiceWrapper
	implements ServiceWrapper<supportService>, supportService {

	public supportServiceWrapper(supportService supportService) {
		_supportService = supportService;
	}

	@Override
	public com.liferay.customer.support.model.support createsupport1(
		String claim, String query, String suggestioncomplaint, String BU,
		String channel, long invoiceNumber, java.util.Date invoiceDate,
		long itemvalueinvoice, long itemvalueyou, long claimvalue,
		String detailclaim, String querybox, String scbox) {

		return _supportService.createsupport1(
			claim, query, suggestioncomplaint, BU, channel, invoiceNumber,
			invoiceDate, itemvalueinvoice, itemvalueyou, claimvalue,
			detailclaim, querybox, scbox);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _supportService.getOSGiServiceIdentifier();
	}

	@Override
	public supportService getWrappedService() {
		return _supportService;
	}

	@Override
	public void setWrappedService(supportService supportService) {
		_supportService = supportService;
	}

	private supportService _supportService;

}