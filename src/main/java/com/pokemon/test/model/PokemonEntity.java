package com.pokemon.test.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "pokemon", schema = "pokemon", catalog = "")
public class PokemonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "name", nullable = true, length = 255)
	private String name;
	@Column(name = "height", nullable = true)
	private Integer height;
	@Column(name = "weight", nullable = true)
	private Integer weight;
	@Column(name = "base_experience", nullable = true)
	private Integer baseExperience;
	@Column(name = "pokemon_id", nullable = true)
	private int pokemonId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	@Basic
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Basic
	public Integer getBaseExperience() {
		return baseExperience;
	}

	public void setBaseExperience(Integer baseExperience) {
		this.baseExperience = baseExperience;
	}

	@Basic
	public int getPokemoId() {
		return pokemonId;
	}

	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PokemonEntity that = (PokemonEntity) o;
		return id == that.id &&
				Objects.equals(name, that.name) &&
				Objects.equals(height, that.height) &&
				Objects.equals(weight, that.weight) &&
				Objects.equals(baseExperience, that.baseExperience) &&
				Objects.equals(pokemonId, that.pokemonId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, height, weight, baseExperience, pokemonId);
	}
}
