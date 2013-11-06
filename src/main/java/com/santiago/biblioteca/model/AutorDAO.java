/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Autor;
import java.util.List;

/**
 *
 * @author ginna
 */
public interface AutorDAO {
    public List<Autor> getAll();
    public Integer save(Autor autor);
    public void remove(int id);
    public Autor get(int id);
}
