package net.atos.Codex_IOT.model;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;

/**
 * @author A666395
 * This class is for the Api Response
 */
public class FTApiResponse {
	private static final Logger logger = Logger.getLogger(FTApiResponse.class);

	private Object data;
	private String message;
	private int errorCode;

	public FTApiResponse() {
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param msg
	 * @param obj
	 * @return ResponseDto
	 */
	public static FTApiResponse successResponse(String msg, Object obj) {
		FTApiResponse sucess = new FTApiResponse();
		sucess.setMessage(msg);
		sucess.setData(obj);
		sucess.setErrorCode(HttpStatus.OK.value());
		return sucess;
	}

	/**
	 * @param msg
	 * @param obj
	 * @return ResponseDto
	 */
	public static FTApiResponse failureResponse(String msg, Object obj, int errorCode) {
		FTApiResponse failure = new FTApiResponse();
		failure.setMessage(msg);
		failure.setData(obj);
		failure.setErrorCode(errorCode);
		return failure;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
