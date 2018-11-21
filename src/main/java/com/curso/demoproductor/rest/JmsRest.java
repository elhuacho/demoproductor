package com.curso.demoproductor.rest;

import com.curso.demoproductor.entidades.Auto;
import com.curso.demoproductor.jms.JmsProductor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jms")
public class JmsRest {
    @Autowired
    private JmsProductor jmsProductor;

    @PostMapping("/registrar")
    public Auto enviar(@RequestBody Auto auto) {
        //Conviertiendo el objeto Auto a JSON.
        ObjectMapper mapper = new ObjectMapper();
        String stringJson = null;
        try {
            stringJson = mapper.writeValueAsString(auto);
            jmsProductor.send(stringJson);
        } catch (Exception e){
            e.printStackTrace();
        }
        return auto;

    }
}
