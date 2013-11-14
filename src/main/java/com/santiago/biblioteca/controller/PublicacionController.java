/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.controller;

import com.santiago.biblioteca.bean.Publicacion;
import com.santiago.biblioteca.bean.Tipopublicacion;
import com.santiago.biblioteca.service.PublicacionService;
import com.santiago.biblioteca.service.TipoPublicacionService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ginna
 */

@Controller
@RequestMapping(value = "/publicacion")
public class PublicacionController {
    
    @Autowired
    private PublicacionService publicacionService;
    
    @Autowired
    private TipoPublicacionService tipoPublicacionService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        List<Publicacion> publicaciones = publicacionService.getAll();
        model.addAttribute("publicaciones", publicaciones);
        return "publicacion.index";
    }
    
    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String agregar(Model model){
        Publicacion publicacion = new Publicacion();
        List<Tipopublicacion> tipospublicacion = tipoPublicacionService.getAll();
        model.addAttribute("publicacion", publicacion);
        model.addAttribute("tipospublicacion", tipospublicacion);
        return "publicacion.agregar_editar";
    }
    
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(Model model, @PathVariable Integer id){
        Publicacion publicacion = publicacionService.get(id);
        model.addAttribute("publicacion", publicacion);
        List<Tipopublicacion> tipospublicacion = tipoPublicacionService.getAll();
        model.addAttribute("tipospublicacion", tipospublicacion);
        return "publicacion.agregar_editar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.GET)
    public String no_guardar(){
        return "redirect:agregar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(
            Model model, 
            @ModelAttribute @Valid Publicacion publicacion,
            BindingResult result,
            RedirectAttributes redirect
    ){
        if(result.hasErrors()){
            List<Tipopublicacion> tipospublicacion = tipoPublicacionService.getAll();
            model.addAttribute("tipospublicacion", tipospublicacion);
            return "publicacion.agregar_editar";
        }
        int id = publicacionService.save(publicacion);
        
        redirect.addFlashAttribute(
                "messages", 
                new String[]{
                    "Guardado corretamente."
                }
        );
        return "redirect:editar/"+id;
    }
    
}
