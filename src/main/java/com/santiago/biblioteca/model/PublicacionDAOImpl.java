/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Publicacion;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ginna
 */
@Repository("publicacionDAO")
public class PublicacionDAOImpl implements PublicacionDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Publicacion> getAll() {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Publicacion> publicaciones=session.createQuery("fron publicacion").list();
        session.getTransaction().commit();
        return publicaciones;
    }

    @Override
    public Integer save(Publicacion publicacion) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(publicacion);
        session.getTransaction().commit();
        return publicacion.getId();
    }

    @Override
    public void remove(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Publicacion publicacion=(Publicacion)session.get(Publicacion.class, id);
        session.delete(publicacion);
        session.getTransaction().commit();
    }

    @Override
    public Publicacion get(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Publicacion publicacion=(Publicacion)session.get(Publicacion.class, id);
        session.getTransaction().commit();
        return publicacion;
    }
    
}
