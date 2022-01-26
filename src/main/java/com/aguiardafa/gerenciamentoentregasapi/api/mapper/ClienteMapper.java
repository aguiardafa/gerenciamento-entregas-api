package com.aguiardafa.gerenciamentoentregasapi.api.mapper;

import com.aguiardafa.gerenciamentoentregasapi.api.model.ClienteRequest;
import com.aguiardafa.gerenciamentoentregasapi.api.model.ClienteResponse;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ClienteMapper {

    private ModelMapper modelMapper;

    public ClienteResponse toResponse(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponse.class);
    }

    public List<ClienteResponse> toCollectionResponse(List<Cliente> clientes) {
        return clientes.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Cliente toModel(ClienteRequest request) {
        return modelMapper.map(request, Cliente.class);
    }

}
