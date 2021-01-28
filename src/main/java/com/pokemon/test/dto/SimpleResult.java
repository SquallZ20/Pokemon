package com.pokemon.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SimpleResult implements Serializable {

	private static final long serialVersionUID = -5085664711054196792L;

	protected Common common = new Common();

	protected String message;
}
