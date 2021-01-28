package com.pokemon.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PokemonBaseExperienceDto implements Serializable {

	private static final long serialVersionUID = 8147675703743147453L;

	private String name;
	private String baseExperience;
}
