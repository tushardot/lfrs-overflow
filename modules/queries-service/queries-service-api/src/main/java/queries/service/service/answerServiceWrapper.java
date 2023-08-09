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

package queries.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link answerService}.
 *
 * @author Brian Wing Shun Chan
 * @see answerService
 * @generated
 */
public class answerServiceWrapper
	implements answerService, ServiceWrapper<answerService> {

	public answerServiceWrapper(answerService answerService) {
		_answerService = answerService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _answerService.getOSGiServiceIdentifier();
	}

	@Override
	public answerService getWrappedService() {
		return _answerService;
	}

	@Override
	public void setWrappedService(answerService answerService) {
		_answerService = answerService;
	}

	private answerService _answerService;

}