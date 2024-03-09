package com.algatransito.api.assembler;

import com.algatransito.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class VeiculoAssembler {

    private final ModelMapper modelMapper;

    public com.algatransito.api.model.VeiculoModel toModel(Veiculo veiculo) {

        return modelMapper.map(veiculo, com.algatransito.api.model.VeiculoModel.class);
    }

    public List<com.algatransito.api.model.VeiculoModel> toCollectionModel(List<Veiculo> veiculos) {
         return veiculos.stream()
                 .map(this::toModel)
                 .toList();
    }
}
