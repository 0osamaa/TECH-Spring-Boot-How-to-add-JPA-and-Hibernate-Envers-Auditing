package com.osama;

import com.osama.config.DefaultAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "defaultAuditorAware")
public class EnversAuditingApplication {


//    @Bean
//    public AuditorAware<String> defaultAuditorAware() {
//        return new DefaultAuditorAware();
//    }

    public static void main(String[] args) {
        SpringApplication.run(EnversAuditingApplication.class, args);
    }

}
