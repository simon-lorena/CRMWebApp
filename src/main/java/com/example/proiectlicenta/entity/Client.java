package com.example.proiectlicenta.entity;

import jakarta.persistence.*;

@Entity(name="Client")
@Table(name="Client",
        uniqueConstraints = {
        @UniqueConstraint(name="client_CUI_unique",columnNames = "CUI")
        }
)
public class Client {
    @Id
    @SequenceGenerator(
    name="client_sequence", sequenceName = "client_sequence", allocationSize =1
            )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "client_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;
    @Column(
            name="CUI",
            nullable = false
    )
    private Long CUI;
    @Column(
            name="name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name="website",
            columnDefinition = "TEXT"

    )
    private String webSite;
    @OneToOne
    @JoinColumn(name="person_id")
    private Person person;

    public Client() {
    }

    public Client(Long id, Long CUI, String name, String webSite, Person person) {
        this.id = id;
        this.CUI = CUI;
        this.name = name;
        this.webSite = webSite;
        this.person = person;
    }

    public Client(Long CUI, String name, String webSite, Person person) {
        this.CUI = CUI;
        this.name = name;
        this.webSite = webSite;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public Long getCUI() {
        return CUI;
    }

    public void setCUI(Long CUI) {
        this.CUI = CUI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", CUI=" + CUI +
                ", name='" + name + '\'' +
                ", webSite='" + webSite + '\'' +
                ", person=" + person +
                '}';
    }
}
