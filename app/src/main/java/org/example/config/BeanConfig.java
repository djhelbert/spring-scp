package org.example.config;

import org.example.service.DateService;
import org.example.service.DateServiceImpl;
import org.example.service.GreetingService;
import org.example.service.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:app.properties")   // or "file:app.properties"
@Import(OtherConfig.class)
@ComponentScan("org.example.scan")
public class BeanConfig {
    /**
     * Only 1 Date Service will be created
     * @return DateService Bean
     */
    @Bean
    @Scope("singleton")
    public DateService dateService() {
        return new DateServiceImpl();   // Method name determines bean name
    }

    @Bean
    public GreetingService greetingService(Environment env) {
        return new GreetingServiceImpl(env);
    }
}
