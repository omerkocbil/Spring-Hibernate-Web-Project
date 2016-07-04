package com.omerkocbil.dao;

/**
 * Created by jan on 29.06.2016.
 */

import java.util.List;

import com.sun.istack.internal.NotNull;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omerkocbil.model.Personel;

import javax.faces.bean.ManagedBean;

@Repository
@ManagedBean(name= "personelDao")// Bu annotation sayesinde bu sınıf DAO olarak muamele görür
public class PersonelDAOImpl implements PersonelDAO {

    private static final Logger logger = LoggerFactory.getLogger(PersonelDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    Session session;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String personelEkle(Personel personel) {
        session = sessionFactory.getCurrentSession();
        session.persist(personel);
        logger.info("Personel eklendi. Bilgisi: " + personel);
        return "tumkayitlar?faces-redirect=true";
    }

    @Override
    public List<Personel> personelAra() {
        session = this.sessionFactory.getCurrentSession();
        List<Personel> personelList = session.createQuery("FROM Personel").list();
        for(Personel p : personelList){
            logger.info("Personel Bilgisi: " + p);
        }
        return personelList;
    }

    @Override
    public List<Personel> personelAra(Personel personel) {
        session = this.sessionFactory.getCurrentSession();
        String hql = "FROM Personel P WHERE P.adi LIKE :personelAdi AND P.soyadi LIKE :personelSoyadi";
        Query sorgu = session.createQuery(hql);
        sorgu.setString("personelAdi", personel.getAdi() + "%");
        sorgu.setString("personelSoyadi", personel.getSoyadi() + "%");
        List<Personel> personelList = sorgu.list();
        for(Personel p : personelList){
            logger.info("Personel Bilgisi: " + p);
        }
        return personelList;
    }

    @Override
    public String personelDuzenle(Personel personel) {
        session = this.sessionFactory.getCurrentSession();
        session.update(personel);
        logger.info("Personel güncellendi. Bilgisi: " + personel);
        return "listele?faces-redirect=true";
    }

    @Override
    public String personelSil(Personel personel) {
        session = this.sessionFactory.getCurrentSession();
        session.delete(personel);
        logger.info("Personel silindi. Bilgisi: " + personel);
        return "listele?faces-redirect=true";
    }

}

