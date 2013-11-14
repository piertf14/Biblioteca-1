/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ginna
 */
@Repository("usuarioDAO")
public class UsuarioDAOImpl implements UsuarioDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Usuario> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Usuario> usuarios = session.createQuery("from Usuario").list();
        session.getTransaction().commit();
        return usuarios;
    }

    @Override
    public Integer save(Usuario usuario) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(usuario);
        session.getTransaction().commit();
        return usuario.getId();
    }

    @Override
    public void remove(int id) {
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        Usuario usuario=(Usuario)session.load(Usuario.class, id);
        session.delete(usuario);
        session.getTransaction().commit();
    }

    @Override
    public Usuario get(int id) {
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Usuario usuario=(Usuario)session.get(Usuario.class, id);
        session.getTransaction().commit();
        return usuario;
    }
    
}
