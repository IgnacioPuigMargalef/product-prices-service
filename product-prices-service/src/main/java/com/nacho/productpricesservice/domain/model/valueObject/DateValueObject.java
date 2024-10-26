package com.nacho.productpricesservice.domain.model.valueObject;

import com.nacho.productpricesservice.domain.exception.DateNotFormattedException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateValueObject {

    private LocalDateTime dateTime;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    public DateValueObject(String dateTime) {
        setDateValueObject(dateTime);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateValueObject(String dateTime) {
        try {
            this.dateTime = LocalDateTime.parse(dateTime, formatter);
        } catch (Exception e) {
            throw new DateNotFormattedException();
        }
    }
}
