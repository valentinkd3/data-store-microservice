package ru.kozhevnikov.datastoremicroservice.web.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kozhevnikov.datastoremicroservice.model.exception.SensorNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(SensorNotFoundException.class)
    public String sensorNotFoundException(SensorNotFoundException e){
        return "Sensor not found";
    }

    @ExceptionHandler
    public String server(Exception e){
        e.printStackTrace();
        return "Some exception.";
    }
}
