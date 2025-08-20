package org.example.aop;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

  public static final String FAILURE_MSG = "Failed to provide valid argument";
  private Logger logger = Logger.getLogger(ExceptionHandlingAspect.class.getName());

  @AfterThrowing(value = "execution(* org.example.service.*Service.*(..))", throwing = "e")
  public void implExceptionHandling(IllegalArgumentException e) {
    logger.log(Level.SEVERE, FAILURE_MSG, e);
  }
}
