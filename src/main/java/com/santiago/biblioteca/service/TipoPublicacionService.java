/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.service;

import com.santiago.biblioteca.bean.Tipopublicacion;
import com.santiago.biblioteca.model.TipoPublicacionDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ginna
 */
@Service("tipoPublicacionService")
public class TipoPublicacionService {
    @Autowired
    private TipoPublicacionDAO tipoPublicacionDAO;
    
    public List<Tipopublicacion> getAll(){
        return tipoPublicacionDAO.getAll();
    }
    
    public Integer save(Tipopublicacion tipopublicacion){
        return tipoPublicacionDAO.save(tipopublicacion);
    }
    
    public Tipopublicacion get(int id){
        return tipoPublicacionDAO.get(id);
    }
    
    public void remove(int id){
        tipoPublicacionDAO.remove(id);
    }
    
}
