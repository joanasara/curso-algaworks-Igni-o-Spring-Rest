package com.algatransito.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AutuacaoInput {

    @NotBlank
    private String descricao;

    @Positive
    @NotNull
    private BigDecimal valorMulta;

}
