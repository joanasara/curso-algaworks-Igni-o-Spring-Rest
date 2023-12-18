package com.algatransito.domain.model;

import com.algatransito.domain.enums.StatusVeiculoEnum;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @ManyToOne
    private Proprietario proprietario;
    private String marca;
    private String modelo;
    private String placa;
    @Enumerated(EnumType.STRING)
    private StatusVeiculoEnum status;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataApreensao;
}
