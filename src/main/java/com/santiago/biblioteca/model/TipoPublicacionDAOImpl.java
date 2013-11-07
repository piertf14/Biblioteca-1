/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Tipopublicacion;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ginna
 */
@Repository("tipoPublicacionDAO")
public class TipoPublicacionDAOImpl implements TipoPublicacionDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Tipopublicacion> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Tipopublicacion> tipoPublicaciones = session.createQuery("from tipopublicacion").list();
        session.getTransaction().commit();
        return tipoPublicaciones;
    }

    @Override
    public Integer save(Tipopublicacion tipopublicacion) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(tipopublicacion);
        session.getTransaction().commit();
        return tipopublicacion.getId();
    }

    @Override
    public void remove(int id) {
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        Tipopublicacion tipopublicacion=(Tipopublicacion)session.load(Tipopublicacion.class, id);
        session.delete(tipopublicacion);
        session.getTransaction().commit();
    }

    @Override
    public Tipopublicacion get(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Tipopublicacion tipopublicacion=(Tipopublicacion)session.get(Tipopublicacion.class, id);
        session.getTransaction().commit();
        return tipopublicacion;
    }
    
}
