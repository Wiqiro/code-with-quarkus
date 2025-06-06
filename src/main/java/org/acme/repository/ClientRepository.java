package org.acme.repository;

import java.util.List;

import org.acme.entities.Client;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Singleton
public class ClientRepository {
    @Inject
    EntityManager entityManager;

    public List<Client> getClients() {
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    public Client getClientById(Long id) {
        return entityManager.find(Client.class, id);
    }

    @Transactional
    public Client addClient(Client client) {
        entityManager.persist(client);
        return client;
    }

    @Transactional
    public void updateClient(Long id, Client updatedClient) {
        Client existingClient = getClientById(id);
        if (existingClient != null) {
            existingClient.setFirstName(updatedClient.getFirstName());
            existingClient.setLastName(updatedClient.getLastName());
            existingClient.setCompanyName(updatedClient.getCompanyName());
            entityManager.merge(existingClient);
        }
    }

    @Transactional
    public void deleteClient(Long id) {
        Client client = getClientById(id);
        if (client != null) {
            entityManager.remove(client);
        }
    }

}
