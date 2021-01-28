package com.pokemon.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonWeightListDto extends SimpleResult {

	private List<PokemonWeightDto> pokemonWeightDtoList = null;
}
