package com.pokemon.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PokemonHeightDto implements Serializable {

	private static final long serialVersionUID = -7773813785483107509L;

	private String name;
	private String height;
}
