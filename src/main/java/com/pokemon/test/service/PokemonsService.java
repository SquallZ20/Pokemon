package com.pokemon.test.service;

import com.pokemon.test.dao.PokemonDao;
import com.pokemon.test.dto.PokemonRedDto;
import com.pokemon.test.dto.PokemonSpecy;
import com.pokemon.test.model.PokemonEntity;
import com.pokemon.test.util.Constants;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("PokemonsRedService")
@Transactional
public class PokemonsService extends AbstractService {

	private final ApiService apiService;
	private final PokemonDao pokemonDao;

	public PokemonsService(ApiService apiService, PokemonDao pokemonDao) {
		this.apiService = apiService;
		this.pokemonDao = pokemonDao;
	}

	public PokemonRedDto getPokemonsRed() {
		RestTemplate restTemplate = apiService.getRestTemplate();
		String resourceUrl = apiService.getPokemonsRedUrl();
		ResponseEntity<PokemonRedDto> responseEntity = restTemplate.getForEntity(resourceUrl, PokemonRedDto.class);
		return responseEntity.getBody();
	}

	public String getPokemonsValue(Integer pokemonId) {
		RestTemplate restTemplate = apiService.getRestTemplate();
		String resourceUrl = apiService.getPokemonsValueUrl().replace(Constants.PROPERTY_POKEMON_URL, String.valueOf(pokemonId));
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(resourceUrl, String.class);
		return responseEntity.getBody();
	}

	public void CreatePokemonData(PokemonRedDto pokemonRedDto) {
		try {
			List<PokemonSpecy> pokemonSpecyList = pokemonRedDto.getPokemonSpecies();
			for (PokemonSpecy pokemonSpecy : pokemonSpecyList
			) {
				PokemonEntity pokemonEntity = new PokemonEntity();
				pokemonEntity.setName(pokemonSpecy.getName());
				String deleteUrl = pokemonSpecy.getUrl().replace(Constants.DELETE_STRING, "");
				Integer pokemonId = Integer.valueOf(deleteUrl.replace("/", ""));
				pokemonEntity.setPokemonId(pokemonId);
				String jsonObject = getPokemonsValue(pokemonEntity.getPokemoId());
				JSONParser parser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
				JSONObject json = (JSONObject) parser.parse(jsonObject);
				int weight = Integer.valueOf(json.get("weight").toString());
				int height = Integer.valueOf(json.get("height").toString());
				int baseExperience = Integer.valueOf(json.get("base_experience").toString());
				pokemonEntity.setWeight(weight);
				pokemonEntity.setHeight(height);
				pokemonEntity.setBaseExperience(baseExperience);
				PokemonEntity exist = pokemonDao.findByPokemonId(pokemonId);
				if (exist == null) {
					pokemonDao.persist(pokemonEntity);
				}
			}
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
	}

	public List<PokemonEntity> getTopHeaviest() {
		return pokemonDao.getTopHeaviest();
	}

	public List<PokemonEntity> getTopBaseExperince() {
		return pokemonDao.getTopBaseExperince();
	}

	public List<PokemonEntity> getTopHighest() {
		return pokemonDao.getTopHighest();
	}
}

