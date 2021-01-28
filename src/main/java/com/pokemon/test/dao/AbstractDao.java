package com.pokemon.test.dao;

import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unused")
public abstract class AbstractDao<P extends Serializable, T> {

	private final Class<T> persistentClass;
	protected Logger logger = org.apache.logging.log4j.LogManager.getLogger();
	@Autowired
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	protected AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public T getByKey(P key) {
		return getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public T merge(T entity) {
		return (T) getSession().merge(entity);
	}

	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void delete(List<T> list) {
		list.forEach(this::delete);
	}

	protected CriteriaBuilder createEntityCriteriaBuilder() {
		return getSession().getCriteriaBuilder();
	}

	public void flush() {
		getSession().flush();
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public List<T> findAll() {
		QueryHelper q = getQueryHelper();
		CriteriaQuery<T> c = q.getCriteriaQuery().select(q.getRoot());
		Query<T> query = getSession().createQuery(c);
		return query.list();
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	protected QueryHelper getQueryHelper() {
		CriteriaBuilder criteriaBuilder = createEntityCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
		Root<T> root = criteriaQuery.from(this.persistentClass);
		return new QueryHelper(criteriaBuilder, criteriaQuery, root);
	}
}