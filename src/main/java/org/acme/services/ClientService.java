package org.acme.services;

import java.util.List;

import org.acme.entities.Client;
import org.acme.repository.ClientRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ClientService {
    @Inject
    ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.listAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client addClient(Client client) {
        clientRepository.persist(client);
        return client;
    }

    public void updateClient(Long id, Client updatedClient) {
        Client existingClient = clientRepository.findById(id);
        if (existingClient != null) {
            existingClient.firstName = updatedClient.firstName;
            existingClient.lastName = updatedClient.lastName;
            existingClient.companyName = updatedClient.companyName;
            clientRepository.persist(existingClient);
        }
    }

    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id);
        if (client != null) {
            clientRepository.delete(client);
        }
    }
}
