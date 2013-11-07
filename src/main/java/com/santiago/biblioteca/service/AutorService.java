/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.service;

import com.santiago.biblioteca.bean.Autor;
import com.santiago.biblioteca.model.AutorDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ginna
 */
@Service("autorService")
public class AutorService {
    @Autowired
    private AutorDAO autorDAO;
    
    public List<Autor> getAll(){
        return autorDAO.getAll();
    }
    
    public Integer save(Autor autor){
        return autorDAO.save(autor);
    }
    
    public Autor get(int id){
        return autorDAO.get(id);
    }
    
    public void remove(int id){
        autorDAO.remove(id);
    }
    
}
