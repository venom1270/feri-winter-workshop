package com.example.demo.dto;

import com.example.demo.vao.Oseba;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonInclude(value = Include.NON_NULL)
public class BancniRacunDto {

    private String stevilkaRacuna;
    private BigDecimal znesek;
    private LocalDateTime casOdprtja;
    private LocalDateTime casZaprtja;
    private Oseba komitent;

    @Override
    public String toString() {
        return "BancniRacunDto{" +
                "stevilkaRacuna='" + stevilkaRacuna + '\'' +
                ", znesek=" + znesek +
                ", casOdprtja=" + casOdprtja +
                ", casZaprtja=" + casZaprtja +
                ", komitent=" + komitent +
                '}';
    }

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
