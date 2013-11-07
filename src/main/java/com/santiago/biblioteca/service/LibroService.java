/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.service;

import com.santiago.biblioteca.bean.Libro;
import com.santiago.biblioteca.model.LibroDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ginna
 */
@Service("libroService")
public class LibroService {
    @Autowired
    private LibroDAO libroDAO;
    
    public List<Libro> getAll(){
        return libroDAO.getAll();
    }
    
    public Integer save(Libro libro){
        return libroDAO.save(libro);
    }
    
    public Libro get(int id){
        return libroDAO.get(id);
    }
    
    public void remove(int id){
        libroDAO.remove(id);
    }
    
}
