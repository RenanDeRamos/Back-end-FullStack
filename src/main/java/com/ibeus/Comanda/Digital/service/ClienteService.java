package com.ibeus.Comanda.Digital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibeus.Comanda.Digital.model.Cliente;
import com.ibeus.Comanda.Digital.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente clienteDetails) {
        Cliente cliente = findById(id);
        cliente.setNome(clienteDetails.getNome());
        cliente.setLogradouro(clienteDetails.getLogradouro());
        cliente.setFormaDePagamento(clienteDetails.getFormaDePagamento());
        cliente.setTroco(clienteDetails.getTroco());
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        Cliente cliente = findById(id);
        clienteRepository.delete(cliente);
        //tentando corrigir o git
    }
}
