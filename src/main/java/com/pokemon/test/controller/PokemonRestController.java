package com.pokemon.test.controller;

import com.pokemon.test.dto.Common;
import com.pokemon.test.dto.PokemonBaseExperienceDto;
import com.pokemon.test.dto.PokemonBaseExperieneListDto;
import com.pokemon.test.dto.PokemonHeightDto;
import com.pokemon.test.dto.PokemonHeightListDto;
import com.pokemon.test.dto.PokemonRedDto;
import com.pokemon.test.dto.PokemonWeightDto;
import com.pokemon.test.dto.PokemonWeightListDto;
import com.pokemon.test.dto.SimpleResult;
import com.pokemon.test.model.PokemonEntity;
import com.pokemon.test.service.PokemonsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(AbstractRestController.URI_REST)
public class PokemonRestController extends AbstractRestController {

	private final PokemonsService pokemonsService;

	public PokemonRestController(PokemonsService pokemonsService) {
		this.pokemonsService = pokemonsService;
	}

	@GetMapping("/getPokemons")
	public ResponseEntity<SimpleResult> getPokemons() {
		SimpleResult simpleResult = new SimpleResult();
		try {
			logger.info("Get Pokemons Red");
			PokemonRedDto pokemonRedDto = pokemonsService.getPokemonsRed();
			pokemonsService.CreatePokemonData(pokemonRedDto);
			simpleResult.setCommon(new Common(Common.ACK_OK));
			simpleResult.setMessage("Pokemons Found");
			return new ResponseEntity<>(simpleResult, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			logger.error("Error on calling Get Pokemons Red");
			simpleResult.setCommon(new Common(Common.ACK_KO, it.thinkopen.milanoteleport.modemmonitor.enumeration.ErrorCode.GENERIC_ERROR));
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getPokemonsHighest")
	public ResponseEntity<PokemonHeightListDto> getPokemonsHighest() {
		PokemonHeightListDto pokemonHeightListDto = new PokemonHeightListDto();
		List<PokemonHeightDto> pokemonHeightDtoList = new ArrayList<>();
		List<PokemonEntity> pokemonEntityList = new ArrayList<>();
		try {
			logger.info("Get Pokemons");
			pokemonEntityList = pokemonsService.getTopHighest();
			for (PokemonEntity pokemonEntity:pokemonEntityList
			     ) {
				PokemonHeightDto pokemonHeightDto = new PokemonHeightDto();
				pokemonHeightDto.setName(pokemonEntity.getName());
				pokemonHeightDto.setHeight(String.valueOf(pokemonEntity.getHeight()));
				pokemonHeightDtoList.add(pokemonHeightDto);
			}
			pokemonHeightListDto.setPokemonHeightDtoList(pokemonHeightDtoList);
			pokemonHeightListDto.setCommon(new Common(Common.ACK_OK));
			pokemonHeightListDto.setMessage("Modem Found");
			return new ResponseEntity<>(pokemonHeightListDto, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			logger.error("Error on calling Get Pokemons");
			pokemonHeightListDto.setCommon(new Common(Common.ACK_KO, it.thinkopen.milanoteleport.modemmonitor.enumeration.ErrorCode.GENERIC_ERROR));
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getPokemonsBaseExperience")
	public ResponseEntity<PokemonBaseExperieneListDto> getPokemonsBaseExperience() {
		PokemonBaseExperieneListDto pokemonBaseExperieneListDto = new PokemonBaseExperieneListDto();
		List<PokemonBaseExperienceDto> baseExperienceDtoList = new ArrayList<>();
		List<PokemonEntity> pokemonEntityList = new ArrayList<>();
		try {
			logger.info("Get Pokemons");
			pokemonEntityList = pokemonsService.getTopHeaviest();
			for (PokemonEntity pokemonEntity:pokemonEntityList
			) {
				PokemonBaseExperienceDto pokemonBaseExperienceDto = new PokemonBaseExperienceDto();
				pokemonBaseExperienceDto.setName(pokemonEntity.getName());
				pokemonBaseExperienceDto.setBaseExperience(String.valueOf(pokemonEntity.getBaseExperience()));
				baseExperienceDtoList.add(pokemonBaseExperienceDto);
			}
			pokemonBaseExperieneListDto.setPokemonBaseExperienceDtoList(baseExperienceDtoList);
			pokemonBaseExperieneListDto.setCommon(new Common(Common.ACK_OK));
			pokemonBaseExperieneListDto.setMessage("Modem Found");
			return new ResponseEntity<>(pokemonBaseExperieneListDto, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			logger.error("Error on calling Get Pokemons");
			pokemonBaseExperieneListDto.setCommon(new Common(Common.ACK_KO, it.thinkopen.milanoteleport.modemmonitor.enumeration.ErrorCode.GENERIC_ERROR));
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getPokemonsHeaviest")
	public ResponseEntity<PokemonWeightListDto> getPokemonsWeight() {
		PokemonWeightListDto pokemonWeightListDto  = new PokemonWeightListDto();
		List<PokemonWeightDto> weightDtoList = new ArrayList<>();
		List<PokemonEntity> pokemonEntityList = new ArrayList<>();
		try {
			logger.info("Get Pokemons");
			pokemonEntityList = pokemonsService.getTopHeaviest();
			for (PokemonEntity pokemonEntity:pokemonEntityList
			) {
				PokemonWeightDto pokemonWeightDto = new PokemonWeightDto();
				pokemonWeightDto.setName(pokemonEntity.getName());
				pokemonWeightDto.setWeight(String.valueOf(pokemonEntity.getWeight()));
				weightDtoList.add(pokemonWeightDto);
			}
			pokemonWeightListDto.setPokemonWeightDtoList(weightDtoList);
			pokemonWeightListDto.setCommon(new Common(Common.ACK_OK));
			pokemonWeightListDto.setMessage("Modem Found");
			return new ResponseEntity<>(pokemonWeightListDto, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			logger.error("Error on calling Get Pokemons");
			pokemonWeightListDto.setCommon(new Common(Common.ACK_KO, it.thinkopen.milanoteleport.modemmonitor.enumeration.ErrorCode.GENERIC_ERROR));
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
