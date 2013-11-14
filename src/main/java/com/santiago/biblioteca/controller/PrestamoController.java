/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.controller;

import com.santiago.biblioteca.bean.Prestamo;
import com.santiago.biblioteca.service.PrestamoService;
import java.util.List;
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
@RequestMapping("/prestamo")
public class PrestamoController {
    
    @Autowired
    private PrestamoService prestamoService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        List<Prestamo> prestamos = prestamoService.getAll();
        model.addAttribute("prestamos", prestamos);
        return "prestamo.index";
    }
    
    @RequestMapping(value = "/agregar",  method = RequestMethod.GET)
    public String agregar(Model model){
        Prestamo prestamo = new Prestamo();
        model.addAttribute("prestamo", prestamo);
        return "prestamo.agregar_editar";
    }
    
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(Model model, @PathVariable("id") Integer id){
        Prestamo prestamo = prestamoService.get(id);
        model.addAttribute("prestamo", prestamo);
        return "prestamo.agregar_editar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.GET)
    public String no_guardar(){
        return "redirect:agregar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(
            Model model, 
            @ModelAttribute Prestamo prestamo,
            BindingResult result,
            RedirectAttributes redirect
    ){
        if(result.hasErrors()){
            model.addAttribute("prestamo", prestamo);
            return "prestamo.agregar_editar";
        }
        int id = prestamoService.save(prestamo);
        redirect.addFlashAttribute("messages", new String[]{
            "Guardado correctamente"
        });
        return "redirect:editar/"+id;
    }
}
