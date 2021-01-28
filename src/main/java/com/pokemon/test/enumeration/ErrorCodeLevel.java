package it.thinkopen.milanoteleport.modemmonitor.enumeration;

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
