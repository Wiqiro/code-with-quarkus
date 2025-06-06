package org.acme.repository;

import org.acme.entities.Client;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.inject.Singleton;

@Singleton
public class ClientRepository implements PanacheRepository<Client> {
}
