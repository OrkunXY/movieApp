package com.bilgeadam.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * bu sınıf uygulma içinde olusacak tum istisnalarıın yakalanması icin kullanılacaktır.
 * burada bu sınıfın bizim belirlediğimiz olzeliştirimiş istisnalarını yakalayacagız.
 * bunun dısında ek kullandıgımız kutuphanelerin istisnalarını da ayrıca belrleyip yakalayacagız
 * */
@ControllerAdvice
public class GlobalExceptionHandler {
    private ErrorMesseage createErrorMessage(ErrorType errorType, Exception exception){
        System.out.println("hata mesajini burada yaninlayabilirsin");
        return ErrorMesseage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }

    @ExceptionHandler(MovieAppException.class)
    @ResponseBody
    public ResponseEntity<ErrorMesseage> handlerJava7MonoExceptiron(MovieAppException exception){
        System.out.println("java7monoexception hatasi....:"+exception.toString());
        return new ResponseEntity(createErrorMessage(exception.getErrorType(),exception), exception.getErrorType().getHttpStatus());
    }



    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResponseEntity<String> handleArithmeticException(ArithmeticException exception){
        /**
         * burada olusan istisna ile ilgili eğer log tutulacak ise bu işlemler yapılır.*/
        System.out.println("aritmatik sistem hatasi..."+ exception.toString());
        return ResponseEntity.ok("sifira bolemezsin");
        }
        @ExceptionHandler(HttpMessageNotReadableException.class)
        @ResponseBody
        public ResponseEntity<ErrorMesseage> handleHttpMessageNotReadableExceptionException(HttpMessageNotReadableException exception){
            ErrorType errorType=ErrorType.BAD_REQUEST;
            return new ResponseEntity<>(createErrorMessage(errorType,exception),errorType.getHttpStatus());
        }

        @ExceptionHandler (Exception.class)
        @ResponseBody
        public ResponseEntity<String> handleException(Exception exception){
        ErrorType errorType=ErrorType.ERROR;
        return ResponseEntity.badRequest().body("ismail bir hata turuttu");
        }


}

