package com.example.demo.vao;

import com.example.demo.dto.BancniRacunDto;
import com.example.demo.dto.OsebaDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class BancniRacun {

    public BancniRacunDto toDto() {
        BancniRacunDto dto = new BancniRacunDto();
        dto.setCasOdprtja(getCasOdprtja());
        dto.setCasZaprtja(getCasZaprtja());
        dto.setKomitent(getKomitent());
        dto.setZnesek(getZnesek());
        dto.setStevilkaRacuna(getStevilkaRacuna());
        return dto;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String stevilkaRacuna;

    private BigDecimal znesek;
    private LocalDateTime casOdprtja;
    private LocalDateTime casZaprtja;

    @ManyToOne
    private Oseba komitent;

    public String getStevilkaRacuna() {
        return stevilkaRacuna;
    }

    public void setStevilkaRacuna(String stevilkaRacuna) {
        this.stevilkaRacuna = stevilkaRacuna;
    }

    public BigDecimal getZnesek() {
        return znesek;
    }

    public void setZnesek(BigDecimal znesek) {
        this.znesek = znesek;
    }

    public LocalDateTime getCasOdprtja() {
        return casOdprtja;
    }

    public void setCasOdprtja(LocalDateTime casOdprtja) {
        this.casOdprtja = casOdprtja;
    }

    public LocalDateTime getCasZaprtja() {
        return casZaprtja;
    }

    public void setCasZaprtja(LocalDateTime casZaprtja) {
        this.casZaprtja = casZaprtja;
    }

    public Oseba getKomitent() {
        return komitent;
    }

    public void setKomitent(Oseba komitent) {
        this.komitent = komitent;
    }
}
