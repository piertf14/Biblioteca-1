/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Tipousuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ginna
 */
@Repository("tipoUsuarioDAO")
public class TipoUsuarioImpl implements TipoUsuarioDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Tipousuario> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Tipousuario> tipousuarios = session.createQuery("from tipousuario").list();
        session.getTransaction().commit();
        return tipousuarios;
    }

    @Override
    public Integer save(Tipousuario tipousuario) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(tipousuario);
        session.getTransaction().commit();
        return tipousuario.getId();
    }

    @Override
    public void remove(int id) {
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        Tipousuario tipousuario=(Tipousuario)session.load(TipoPublicacionDAO.class, id);
        session.delete(tipousuario);
        session.getTransaction().commit();
    }

    @Override
    public Tipousuario get(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Tipousuario tipousuario=(Tipousuario)session.get(Tipousuario.class, id);
        session.getTransaction().commit();
        return tipousuario;
    }
    
}
