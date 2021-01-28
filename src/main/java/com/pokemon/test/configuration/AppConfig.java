package com.pokemon.test.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@ComponentScan(basePackages = "com.pokemon.test")
@EnableCaching
@EnableScheduling
public class AppConfig {

	private final Environment environment;

	public AppConfig(Environment environment) {
		this.environment = environment;
	}

	@Bean(name = "springCM")
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
