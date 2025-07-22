package com.management.HospitalClient.exception;

import org.hibernate.exception.DataException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class PatientException {

    @ExceptionHandler(value = RuntimeException.class)
    public Exception dataNoFound(){
        return new RuntimeException("Data Not Found ");
    }

    @ExceptionHandler(value = HttpClientErrorException.BadRequest.class)
    public Exception badRequest(){
        return new RuntimeException("Bad Request  ");
    }

    @ExceptionHandler(value = DataException.class)
    public Exception DatabaseError(){
        return new RuntimeException("Database Error  " );
    }
}
