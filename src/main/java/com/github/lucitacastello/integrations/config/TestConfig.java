package com.github.lucitacastello.integrations.config;

import com.github.lucitacastello.integrations.services.EmailService;
import com.github.lucitacastello.integrations.services.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test") //configuração específica para profile dev
public class TestConfig {

    //mockando somente para testes
    //não envia email
    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
