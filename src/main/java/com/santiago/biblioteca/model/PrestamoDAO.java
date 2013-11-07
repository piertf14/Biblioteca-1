/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Prestamo;
import java.util.List;

/**
 *
 * @author ginna
 */
public interface PrestamoDAO {
    public List<Prestamo> getAll();
    public Integer save(Prestamo prestamo);
    public void remove(int id);
    public Prestamo get(int id);
    
}
