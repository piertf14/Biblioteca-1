/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.service;

import com.santiago.biblioteca.bean.Usuario;
import com.santiago.biblioteca.model.UsuarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ginna
 */
@Service("usuarioService")
public class UsuarioService {
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    public List<Usuario> getAll(){
        return usuarioDAO.getAll();
    }
    
    public Integer save(Usuario usuario){
        return usuarioDAO.save(usuario);
    }
    
    public Usuario get(int id){
        return usuarioDAO.get(id);
    }
    
    public void remove(int id){
        usuarioDAO.remove(id);
    }
    
}
