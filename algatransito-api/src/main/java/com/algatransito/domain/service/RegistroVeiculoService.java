package com.algatransito.domain.service;

import com.algatransito.domain.enums.StatusVeiculoEnum;
import com.algatransito.domain.exception.NegocioException;
import com.algatransito.domain.model.Proprietario;
import com.algatransito.domain.model.Veiculo;
import com.algatransito.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class RegistroVeiculoService {

    private final VeiculoRepository veiculoRepository;
    private RegistroProprietarioService proprietarioService;

    @Transactional
    public Veiculo cadastrar(Veiculo novoVeiculo) {
        if (novoVeiculo.getId() != null) {
            throw new NegocioException("Veiculo a ser cadastrado nao deve possuir um codigo");
        }

        boolean placaUso = veiculoRepository.findByPlaca(novoVeiculo.getPlaca())
                .filter(veiculo -> veiculo.equals(novoVeiculo))
                .isPresent();

        if (placaUso) {
            throw new NegocioException("Ja Existe um veiculo cadastrado com esta placa");
        }

        Proprietario proprietario = proprietarioService.buscar(novoVeiculo);
        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setStatus(StatusVeiculoEnum.REGULAR);
        novoVeiculo.setDataCadastro(LocalDateTime.now());
        return veiculoRepository.save(novoVeiculo);
    }
}
