package com.gestio.crudclient.services;

import com.gestio.crudclient.dto.ClientDTO;
import com.gestio.crudclient.entities.Client;
import com.gestio.crudclient.repositories.ClientRepository;
import com.gestio.crudclient.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(PageRequest pageRequest) {
        Page<Client> clients = repository.findAll(pageRequest);
        return clients.map(client -> new ClientDTO(client));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> obj = repository.findById(id);
        Client client = obj.orElseThrow(() -> new ResourceNotFoundException("Client " + id + " not found"));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        entity.setName(dto.getName());
        entity.setIdentityCard(dto.getIdentityCard());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        Client entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client " + id + " not found"));
        entity.setName(dto.getName());
        entity.setIdentityCard(dto.getIdentityCard());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }
}
