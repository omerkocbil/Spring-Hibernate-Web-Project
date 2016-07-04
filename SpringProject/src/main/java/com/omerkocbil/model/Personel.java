package com.omerkocbil.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ömer Koçbil
 */
@Entity
@Table(name = "personel")
@ManagedBean(name = "personel")
@RequestScoped
public class Personel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numarasi;
    private String adi;
    private String soyadi;
    private String cinsiyeti;
    private String eposta;
    private String parolasi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumarasi() {
        return numarasi;
    }

    public void setNumarasi(int numarasi) {
        this.numarasi = numarasi;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getCinsiyeti() {
        return cinsiyeti;
    }

    public void setCinsiyeti(String cinsiyeti) {
        this.cinsiyeti = cinsiyeti;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getParolasi() {
        return parolasi;
    }

    public void setParolasi(String parolasi) {
        this.parolasi = parolasi;
    }

    @Override
    public String toString(){
        return "Personel \n" +
                "Adı Soyadı : " + adi + soyadi + "\n" +
                "E-Posta : " + eposta + "\n" +
                "Numara : " + numarasi + "\n" +
                "Parola : " + parolasi;
    }

}

