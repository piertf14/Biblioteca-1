/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.service;

import com.santiago.biblioteca.bean.Tipousuario;
import com.santiago.biblioteca.model.TipoUsuarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ginna
 */
@Service("tipoUsuarioService")
public class TipoUsuarioService {
    @Autowired
    private TipoUsuarioDAO tipoUsuarioDAO;
    
    public List<Tipousuario> getAll(){
        return tipoUsuarioDAO.getAll();
    }
    
    public Integer save(Tipousuario tipousuario){
        return tipoUsuarioDAO.save(tipousuario);
    }
    
    public Tipousuario get(int id){
        return tipoUsuarioDAO.get(id);
    }
    
    public void remove(int id){
        tipoUsuarioDAO.remove(id);
    }
    
}
