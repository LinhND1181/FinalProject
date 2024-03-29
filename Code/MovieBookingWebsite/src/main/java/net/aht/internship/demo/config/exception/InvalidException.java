package net.aht.internship.demo.config.exception;

import org.springframework.http.HttpStatus;


public class InvalidException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    /*
    to ensure version consistency when traversing objects between versions of an application or between different applications
    When the Serializable object is dispatched, the serialVersionUID is appended to the object's data to identify the version of the class.
     */

    private HttpStatus status;

    private String userMessage;

    private String devMessage;

    public InvalidException(String userMessage, String devMessage) {
        super(userMessage);
        this.status = HttpStatus.BAD_REQUEST;
        this.userMessage = userMessage;
        this.devMessage = devMessage;
    }

    public InvalidException(HttpStatus status, String userMessage, String devMessage) {
        super(userMessage);
        this.status = status;
        this.userMessage = userMessage;
        this.devMessage = devMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }
}
