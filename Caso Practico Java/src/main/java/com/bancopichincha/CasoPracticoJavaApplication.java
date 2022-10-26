package com.bancopichincha;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.Registry;
import io.jkratz.mediator.spring.SpringMediator;
import io.jkratz.mediator.spring.SpringRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.bancopichincha"})
@EnableJpaRepositories("com.bancopichincha")
@EntityScan("com.bancopichincha")
@ComponentScan("com.bancopichincha")
public class CasoPracticoJavaApplication {
    private final ApplicationContext applicationContext;
    @Autowired
    public CasoPracticoJavaApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public Registry registry() {
        return new SpringRegistry(applicationContext);
    }

    @Bean
    public Mediator mediator(Registry registry) {
        return new SpringMediator(registry);
    }

    public static void main(String[] args) {
        SpringApplication.run(CasoPracticoJavaApplication.class, args);
    }
}
