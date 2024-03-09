package com.algatransito.api.assembler;

import com.algatransito.api.model.VeiculoModel;
import com.algatransito.api.model.input.VeiculoInput;
import com.algatransito.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class VeiculoAssembler {

    private final ModelMapper modelMapper;

    public final Veiculo toEntity(VeiculoInput veiculoInput) {
        return modelMapper.map(veiculoInput, Veiculo.class);
    }

    public VeiculoModel toModel(Veiculo veiculo) {

        return modelMapper.map(veiculo, com.algatransito.api.model.VeiculoModel.class);
    }

    public List<VeiculoModel> toCollectionModel(List<Veiculo> veiculos) {
         return veiculos.stream()
                 .map(this::toModel)
                 .toList();
    }
}
