/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.service;

import com.santiago.biblioteca.bean.Multa;
import com.santiago.biblioteca.model.MultaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ginna
 */
@Service("multaService")
public class MultaService {
    @Autowired
    private MultaDAO multaDAO;
    
    public List<Multa> getAll(){
        return multaDAO.getAll();
    }
    
    public Integer save(Multa multa){
        return multaDAO.save(multa);
    }
    
    public Multa get(int id){
        return multaDAO.get(id);
    }
    
    public void remove(int id){
        multaDAO.remove(id);
    }
    
}
