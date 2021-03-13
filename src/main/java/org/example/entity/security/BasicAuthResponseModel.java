package org.example.entity.security;

public class BasicAuthResponseModel {
    private String message;

    public BasicAuthResponseModel(String message) {
        this.message = message;
    }

    public BasicAuthResponseModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
