package com.aguiardafa.gerenciamentoentregasapi.domain.service;

import com.aguiardafa.gerenciamentoentregasapi.domain.exception.NegocioException;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Cliente;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Entrega;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.StatusEntrega;
import com.aguiardafa.gerenciamentoentregasapi.domain.repository.EntregaRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;


@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {
    private EntregaRepository entregaRepository;
    private CatalogoClienteService catalogoClienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        // regras de negócio aqui (caso exista)

        // atributos calculados
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PEDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        // busca endereço com base no CEP informado
        try {
            String cep = entrega.getDestinatario().getCep().replaceAll("-", "");
            String urlAPI = "https://viacep.com.br/ws/" + cep + "/json/";
            RestTemplate template = new RestTemplate();
            EnderecoResponse enderecoResponse = template.getForObject(urlAPI, EnderecoResponse.class);
            entrega.getDestinatario().setLogradouro(enderecoResponse.getLogradouro());
            entrega.getDestinatario().setBairro(enderecoResponse.getBairro());
            entrega.getDestinatario().setCidade(enderecoResponse.getLocalidade());
            entrega.getDestinatario().setUf(enderecoResponse.getUf());
        } catch (Exception e) {
            throw new NegocioException("O CEP informado não é válido. Faça o preenchimento correto e tente novamente.");
        }
        return entregaRepository.save(entrega);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class EnderecoResponse {
        private String logradouro;
        private String bairro;
        private String localidade;
        private String uf;
    }

}
