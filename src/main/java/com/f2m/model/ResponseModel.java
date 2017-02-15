package com.f2m.model;

/**
 * Created by bakarali on 28/1/17.
 */
import org.springframework.http.HttpStatus;

public class ResponseModel {

    private HttpStatus status;
    private String message;

    public ResponseModel(HttpStatus ok, String message){
        this.status = ok;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
