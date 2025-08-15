package org.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class GreetingServiceImpl implements GreetingService {

    private String hello;

    @Value("${bye}") // from app.properties directly
    private String bye;

    public GreetingServiceImpl(Environment environment) {
        hello = environment.getProperty("hello");
    }

    @Override
    public String getGreeting(String name) {
        return hello + " " + name + ". " + bye;
    }
}
