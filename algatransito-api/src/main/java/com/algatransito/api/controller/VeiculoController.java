package com.algatransito.api.controller;

import com.algatransito.api.assembler.VeiculoAssembler;
import com.algatransito.api.model.VeiculoModel;
import com.algatransito.domain.model.Veiculo;
import com.algatransito.domain.repository.VeiculoRepository;
import com.algatransito.domain.service.RegistroVeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoAssembler veiculoAssembler;
    private final VeiculoRepository veiculoRepository;
    private final RegistroVeiculoService veiculoService;

    @GetMapping
    public List<VeiculoModel> listar() {
        return veiculoAssembler.toCollectionModel(veiculoRepository.findAll());

    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoModel> buscar(@PathVariable Long veiculoId) {

        return veiculoRepository.findById(veiculoId)
                .map(veiculoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoModel cadastrar(@Valid @RequestBody Veiculo veiculo) {
        return veiculoAssembler.toModel(veiculoService.cadastrar(veiculo));
    }
}
