package com.example.proiectlicenta.entity;

import jakarta.persistence.*;

@Entity(name="Sale")
@Table(name="Sale")
public class Sale {
    @Id
    @SequenceGenerator(name="sale_sequence", allocationSize = 1, sequenceName = "sale_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_sequence")
    @Column(
            name="id",
            updatable = false
    )
    private long id;
    @Column(
            name="name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name="description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;
    @Column(
            name="status"
    )
    @Enumerated(EnumType.STRING)
    private StatusSale status;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    public Sale() {
    }

    public Sale(long id, String name, String description, StatusSale status, Client client) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.client = client;
    }

    public Sale(String name, String description, StatusSale status, Client client) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.client=client;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public StatusSale getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(StatusSale status) {
        this.status = status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
