/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Usuario;
import java.util.List;

/**
 *
 * @author ginna
 */
public interface UsuarioDAO {
    public List<Usuario> getAll();
    public Integer save(Usuario usuario);
    public void remove(int id);
    public Usuario get(int id);
}
