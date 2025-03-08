package com.example.balo_center.exception;

import org.springframework.http.HttpStatus;

public class UploadFileEx extends RuntimeException{
    private String message;
    private HttpStatus status;
    public UploadFileEx(String message){
        super(message);
        this.status = HttpStatus.BAD_GATEWAY;
        this.message = message;
    }
}
