/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Tipousuario;
import java.util.List;

/**
 *
 * @author ginna
 */
public interface TipoUsuarioDAO {
    public List<Tipousuario> getAll();
    public Integer save(Tipousuario tipousuario);
    public void remove(int id);
    public Tipousuario get(int id);
}
