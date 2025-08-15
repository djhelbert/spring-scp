package org.example.config;

import org.example.service.UidService;
import org.example.service.UidServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class OtherConfig {
    /**
     * New Bean Provided Every Time
     * @return UidService Bean
     */
    @Bean
    @Scope("prototype")
    public UidService uidService() {
        return new UidServiceImpl();
    }
}
