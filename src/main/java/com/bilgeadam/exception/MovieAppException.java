package com.bilgeadam.exception;

import lombok.Getter;

@Getter
public class MovieAppException extends RuntimeException {
    private final ErrorType errorType;
    public MovieAppException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }
    public MovieAppException(ErrorType errorType, String errorMesseage){
        super(errorMesseage);
        this.errorType=errorType;

    }

}
