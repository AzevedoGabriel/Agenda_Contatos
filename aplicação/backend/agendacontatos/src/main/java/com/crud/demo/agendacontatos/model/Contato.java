package com.crud.demo.agendacontatos.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Contato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String apelido;
    private String telefone;
    private String imageUrl;
    private String corFavorita;

    public Contato() {}

    public Contato(String name, String email, String apelido, String telefone, String imageUrl, String corFavorita) {
        this.name = name;
        this.email = email;
        this.apelido = apelido;
        this.telefone = telefone;
        this.imageUrl = imageUrl;
        this.corFavorita = corFavorita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCorFavorita() {
        return corFavorita;
    }

    public void setCorFavorita(String corFavorita) {
        this.corFavorita = corFavorita;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", apelido='" + apelido + '\'' +
                ", telefone='" + telefone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", corFavorita='" + corFavorita + '\'' +
                '}';
    }
}
