package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;

import java.security.Security;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long portfolioId;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    public Portfolio() {}

    public Portfolio(LocalDate creationDate, Client client, List<Security> securities) {
        this.creationDate = creationDate;
        this.client = client;
        this.securities = securities;
    }

    public Long getPortfolioId() { return portfolioId; }

    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }



}
