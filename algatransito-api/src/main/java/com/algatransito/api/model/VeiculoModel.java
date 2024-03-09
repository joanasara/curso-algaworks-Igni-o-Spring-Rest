package com.algatransito.api.model;

import com.algatransito.domain.enums.StatusVeiculoEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class VeiculoModel {

    private Long id;
    private ProprietarioResumoModel nomeProprietario;
    private String marca;
    private String modelo;
    private String placa;
    private StatusVeiculoEnum status;
    private OffsetDateTime dataCadastero;
    private OffsetDateTime dataApreensao;
}