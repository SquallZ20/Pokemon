package com.pokemon.test.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.pokemon.test.configuration"})
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {

	private final Environment environment;
	@Value("${database.url}")
	private String url;
	@Value("${database.driver}")
	private String driver;
	@Value("${database.user}")
	private String user;
	@Value("${database.password}")
	private String password;

	public HibernateConfiguration(Environment environment) {
		this.environment = environment;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.pokemon.test.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(url);
		dataSourceBuilder.driverClassName(driver);
		dataSourceBuilder.username(user);
		dataSourceBuilder.password(password);
		return dataSourceBuilder.build();
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.globally_quoted_identifiers", environment.getRequiredProperty("hibernate.globally_quoted_identifiers"));
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.cache.use_second_level_cache", environment.getRequiredProperty("hibernate.cache.use_second_level_cache"));
		properties.put("hibernate.cache.region.factory_class", environment.getRequiredProperty("hibernate.cache.region.factory_class"));
		properties.put("hibernate.cache.use_query_cache", environment.getRequiredProperty("hibernate.cache.use_query_cache"));
		properties.put("hibernate.generate_statistics", environment.getRequiredProperty("hibernate.generate_statistics"));
		properties.put("org.hibernate.cache.ehcache.configurationResourceName", environment.getRequiredProperty("org.hibernate.cache.ehcache.configurationResourceName"));
		return properties;
	}
}