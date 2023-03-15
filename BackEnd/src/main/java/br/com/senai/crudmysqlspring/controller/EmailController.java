package br.com.senai.crudmysqlspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.crudmysqlspring.model.EmailRequest;
import br.com.senai.crudmysqlspring.service.EmailService;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-email")
    public void enviarEmail(@RequestBody EmailRequest emailDTO) {
        emailService.enviar(emailDTO.getTo(), emailDTO.getSubject(), emailDTO.getText());
    }
}



