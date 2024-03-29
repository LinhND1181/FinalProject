package net.aht.internship.demo.config.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;


public class VsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private HttpStatus status;

    private String userMessage;

    private String devMessage;

    public VsException(String devMessage) {
        super(devMessage);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.devMessage = devMessage;
    }

    public VsException(String userMessage, String devMessage) {
        super(devMessage);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.userMessage = userMessage;
        this.devMessage = devMessage;
    }

    public VsException(HttpStatus status, String userMessage, String devMessage) {
        super(devMessage);
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
