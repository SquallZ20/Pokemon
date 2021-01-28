package com.pokemon.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"id",
		"name",
		"names",
		"pokemon_species"
})
@Getter
@Setter
public class PokemonRedDto {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("names")
	private List<Name> names = null;
	@JsonProperty("pokemon_species")
	private List<PokemonSpecy> pokemonSpecies = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name).append("names", names).append("pokemonSpecies", pokemonSpecies).append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(id).append(names).append(additionalProperties).append(pokemonSpecies).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof PokemonRedDto) == false) {
			return false;
		}
		PokemonRedDto rhs = ((PokemonRedDto) other);
		return new EqualsBuilder().append(name, rhs.name).append(id, rhs.id).append(names, rhs.names).append(additionalProperties, rhs.additionalProperties).append(pokemonSpecies, rhs.pokemonSpecies).isEquals();
	}

}
