package com.github.lucitacastello.integrations.services;

import com.github.lucitacastello.integrations.dto.EmailDTO;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    private static Logger LOG = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private SendGrid sendGrid;

    public void sendEmail(EmailDTO dto){

        Email from = new Email(dto.getFromEmail(), dto.getFromName());
        Email to = new Email(dto.getTo()); //destinatário
        Content content = new Content(dto.getContentType(), dto.getBody());
        Mail mail = new Mail(from, dto.getSubject(),to, content );
        //para enviar
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send"); //endpoint dele não é o da aplicação
            request.setBody(mail.build());
            //verificando LOG
            LOG.info("Sending email to: " + dto.getTo());
            Response response = sendGrid.api(request);//resposta do sendgrid - resultado da resposta
            //testando o envio
            if(response.getStatusCode() >= 400 && response.getStatusCode() <= 500){
                LOG.error("Error sending email: " + response.getBody()) ;
            }
            else {
                LOG.info("Email sent! Status: " + response.getStatusCode());
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
