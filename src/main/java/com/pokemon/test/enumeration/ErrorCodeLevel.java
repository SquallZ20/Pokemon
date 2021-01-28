package com.pokemon.test.enumeration;

public enum ErrorCodeLevel {

	WARN(1),
	ERROR(0);

	private final int levelCode;

	ErrorCodeLevel(int levelCode) {
		this.levelCode = levelCode;
	}

	public int levelCode() {
		return levelCode;
	}

}
