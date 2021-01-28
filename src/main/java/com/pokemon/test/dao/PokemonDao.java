package com.pokemon.test.dao;

import com.pokemon.test.model.PokemonEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.List;

import static com.pokemon.test.util.Constants.WEIGHT;
import static com.pokemon.test.util.Constants.POKEMON_ID;
import static com.pokemon.test.util.Constants.HEIGHT;
import static com.pokemon.test.util.Constants.BASE_EXPERIENCE;
import static com.pokemon.test.util.Constants.MAX_RESULTS_ACCEPTED;

@Repository("PokemonDao")
public class PokemonDao extends AbstractDao<Integer, PokemonEntity> {

	public PokemonEntity findByPokemonId(Integer pokemonId) {
		QueryHelper<PokemonEntity> q = getQueryHelper();
		Predicate[] predicates = new Predicate[1];
		predicates[0] = q.getCriteriaBuilder().equal(q.getRoot().get(POKEMON_ID), pokemonId);
		CriteriaQuery<PokemonEntity> c = q.getCriteriaQuery().select(q.getRoot()).where(predicates);
		return getSession().createQuery(c).uniqueResult();
	}

	public List<PokemonEntity> getTopHeaviest() {
		QueryHelper<PokemonEntity> q = getQueryHelper();
		CriteriaQuery<PokemonEntity> c = q.getCriteriaQuery().select(q.getRoot()).orderBy(q.getCriteriaBuilder().desc(q.getRoot().get(WEIGHT)));
		Query<PokemonEntity> query = getSession().createQuery(c).setMaxResults(Integer.valueOf(MAX_RESULTS_ACCEPTED));
		return query.getResultList();
	}

	public List<PokemonEntity> getTopBaseExperince() {
		QueryHelper<PokemonEntity> q = getQueryHelper();
		CriteriaQuery<PokemonEntity> c = q.getCriteriaQuery().select(q.getRoot()).orderBy(q.getCriteriaBuilder().desc(q.getRoot().get(BASE_EXPERIENCE)));
		Query<PokemonEntity> query = getSession().createQuery(c).setMaxResults(Integer.valueOf(MAX_RESULTS_ACCEPTED));
		return query.getResultList();
	}

	public List<PokemonEntity> getTopHighest() {
		QueryHelper<PokemonEntity> q = getQueryHelper();
		CriteriaQuery<PokemonEntity> c = q.getCriteriaQuery().select(q.getRoot()).orderBy(q.getCriteriaBuilder().desc(q.getRoot().get(HEIGHT)));
		Query<PokemonEntity> query = getSession().createQuery(c).setMaxResults(Integer.valueOf(MAX_RESULTS_ACCEPTED));
		return query.getResultList();
	}
}
