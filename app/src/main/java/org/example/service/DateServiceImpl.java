package org.example.service;

import java.time.LocalDate;

public class DateServiceImpl implements DateService {
    @Override
    public LocalDate getDate() {
        return LocalDate.now();
    }
}
