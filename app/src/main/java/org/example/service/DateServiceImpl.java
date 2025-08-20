package org.example.service;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;

public class DateServiceImpl implements DateService {

  @Override
  public LocalDate getDate() {
    return LocalDate.now();
  }

  @Override
  public String getDateFormat() {
    return "yyyy-MM-dd";
  }

  @PostConstruct
  public void postContruct() {
    System.out.println("Called after bean DateServiceImpl created");
  }
}
