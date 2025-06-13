package org.acme.endpoints;

import java.util.List;

import org.acme.entities.Client;
import org.acme.services.ClientService;

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
    ClientService clientService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Client getClientById(@PathParam("id") Long id) {
        return clientService.getClientById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Client addClient(Client client) {
        return clientService.addClient(client);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void updateClient(@PathParam("id") Long id, Client updatedClient) {
        clientService.updateClient(id, updatedClient);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteClient(@PathParam("id") Long id) {
        clientService.deleteClient(id);
    }
}
