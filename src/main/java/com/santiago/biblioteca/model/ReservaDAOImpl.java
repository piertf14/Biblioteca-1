/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Reserva;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ginna
 */
@Repository("reservaDAO")
public class ReservaDAOImpl implements ReservaDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Reserva> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Reserva> reservas = session.createQuery("from Reserva").list();
        session.getTransaction().commit();
        return reservas;
    }

    @Override
    public Integer save(Reserva reserva) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(reserva);
        session.getTransaction().commit();
        return reserva.getId();
    }

    @Override
    public void remove(int id) {
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        Reserva reserva=(Reserva)session.load(Reserva.class, id);
        session.delete(reserva);
        session.getTransaction().commit();
    }

    @Override
    public Reserva get(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Reserva reserva=(Reserva)session.get(Reserva.class, id);
        session.getTransaction().commit();
        return reserva;
    }
    
}
