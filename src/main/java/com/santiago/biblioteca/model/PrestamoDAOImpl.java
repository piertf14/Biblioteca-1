/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Prestamo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ginna
 */
@Repository("prestamoDAO")
public class PrestamoDAOImpl implements PrestamoDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Prestamo> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Prestamo> prestamos = session.createQuery("from Prestamo").list();
        session.getTransaction().commit();
        return prestamos;
    }

    @Override
    public Integer save(Prestamo prestamo) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(prestamo);
        session.getTransaction().commit();
        return prestamo.getId();
    }

    @Override
    public void remove(int id) {
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        Prestamo prestamo=(Prestamo)session.load(Prestamo.class, id);
        session.delete(prestamo);
        session.getTransaction().commit();
    }

    @Override
    public Prestamo get(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Prestamo prestamo=(Prestamo)session.get(Prestamo.class, id);
        session.getTransaction().commit();
        return prestamo;
    }
    
}
