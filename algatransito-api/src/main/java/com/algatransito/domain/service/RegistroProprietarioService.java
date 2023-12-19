package com.algatransito.domain.service;

import com.algatransito.domain.exception.NegocioException;
import com.algatransito.domain.model.Proprietario;
import com.algatransito.domain.model.Veiculo;
import com.algatransito.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    public Proprietario buscar(Veiculo novoVeiculo) {
        Proprietario proprietario = proprietarioRepository.findById(novoVeiculo.getProprietario().getId())
                .orElseThrow(() -> new NegocioException("Proprietario nao encontrado"));
        return proprietario;
    }

    @Transactional
    public Proprietario salvar(Proprietario proprietario) {
        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();

        if (emailEmUso) {
            throw new NegocioException(" Ja existe um proprietario cadastrado com esse email");

        }
        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void excluir(Long proprietarioId) {
        proprietarioRepository.deleteById(proprietarioId);
    }


}
