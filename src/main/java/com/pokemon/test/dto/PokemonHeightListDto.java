package com.pokemon.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonHeightListDto extends SimpleResult{

	private static final long serialVersionUID = 7016111477194334170L;

	private List<PokemonHeightDto> pokemonHeightDtoList = null;

}