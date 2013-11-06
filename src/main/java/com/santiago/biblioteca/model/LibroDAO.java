/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Libro;
import java.util.List;

/**
 *
 * @author ginna
 */
public interface LibroDAO {
    public List<Libro> getAll();
    public Integer save(Libro libro);
    public void remove(int id);
    public Libro get(int id);
}
