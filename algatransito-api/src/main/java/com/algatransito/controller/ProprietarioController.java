package com.algatransito.controller;

import com.algatransito.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProprietarioController {


    @GetMapping("/proprietarios")
    public List<Proprietario> listar() {
        Proprietario proprietario01 = new Proprietario();
        proprietario01.setNome("joana");
        proprietario01.setTelefone("87447567567");
        proprietario01.setEmail("joanasousa@gmail.com");

        return List.of(proprietario01);
    }
}
