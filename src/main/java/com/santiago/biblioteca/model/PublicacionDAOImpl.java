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
    private SessionFactory SessionFactory;
    
    @Override
    public List<Publicacion> getAll() {
        Session session = SessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Publicacion> publicaciones = session.createQuery("from Publicacion").list();
        session.getTransaction().commit();
        return publicaciones;
    }

    @Override
    public Integer save(Publicacion publicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publicacion get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
