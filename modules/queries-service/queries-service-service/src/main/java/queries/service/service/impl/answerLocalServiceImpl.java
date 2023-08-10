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

package queries.service.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import queries.service.model.answer;
import queries.service.service.base.answerLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=queries.service.model.answer",
	service = AopService.class
)
public class answerLocalServiceImpl extends answerLocalServiceBaseImpl {
	
	
	public List<answer> getansbyuser(String username){
		return answerPersistence.findByuserName(username);
	}
	
	public List<answer> getansbyquesid(long id){
		return answerPersistence.findByquesId(id);
	}
}