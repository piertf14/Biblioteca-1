/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.service;

import com.santiago.biblioteca.bean.Publicacion;
import com.santiago.biblioteca.model.PublicacionDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ginna
 */
@Service("publicacionService")
public class PublicacionService {
    @Autowired
    private PublicacionDAO publicacionDAO;
    
    public List<Publicacion> getAll(){
        return publicacionDAO.getAll();
    }
    
    public Integer save(Publicacion publicacion){
        return publicacionDAO.save(publicacion);
    }
    
    public Publicacion get(int id){
        return publicacionDAO.get(id);
    }
    
    public void remove(int id){
        publicacionDAO.remove(id);
    }
    
}
