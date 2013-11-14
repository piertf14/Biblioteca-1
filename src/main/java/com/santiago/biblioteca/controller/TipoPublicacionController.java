package com.santiago.biblioteca.controller;

import com.santiago.biblioteca.bean.Publicacion;
import com.santiago.biblioteca.bean.Tipopublicacion;
import com.santiago.biblioteca.service.TipoPublicacionService;
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

/**
 *
 * @author ginna
 */

@Controller
@RequestMapping(value = "/tipoPublicacion")
public class TipoPublicacionController {
    
    @Autowired
    private TipoPublicacionService tipoPublicacionService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        List<Tipopublicacion> Tipospublicacion = tipoPublicacionService.getAll();
        model.addAttribute("tipospublicacion", Tipospublicacion);
        return "tipoPublicacion.index";
    }
    
    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String agregar(Model model){
        Tipopublicacion tipopublicacion = new Tipopublicacion();
        model.addAttribute("tipopublicacion", tipopublicacion);
        return "tipoPublicacion.agregar_editar";
    }
    
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(Model model, @PathVariable Integer id){
        Tipopublicacion tipoPublicacion = tipoPublicacionService.get(id);
        model.addAttribute("tipopublicacion", tipoPublicacion);
        return "tipoPublicacion.agregar_editar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.GET)
    public String no_guardar(){
        return "redirect:agregar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(
            Model model, 
            @ModelAttribute @Valid Tipopublicacion tipopublicacion,
            BindingResult result
    ){
        if(result.hasErrors()){
            model.addAttribute("tipopublicacion", tipopublicacion);
            return "tipoPublicacion.form";
        }
        tipoPublicacionService.save(tipopublicacion);
        int id = tipopublicacion.getId();
        return "redirect:editar/"+id;
    }
}
