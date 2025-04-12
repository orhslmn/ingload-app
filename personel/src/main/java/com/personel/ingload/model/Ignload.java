package com.personel.ingload.model;

import jakarta.persistence.*;

@Entity
@Table(name="Ignload")
public class Ignload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kelime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKelime() {
        return kelime;
    }

    public void setKelime(String kelime) {
        this.kelime = kelime;
    }
}
