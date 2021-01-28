package com.pokemon.test.controller;

import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(AbstractRestController.URI_REST)
public abstract class AbstractRestController {
	protected static final String URI_REST = "/rest";
	protected Logger logger = org.apache.logging.log4j.LogManager.getLogger();
}