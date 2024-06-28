package com.github.lucitacastello.integrations.config;

import com.github.lucitacastello.integrations.services.EmailService;
import com.github.lucitacastello.integrations.services.SendGridEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev") //configuração específica para profile dev
public class DevConfig {

    @Bean
    public EmailService emailService(){
        return new SendGridEmailService();
    }
}
