/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Ejemplar;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ginna
 */
@Repository("ejemplarDAO")
public class EjemplarDAOImpl implements EjemplarDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Ejemplar> getAll() {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Ejemplar> ejemplares=session.createQuery("from ejemplar").list();
        session.getTransaction().commit();
        return ejemplares;
    }

    @Override
    public Integer save(Ejemplar ejemplar) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(ejemplar);
        session.getTransaction().commit();
        return ejemplar.getId();
    }

    @Override
    public void remove(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Ejemplar ejemplar= (Ejemplar)session.get(Ejemplar.class, id);
        session.delete(ejemplar);
        session.getTransaction().commit();
        
    }

    @Override
    public Ejemplar get(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Ejemplar ejemplar=(Ejemplar)session.get(Ejemplar.class, id);
        session.getTransaction().commit();
        return ejemplar;
    }
    
}
