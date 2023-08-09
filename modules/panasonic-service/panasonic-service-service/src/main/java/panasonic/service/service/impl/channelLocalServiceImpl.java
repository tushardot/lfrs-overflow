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

package panasonic.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import panasonic.service.exception.NoSuchchannelException;
import panasonic.service.model.channel;
import panasonic.service.service.base.channelLocalServiceBaseImpl;
import panasonic.service.service.persistence.channelPersistence;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=panasonic.service.model.channel",
	service = AopService.class
)
public class channelLocalServiceImpl extends channelLocalServiceBaseImpl {

	@Override
	public channel getuserbyemail(String email) {
		// TODO Auto-generated method stub
		
		return null;
	}
	public channel getbyemail(String email) throws NoSuchchannelException {
		return channelPersistence.findByemail(email);
	}
	
	
}