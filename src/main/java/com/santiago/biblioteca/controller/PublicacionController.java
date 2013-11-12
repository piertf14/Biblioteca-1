/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.controller;

import com.santiago.biblioteca.bean.Publicacion;
import com.santiago.biblioteca.bean.Tipopublicacion;
import com.santiago.biblioteca.service.PublicacionService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gianfranco
 */

@Controller
@RequestMapping(value = "/publicacion")
public class PublicacionController {
    
    @Autowired
    private PublicacionService publicacionService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        List<Publicacion> publicaciones = publicacionService.listar();
        model.addAttribute("publicaciones", publicaciones);
        return "publicacion.index";
    }
    
    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String agregar(Model model){
        Publicacion publicacion = new Publicacion();
        List<Tipopublicacion> tipospublicacion = new ArrayList<Tipopublicacion>();
        model.addAttribute("publicacion", publicacion);
        model.addAttribute("tipospublicacion", tipospublicacion);
        return "publicacion.form";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(
            Model model, 
            @Valid Publicacion publicacion,
            BindingResult result
    ){
        if(result.hasErrors()){
            return "publicacion.form";
        }
        return "redirect:";
    }
}
