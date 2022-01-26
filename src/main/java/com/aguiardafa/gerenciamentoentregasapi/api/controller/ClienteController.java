package com.aguiardafa.gerenciamentoentregasapi.api.controller;

import com.aguiardafa.gerenciamentoentregasapi.api.mapper.ClienteMapper;
import com.aguiardafa.gerenciamentoentregasapi.api.model.ClienteRequest;
import com.aguiardafa.gerenciamentoentregasapi.api.model.ClienteResponse;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Cliente;
import com.aguiardafa.gerenciamentoentregasapi.domain.repository.ClienteRepository;
import com.aguiardafa.gerenciamentoentregasapi.domain.service.CatalogoClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private CatalogoClienteService catalogoClienteService;
    private ClienteMapper clienteMapper;

    @GetMapping
    public List<ClienteResponse> listar() {
        return clienteMapper.toCollectionResponse(clienteRepository.findAll());
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> buscar(@PathVariable Long clienteId) {
        return clienteRepository.findById(clienteId)
                .map(cliente -> ResponseEntity.ok(clienteMapper.toResponse(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponse adicionar(@Valid @RequestBody ClienteRequest clienteRequest) {
        Cliente novoCliente = clienteMapper.toModel(clienteRequest);
        Cliente clienteAdicionado = catalogoClienteService.salvar(novoCliente);
        return clienteMapper.toResponse(clienteAdicionado);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> atualizar(@Valid
                                                     @PathVariable Long clienteId,
                                                     @RequestBody ClienteRequest clienteRequest) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        } else {
            Cliente cliente = clienteMapper.toModel(clienteRequest);
            cliente.setId(clienteId);
            Cliente clienteAtualizado = catalogoClienteService.salvar(cliente);
            return ResponseEntity.ok(clienteMapper.toResponse(clienteAtualizado));
        }
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        catalogoClienteService.excluir(clienteId);
        return ResponseEntity.noContent().build();
    }
}
