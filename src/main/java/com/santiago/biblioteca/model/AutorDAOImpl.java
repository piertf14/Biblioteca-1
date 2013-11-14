/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Autor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ginna
 */
@Repository("autorDAO")
public class AutorDAOImpl implements AutorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Autor> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Autor> autores = session.createQuery("from Autor").list();
        session.getTransaction().commit();
        return autores;
    }

    @Override
    public Integer save(Autor autor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(autor);
        session.getTransaction().commit();
        return autor.getId();
    }

    @Override
    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Autor autor = (Autor) session.load(Autor.class, id);
        session.delete(autor);
        session.getTransaction().commit();
    }

    @Override
    public Autor get(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Autor autor = (Autor) session.get(Autor.class, id);
        session.getTransaction().commit();
        return autor;
    }

}
