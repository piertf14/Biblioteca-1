/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.controller;

import com.santiago.biblioteca.bean.Multa;
import com.santiago.biblioteca.service.MultaService;
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
@RequestMapping("/multa")
public class MultaController {
    
    @Autowired
    private MultaService multaService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        List<Multa> multas = multaService.getAll();
        model.addAttribute("multas", multas);
        return "multa.index";
    }
    
    @RequestMapping(value = "/agregar",  method = RequestMethod.GET)
    public String agregar(Model model){
        Multa multa = new Multa();
        model.addAttribute("multa", multa);
        return "multa.agregar_editar";
    }
    
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(Model model, @PathVariable("id") Integer id){
        Multa multa = multaService.get(id);
        model.addAttribute("multa", multa);
        return "multa.agregar_editar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.GET)
    public String no_guardar(){
        return "redirect:agregar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(
            Model model, 
            @ModelAttribute Multa multa,
            BindingResult result,
            RedirectAttributes redirect
    ){
        if(result.hasErrors()){
            model.addAttribute("multa", multa);
            return "multa.agregar_editar";
        }
        int id = multaService.save(multa);
        redirect.addFlashAttribute("messages", new String[]{
            "Guardado correctamente"
        });
        return "redirect:editar/"+id;
    }
}
