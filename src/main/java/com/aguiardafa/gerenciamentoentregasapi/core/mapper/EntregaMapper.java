package com.aguiardafa.gerenciamentoentregasapi.core.mapper;

import com.aguiardafa.gerenciamentoentregasapi.api.http.resources.request.EntregaRequest;
import com.aguiardafa.gerenciamentoentregasapi.api.http.resources.response.EntregaResponse;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EntregaMapper {

    private ModelMapper modelMapper;

    public EntregaResponse toResponse(Entrega entrega) {
        return modelMapper.map(entrega, EntregaResponse.class);
    }

    public List<EntregaResponse> toCollectionResponse(List<Entrega> entregas) {
        return entregas.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Entrega toModel(EntregaRequest request) {
        return modelMapper.map(request, Entrega.class);
    }

}
