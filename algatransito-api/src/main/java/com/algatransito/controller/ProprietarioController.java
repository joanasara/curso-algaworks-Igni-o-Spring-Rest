package com.algatransito.controller;

import com.algatransito.domain.model.Proprietario;
import com.algatransito.domain.repository.ProprietarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProprietarioController {

    //@Autowired ESTA ANOTACAO ELA DEFINE QUE QUEREMOS INJETAR UMA INSTACIA CRIADA PELO SPRING
    private final ProprietarioRepository proprietarioRepository;


    @GetMapping("/proprietarios")
    public List<Proprietario> listar() {
        return proprietarioRepository.findAll();
    }
}
