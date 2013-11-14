/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.santiago.biblioteca.controller;

import com.santiago.biblioteca.bean.Autor;
import com.santiago.biblioteca.bean.Tipopublicacion;
import com.santiago.biblioteca.service.AutorService;
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
@RequestMapping("/autor")
public class AutorController {
    
    @Autowired
    private AutorService autorService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        List<Autor> autores = autorService.getAll();
        model.addAttribute("autores", autores);
        return "autor.index";
    }
    
    @RequestMapping(value = "/agregar",  method = RequestMethod.GET)
    public String agregar(Model model){
        Autor autor = new Autor();
        model.addAttribute("autor", autor);
        return "autor.agregar_editar";
    }
    
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(Model model, @PathVariable("id") Integer id){
        Autor autor = new Autor();
        model.addAttribute("autor", autor);
        return "autor.agregar_editar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.GET)
    public String no_guardar(){
        return "redirect:agregar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(
            Model model, 
            @ModelAttribute @Valid Autor autor,
            BindingResult result,
            RedirectAttributes redirect
    ){
        if(result.hasErrors()){
            model.addAttribute("autor", autor);
            return "autor.agregar_editar";
        }
        int id = autorService.save(autor);
        redirect.addFlashAttribute("messages", new String[]{
            "Guardado correctamente"
        });
        return "redirect:editar/"+id;
    }
}
