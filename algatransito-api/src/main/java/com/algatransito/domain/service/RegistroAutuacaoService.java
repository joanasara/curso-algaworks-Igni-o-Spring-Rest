package com.algatransito.domain.service;

import com.algatransito.domain.model.Autuacao;
import com.algatransito.domain.model.Veiculo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroAutuacaoService {

    private RegistroVeiculoService veiculoService;

    @Transactional
    public Autuacao registrar(Long veiculoId, Autuacao novaAutuacao) {
        Veiculo veiculo = veiculoService.buscar(veiculoId);
       return veiculo.adicionarAutuacao(novaAutuacao);
    }



}
