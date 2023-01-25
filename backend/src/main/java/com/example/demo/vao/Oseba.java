package com.example.demo.vao;

import com.example.demo.dto.OsebaDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Oseba {

    public OsebaDto toDto() {
        OsebaDto dto = new OsebaDto();
        dto.setIdKomitenta(getIdKomitenta());
        dto.setIme(getIme());
        dto.setPriimek(getPriimek());
        dto.setEmail(getEmail());
        dto.setId(getId());
        return dto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String ime;
    private String priimek;
    private String email;
    private String idKomitenta;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdKomitenta() {
        return idKomitenta;
    }

    public void setIdKomitenta(String idKomitenta) {
        this.idKomitenta = idKomitenta;
    }

    @Override
    public String toString() {
        return "Oseba{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                ", email='" + email + '\'' +
                ", idKomitenta='" + idKomitenta + '\'' +
                '}';
    }
}
