package it.thinkopen.milanoteleport.modemmonitor.enumeration;

public enum ErrorCode {

	ERROR_DELETE_MODEM(12, "Error to delete modem"),
	ERROR_CREATE_NEW_CUSTOMER(11, "Error to create new customer"),
	ERROR_CUSTOMER_ALREADY_PRESENT(10, "Error to create new customer, it's already present in db"),
	ERROR_CHANGED_CUSTOMER_STATUS(9, "Error in change customer status"),
	ERROR_DIFFERENCE_DATE(8, "The difference in days is greater than the established period"),
	ERROR_START_DATE_AFTER_END_DATE(7, "Start Date is Greater than End Date"),
	INVALID_END_DATE_FORMAT(6, "End Date Format Not Valid"),
	INVALID_START_DATE_FORMAT(5, "Start Date Format Not Valid"),
	EMPTY_END_DATE(4, "Insert End Date"),
	EMPTY_START_DATE(3, "Insert Start Date"),
	EMPTY_MODEM_ID(2, "Insert Modem Id"),
	EMPTY_CUSTOMER_ID(1, "Insert Customer Id"),
	GENERIC_ERROR(0, "Internal Error");

	private final int errorCode;
	private final String errorMessage;
	private ErrorCodeLevel level = ErrorCodeLevel.ERROR;

	ErrorCode(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	ErrorCode(int errorCode, String errorMessage, ErrorCodeLevel level) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.level = level;
	}

	public int errorCode() {
		return errorCode;
	}

	public String errorMessage() {
		return errorMessage;
	}

	public ErrorCodeLevel level() {
		return level;
	}

	@Override
	public String toString() {
		return "ErrorCode{" + "errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", level=" + level + '}';
	}

}
