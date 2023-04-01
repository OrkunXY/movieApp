package com.bilgeadam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    USER_NOT_FOUND(2004, "kullanci bulunamadı", HttpStatus.NOT_FOUND),
    BAD_REQUEST(4000,"gecersiz istek veya parametre", HttpStatus.BAD_REQUEST),
    ERROR_INVALID_TOKEN(300,"gecersiz token bilgisi",HttpStatus.UNAUTHORIZED),
    ERROR(9000, "beklenmedik bir hata lutefn tekrar dene", HttpStatus.INTERNAL_SERVER_ERROR);




    int code;
    String message;
    HttpStatus httpStatus;


}
