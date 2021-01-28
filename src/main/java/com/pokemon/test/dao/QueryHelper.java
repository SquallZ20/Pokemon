package com.pokemon.test.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public final class QueryHelper<T> {

	private final CriteriaBuilder criteriaBuilder;
	private final CriteriaQuery<T> criteriaQuery;
	private final Root<T> root;

	public QueryHelper(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery, Root<T> root) {
		this.criteriaBuilder = criteriaBuilder;
		this.criteriaQuery = criteriaQuery;
		this.root = root;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaBuilder;
	}

	public CriteriaQuery<T> getCriteriaQuery() {
		return criteriaQuery;
	}

	public Root<T> getRoot() {
		return root;
	}
}