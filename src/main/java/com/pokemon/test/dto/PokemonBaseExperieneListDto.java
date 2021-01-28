package com.pokemon.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonBaseExperieneListDto extends SimpleResult {

	private List<PokemonBaseExperienceDto> pokemonBaseExperienceDtoList = null;
}
