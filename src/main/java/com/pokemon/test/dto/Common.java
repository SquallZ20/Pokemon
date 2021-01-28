package com.pokemon.test.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import it.thinkopen.milanoteleport.modemmonitor.enumeration.ErrorCode;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@JsonPropertyOrder({
		"ack",
		"faultCode",
		"faultString"
})
public class Common implements Serializable {

	public static final String ACK_OK = "OK";
	public static final String ACK_KO = "KO";
	public static final String ACK_BAD_REQUEST = "BAD REQUEST";
	public static final String ACK_NOT_FOUND = "NOT FOUND";
	public static final String ACK_CONFLICT = "CONFLICT";
	private static final long serialVersionUID = 9010376143954106443L;
	private String ack;

	private Integer faultCode;

	private String faultString;

	public Common() {
	}

	public Common(String ack) {
		this.ack = ack;
	}

	public Common(String ack, ErrorCode errorCode) {
		this.ack = ack;
		this.faultCode = errorCode.errorCode();
		if (StringUtils.isNotEmpty(errorCode.errorMessage())) {
			this.faultString = errorCode.errorMessage();
		} else {
			this.faultString = errorCode.toString();
		}
	}

	public Common(String ack, Integer faultCode, String faultString) {
		this.ack = ack;
		this.faultCode = faultCode;
		this.faultString = faultString;
	}

	public String getAck() {
		return ack;
	}

	public void setAck(String ack) {
		this.ack = ack;
	}

	public Integer getFaultCode() {
		return faultCode;
	}

	public void setFaultCode(Integer faultCode) {
		this.faultCode = faultCode;
	}

	public String getFaultString() {
		return faultString;
	}

	public void setFaultString(String faultString) {
		this.faultString = faultString;
	}

	@Override
	public String toString() {
		return "CommonDto{" + "ack=" + ack + ", faultCode=" + faultCode + ", faultString=" + faultString + '}';
	}
}
