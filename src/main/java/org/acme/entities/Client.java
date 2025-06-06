package org.acme.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Client extends PanacheEntity {
    public String firstName;
    public String lastName;
    public String companyName;
}
