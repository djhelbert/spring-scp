package org.example.aop;

import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  public final static String BEFORE = "'Before'";
  public final static String AROUND = "'Around'";

  private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

  @Before("execution(* org.example.scan.Service*.get*(..))")
  public void implLogging(JoinPoint joinPoint) {
    logger.info(BEFORE + " advice implementation - " + joinPoint.getTarget().getClass() + //
        "; Executing before " + joinPoint.getSignature().getName() + "() method");
  }

  @Around("execution(* org.example.scan.Service*.get*(..))")
  public Object monitor(ProceedingJoinPoint repositoryMethod) throws Throwable {
    String name = createJoinPointTraceName(repositoryMethod);

    try {
      Object returned = repositoryMethod.proceed();
      return "prefix:" + returned.toString();
    } finally {
      logger.info(AROUND + " advice implementation - " + name);
    }
  }

  private String createJoinPointTraceName(JoinPoint joinPoint) {
    Signature signature = joinPoint.getSignature();
    StringBuilder sb = new StringBuilder();
    sb.append(signature.getDeclaringType().getSimpleName());
    sb.append('.').append(signature.getName());
    return sb.toString();
  }
}
