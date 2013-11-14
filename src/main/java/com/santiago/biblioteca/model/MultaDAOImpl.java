/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Multa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ginna
 */
@Repository("multaDAO")
public class MultaDAOImpl implements MultaDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Multa> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Multa> multas = session.createQuery("from Multa").list();
        session.getTransaction().commit();
        return multas;
    }

    @Override
    public Integer save(Multa multa) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(multa);
        session.getTransaction().commit();
        return multa.getId();
    }

    @Override
    public void remove(int id) {
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        Multa multa=(Multa)session.load(Multa.class, id);
        session.delete(multa);
        session.getTransaction().commit();
    }

    @Override
    public Multa get(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Multa multa=(Multa)session.get(Multa.class, id);
        session.getTransaction().commit();
        return multa;
    }
    
}
