/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.service;

import com.santiago.biblioteca.bean.Prestamo;
import com.santiago.biblioteca.model.PrestamoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ginna
 */
@Service("prestamoService")
public class PrestamoService {
    @Autowired
    private PrestamoDAO prestamoDAO;
    
    public List<Prestamo> getAll(){
        return prestamoDAO.getAll();
    }
    
    public Integer save(Prestamo prestamo){
        return prestamoDAO.save(prestamo);
    }
    
    public Prestamo get(int id){
        return prestamoDAO.get(id);
    }
    
    public void remove(int id){
        prestamoDAO.remove(id);
    }
    
}
