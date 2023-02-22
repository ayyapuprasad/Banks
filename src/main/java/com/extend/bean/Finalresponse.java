package com.extend.bean;

public class Finalresponse {

	public boolean status;
    public String statusCode;
    public String message;
    public String errorMessages;
    public Object data;
   
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Finalresponse [status=" + status + ", statusCode=" + statusCode + ", message=" + message
				+ ", errorMessages=" + errorMessages + ", data=" + data + "]";
	}
}