package com.github.lucitacastello.integrations.services;

import com.github.lucitacastello.integrations.dto.EmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Simulando
public class MockEmailService implements EmailService {

    private static Logger LOG = LoggerFactory.getLogger(MockEmailService.class);


    public void sendEmail(EmailDTO dto) {

            //verificando LOG
            LOG.info("Sending email to: " + dto.getTo());
            LOG.info("Email sent!");




    }
}
