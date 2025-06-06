package org.acme.endpoints;

import java.util.List;

import org.acme.entities.Client;
import org.acme.repository.ClientRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/clients")
public class ClientEndpoint {

    @Inject
    ClientRepository clientRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> hello() {
        return clientRepository.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClientById(@PathParam("id") Long id) {
        return clientRepository.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Client addClient(Client client) {
        clientRepository.persist(client);
        return client;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void updateClient(@PathParam("id") Long id, Client updatedClient) {
        Client existingClient = clientRepository.findById(id);
        if (existingClient != null) {
            existingClient.firstName = updatedClient.firstName;
            existingClient.lastName = updatedClient.lastName;
            existingClient.companyName = updatedClient.companyName;
            clientRepository.persist(existingClient);
        }

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteClient(@PathParam("id") Long id) {
        Client client = clientRepository.findById(id);
        if (client != null) {
            clientRepository.delete(client);
        }
    }
}
