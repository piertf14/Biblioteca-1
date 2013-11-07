/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.model;

import com.santiago.biblioteca.bean.Multa;
import java.util.List;

/**
 *
 * @author ginna
 */
public interface MultaDAO {
    public List<Multa> getAll();
    public Integer save(Multa multa);
    public void remove(int id);
    public Multa get(int id);
}
