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

package com.liferay.customer.support.service.persistence.impl;

import com.liferay.customer.support.exception.NoSuchsupportException;
import com.liferay.customer.support.model.impl.supportImpl;
import com.liferay.customer.support.model.impl.supportModelImpl;
import com.liferay.customer.support.model.support;
import com.liferay.customer.support.service.persistence.impl.constants.panasonicPersistenceConstants;
import com.liferay.customer.support.service.persistence.supportPersistence;
import com.liferay.customer.support.service.persistence.supportUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the support service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = supportPersistence.class)
public class supportPersistenceImpl
	extends BasePersistenceImpl<support> implements supportPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>supportUtil</code> to access the support persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		supportImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public supportPersistenceImpl() {
		setModelClass(support.class);

		setModelImplClass(supportImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the support in the entity cache if it is enabled.
	 *
	 * @param support the support
	 */
	@Override
	public void cacheResult(support support) {
		entityCache.putResult(
			supportImpl.class, support.getPrimaryKey(), support);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the supports in the entity cache if it is enabled.
	 *
	 * @param supports the supports
	 */
	@Override
	public void cacheResult(List<support> supports) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (supports.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (support support : supports) {
			if (entityCache.getResult(
					supportImpl.class, support.getPrimaryKey()) == null) {

				cacheResult(support);
			}
		}
	}

	/**
	 * Clears the cache for all supports.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(supportImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the support.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(support support) {
		entityCache.removeResult(supportImpl.class, support);
	}

	@Override
	public void clearCache(List<support> supports) {
		for (support support : supports) {
			entityCache.removeResult(supportImpl.class, support);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(supportImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new support with the primary key. Does not add the support to the database.
	 *
	 * @param spportId the primary key for the new support
	 * @return the new support
	 */
	@Override
	public support create(long spportId) {
		support support = new supportImpl();

		support.setNew(true);
		support.setPrimaryKey(spportId);

		return support;
	}

	/**
	 * Removes the support with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spportId the primary key of the support
	 * @return the support that was removed
	 * @throws NoSuchsupportException if a support with the primary key could not be found
	 */
	@Override
	public support remove(long spportId) throws NoSuchsupportException {
		return remove((Serializable)spportId);
	}

	/**
	 * Removes the support with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the support
	 * @return the support that was removed
	 * @throws NoSuchsupportException if a support with the primary key could not be found
	 */
	@Override
	public support remove(Serializable primaryKey)
		throws NoSuchsupportException {

		Session session = null;

		try {
			session = openSession();

			support support = (support)session.get(
				supportImpl.class, primaryKey);

			if (support == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchsupportException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(support);
		}
		catch (NoSuchsupportException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected support removeImpl(support support) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(support)) {
				support = (support)session.get(
					supportImpl.class, support.getPrimaryKeyObj());
			}

			if (support != null) {
				session.delete(support);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (support != null) {
			clearCache(support);
		}

		return support;
	}

	@Override
	public support updateImpl(support support) {
		boolean isNew = support.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(support);
			}
			else {
				support = (support)session.merge(support);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(supportImpl.class, support, false, true);

		if (isNew) {
			support.setNew(false);
		}

		support.resetOriginalValues();

		return support;
	}

	/**
	 * Returns the support with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the support
	 * @return the support
	 * @throws NoSuchsupportException if a support with the primary key could not be found
	 */
	@Override
	public support findByPrimaryKey(Serializable primaryKey)
		throws NoSuchsupportException {

		support support = fetchByPrimaryKey(primaryKey);

		if (support == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchsupportException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return support;
	}

	/**
	 * Returns the support with the primary key or throws a <code>NoSuchsupportException</code> if it could not be found.
	 *
	 * @param spportId the primary key of the support
	 * @return the support
	 * @throws NoSuchsupportException if a support with the primary key could not be found
	 */
	@Override
	public support findByPrimaryKey(long spportId)
		throws NoSuchsupportException {

		return findByPrimaryKey((Serializable)spportId);
	}

	/**
	 * Returns the support with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spportId the primary key of the support
	 * @return the support, or <code>null</code> if a support with the primary key could not be found
	 */
	@Override
	public support fetchByPrimaryKey(long spportId) {
		return fetchByPrimaryKey((Serializable)spportId);
	}

	/**
	 * Returns all the supports.
	 *
	 * @return the supports
	 */
	@Override
	public List<support> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the supports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>supportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of supports
	 * @param end the upper bound of the range of supports (not inclusive)
	 * @return the range of supports
	 */
	@Override
	public List<support> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the supports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>supportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of supports
	 * @param end the upper bound of the range of supports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of supports
	 */
	@Override
	public List<support> findAll(
		int start, int end, OrderByComparator<support> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the supports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>supportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of supports
	 * @param end the upper bound of the range of supports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of supports
	 */
	@Override
	public List<support> findAll(
		int start, int end, OrderByComparator<support> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<support> list = null;

		if (useFinderCache) {
			list = (List<support>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SUPPORT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SUPPORT;

				sql = sql.concat(supportModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<support>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the supports from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (support support : findAll()) {
			remove(support);
		}
	}

	/**
	 * Returns the number of supports.
	 *
	 * @return the number of supports
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SUPPORT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "spportId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUPPORT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return supportModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the support persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new supportModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", support.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setsupportUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setsupportUtilPersistence(null);

		entityCache.removeCache(supportImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setsupportUtilPersistence(
		supportPersistence supportPersistence) {

		try {
			Field field = supportUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, supportPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = panasonicPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = panasonicPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = panasonicPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SUPPORT =
		"SELECT support FROM support support";

	private static final String _SQL_COUNT_SUPPORT =
		"SELECT COUNT(support) FROM support support";

	private static final String _ORDER_BY_ENTITY_ALIAS = "support.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No support exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		supportPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class supportModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			supportModelImpl supportModelImpl = (supportModelImpl)baseModel;

			long columnBitmask = supportModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(supportModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						supportModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(supportPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(supportModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			supportModelImpl supportModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = supportModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = supportModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}