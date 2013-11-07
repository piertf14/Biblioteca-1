/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.service;

import com.santiago.biblioteca.bean.Reserva;
import com.santiago.biblioteca.model.ReservaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ginna
 */
@Service("reservaService")
public class ReservaService {
    @Autowired
    private ReservaDAO reservaDAO;
    
    public List<Reserva> getAll(){
        return reservaDAO.getAll();
    }
    
    public Integer save(Reserva reserva){
        return reservaDAO.save(reserva);
    }
    
    public Reserva get(int id){
        return reservaDAO.get(id);
    }
    
    public void remove(int id){
        reservaDAO.remove(id);
    }
    
}
