package org.acme.endpoints;

import java.util.List;

import org.acme.entities.Client;
import org.acme.repository.ClientRepository;

import jakarta.inject.Inject;
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
        return clientRepository.getClients();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClientById(@PathParam("id") Long id) {
        return clientRepository.getClientById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Client addClient(Client client) {
        return clientRepository.addClient(client);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateClient(@PathParam("id") Long id, Client updatedClient) {
        clientRepository.updateClient(id, updatedClient);
    }

    @DELETE
    @Path("/{id}")
    public void deleteClient(@PathParam("id") Long id) {
        clientRepository.deleteClient(id);
    }
}
