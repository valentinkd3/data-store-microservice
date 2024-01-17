package ru.kozhevnikov.datastoremicroservice.service;

public interface ChangesDataCaptureEventConsumer {

    void handle(String message);
}
