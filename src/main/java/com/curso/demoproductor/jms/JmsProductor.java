package com.curso.demoproductor.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProductor {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.cola.envio}")
    private String destino;

    public void send(String mensaje) {
        jmsTemplate.convertAndSend(destino, mensaje);
    }
}
