package com.github.lucitacastello.integrations.resources;

import com.github.lucitacastello.integrations.dto.EmailDTO;
import com.github.lucitacastello.integrations.services.EmailService;
import com.github.lucitacastello.integrations.services.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class EmailResource {

    @Autowired
    private EmailService service; //injeta a Interface

    @PostMapping
    public ResponseEntity<Void> send(@RequestBody EmailDTO dto){

        service.sendEmail(dto);
        return ResponseEntity.noContent().build();
    }
}
