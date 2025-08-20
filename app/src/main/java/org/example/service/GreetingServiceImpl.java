package org.example.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class GreetingServiceImpl implements GreetingService, InitializingBean {

  private String hello;

  @Value("${bye}") // from app.properties directly
  private String bye;

  public GreetingServiceImpl(Environment environment) {
    hello = environment.getProperty("hello");
  }

  @Override
  public String getGreeting(String name) {
    if (name == null) {
      throw new IllegalArgumentException("name is required");
    }

    return hello + " " + name + ". " + bye;
  }

  public String sayBye(@Value("${bye}") String bye) {
    return bye;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("properties have been set for GreetingServiceImpl");
  }
}
