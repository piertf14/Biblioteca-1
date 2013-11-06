/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Tipopublicacion;
import java.util.List;

/**
 *
 * @author ginna
 */
public interface TipoPublicacionDAO {
    public List<Tipopublicacion> getAll();
    public Integer save(Tipopublicacion tipopublicacion);
    public void remove(int id);
    public Tipopublicacion get(int id);
}
