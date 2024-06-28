package com.github.lucitacastello.integrations.services;

import com.github.lucitacastello.integrations.dto.EmailDTO;

public interface EmailService {

    void sendEmail(EmailDTO dto);
}
