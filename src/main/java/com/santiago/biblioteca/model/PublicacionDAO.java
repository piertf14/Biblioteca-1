/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Publicacion;
import java.util.List;

/**
 *
 * @author ginna
 */
public interface PublicacionDAO {
    public List<Publicacion> getAll();
    public Integer save(Publicacion publicacion);
    public void remove(int id);
    public Publicacion get(int id);
}
