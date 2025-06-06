package org.acme.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client implements Serializable {
    public Long clientId;
    public String firstName;
    public String lastName;
    public String companyName;

    public Client() {
    }

    public Client(Long clientId, String firstName, String lastName, String companyName) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Client [clientId=" + clientId + ", firstName=" + firstName + ", lastName=" + lastName + ", companyName="
                + companyName + "]";
    }
}
