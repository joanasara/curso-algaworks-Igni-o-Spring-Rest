package com.algatransito.api.controller;

import com.algatransito.api.assembler.AutuacaoAssembler;
import com.algatransito.api.model.AutuacaoModel;
import com.algatransito.api.model.input.AutuacaoInput;
import com.algatransito.domain.model.Autuacao;
import com.algatransito.domain.model.Veiculo;
import com.algatransito.domain.service.RegistroAutuacaoService;
import com.algatransito.domain.service.RegistroVeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {

    private final AutuacaoAssembler autuacaoAssembler;
    private final RegistroAutuacaoService registroAutuacaoService;
    private final RegistroVeiculoService veiculoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoModel registrar(@PathVariable Long veiculoId, @RequestBody @Valid AutuacaoInput autuacaoInput) {
        Autuacao novaAutuacao = autuacaoAssembler.toEntity(autuacaoInput);
        Autuacao autuacaoRegistrada = registroAutuacaoService.registrar(veiculoId, novaAutuacao);
        return autuacaoAssembler.toModel(autuacaoRegistrada);
    }


    public List<AutuacaoModel> listar(@PathVariable Long veiculoId) {
        Veiculo veiculo = veiculoService.buscar(veiculoId);
        return autuacaoAssembler.toCollectionModel(veiculo.getAutuacaes());
    }
}