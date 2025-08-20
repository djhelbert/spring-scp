package org.example;

import java.time.LocalDate;
import org.example.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileApp {

  public static void main(String[] args) {
    // Spring DI container
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.registerShutdownHook();

    context.getEnvironment().setActiveProfiles("cloud");
    context.register(BeanConfig.class);
    context.refresh();

    LocalDate ld = (LocalDate) context.getBean(LocalDate.class);
    System.out.println(ld);
  }
}
