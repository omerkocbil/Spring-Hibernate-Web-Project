package com.omerkocbil.dao;

import com.omerkocbil.model.Personel;

import java.util.List;

/**
 * Created by jan on 29.06.2016.
 */
public interface PersonelDAO {

    String personelEkle(Personel personel);

    List<Personel> personelAra();

    List<Personel> personelAra(Personel personel);

    String personelDuzenle(Personel personel);

    String personelSil(Personel personel);

}
