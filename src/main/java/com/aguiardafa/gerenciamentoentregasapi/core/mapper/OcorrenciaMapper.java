package com.aguiardafa.gerenciamentoentregasapi.core.mapper;

import com.aguiardafa.gerenciamentoentregasapi.api.http.resources.request.OcorrenciaRequest;
import com.aguiardafa.gerenciamentoentregasapi.api.http.resources.response.OcorrenciaResponse;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaResponse toResponse(Ocorrencia ocorrencia) {
        return modelMapper.map(ocorrencia, OcorrenciaResponse.class);
    }

    public List<OcorrenciaResponse> toCollectionResponse(List<Ocorrencia> ocorrencias) {
        return ocorrencias.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Ocorrencia toModel(OcorrenciaRequest request) {
        return modelMapper.map(request, Ocorrencia.class);
    }

}
