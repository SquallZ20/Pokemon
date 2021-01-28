package com.pokemon.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PokemonWeightDto implements Serializable {

	private static final long serialVersionUID = 8386673980286304063L;

	private String name;
	private String weight;
}
