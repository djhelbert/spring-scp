package org.example.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * System.setProperty("spring.profiles.active", "cloud"); or -Dspring.profiles.active=cloud
 */
@Configuration
@Profile("cloud")
public class CloudConfig {
    @Value("#{environment['bye']}")
    String bye;

    @Value("#{environment['count'] + 1}")   // systemProperties and systemEnvironment are other implicit variables
    String countPlusOne;

    @PostConstruct
    void postConstruct() {
        System.out.println("Post Construct");
        System.out.println("Count +1 " + countPlusOne);
    }

    /**
     * Called when context shuts down properly
     */
    @PreDestroy
    void preDestroy() {
        System.out.println("Pre Destroy");
    }
}
