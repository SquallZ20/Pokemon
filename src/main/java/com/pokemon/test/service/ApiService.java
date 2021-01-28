package com.pokemon.test.service;

import org.springframework.core.env.Environment;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service("ApiService")
@Transactional
public class ApiService extends AbstractService {

	private final Environment environment;

	public ApiService(Environment environment) {
		this.environment = environment;
	}

	public String getPokemonsRedUrl() {
		return environment.getProperty("pokemon.red.url");
	}

	public String getPokemonsValueUrl() {
		return environment.getProperty("pokemon.values.url");
	}

	public RestTemplate getRestTemplate() {
		ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
		RestTemplate restTemplate = new RestTemplate(factory);
		restTemplate.getInterceptors();
		return restTemplate;
	}
}