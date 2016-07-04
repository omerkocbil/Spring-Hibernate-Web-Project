package com.omerkocbil.service;

/**
 * Created by jan on 29.06.2016.
 */

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.omerkocbil.dao.PersonelDAO;
import com.omerkocbil.model.Personel;

@Service // Bu annotation bu sınıfın service katmanı olarak muamele görmesini sağlıyor
@ManagedBean(name="personelService")
@SessionScoped
public class PersonelServiceImpl implements PersonelService {

    @Autowired
    private PersonelDAO personelDao;

    public void setPersonelDao(PersonelDAO personelDao){
        this.personelDao = personelDao;
    }

    @Override
    @Transactional
    public String personelEkle(Personel personel) {
        return personelDao.personelEkle(personel);
    }

    @Override
    @Transactional
    public List<Personel> personelAra() {
        return this.personelDao.personelAra();
    }

    @Override
    @Transactional
    public List<Personel> personelAra(Personel personel) {
        return this.personelDao.personelAra(personel);
    }

    @Override
    @Transactional
    public String personelDuzenle(Personel personel) {
        return this.personelDao.personelDuzenle(personel);
    }

    @Override
    @Transactional
    public String personelSil(Personel personel) {
        return this.personelDao.personelSil(personel);
    }

}

