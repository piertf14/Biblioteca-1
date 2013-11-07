/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.service;

import com.santiago.biblioteca.bean.Ejemplar;
import com.santiago.biblioteca.model.EjemplarDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ginna
 */
@Service("ejemplarService")
public class EjemplarService {
    @Autowired
    private EjemplarDAO ejemplarDAO;
    
    public List<Ejemplar> getAll(){
        return ejemplarDAO.getAll();
    }
    
    public Integer save(Ejemplar ejemplar){
        return ejemplarDAO.save(ejemplar);
    }
    
    public Ejemplar get(int id){
        return ejemplarDAO.get(id);
    }
    
    public void remove(int id){
        ejemplarDAO.remove(id);
    }
    
}
