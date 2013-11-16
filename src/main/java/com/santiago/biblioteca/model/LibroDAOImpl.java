/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Libro;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ginna
 */
@Repository("libroDAO")
public class LibroDAOImpl implements LibroDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Libro> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Libro> libros = session.createQuery("from Libro").list();
        session.beginTransaction().commit();
        return libros;
    }

    @Override
    public Integer save(Libro libro) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(libro);
        session.beginTransaction().commit();
        return libro.getId();
    }

    @Override
    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Libro libro = (Libro) session.get(Libro.class, id);
        session.delete(libro);
        session.getTransaction().commit();
    }

    @Override
    public Libro get(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Libro libro = (Libro) session.get(Libro.class, id);
        session.getTransaction().commit();
        return libro;
    }

}
