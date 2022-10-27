package com.bb2.Products_ApiRest.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNorFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNorFoundException(String message) {
        super(message);
    }
}
