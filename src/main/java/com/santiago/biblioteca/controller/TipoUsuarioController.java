package com.santiago.biblioteca.controller;

import com.santiago.biblioteca.bean.Tipousuario;
import com.santiago.biblioteca.service.TipoUsuarioService;
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
@RequestMapping(value = "/tipoUsuario")
public class TipoUsuarioController {
    
    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        List<Tipousuario> tiposusuario = tipoUsuarioService.getAll();
        model.addAttribute("tiposusuario", tiposusuario);
        return "tipoUsuario.index";
    }
    
    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String agregar(Model model){
        Tipousuario tipopublicacion = new Tipousuario();
        model.addAttribute("tipopublicacion", tipopublicacion);
        return "tipoUsuario.agregar_editar";
    }
    
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(Model model, @PathVariable Integer id){
        Tipousuario tipoUsuario = tipoUsuarioService.get(id);
        model.addAttribute("tipopublicacion", tipoUsuario);
        return "tipoUsuario.agregar_editar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.GET)
    public String no_guardar(){
        return "redirect:agregar";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(
            Model model, 
            @ModelAttribute @Valid Tipousuario tipopublicacion,
            BindingResult result,
            RedirectAttributes redirect
    ){
        if(result.hasErrors()){
            model.addAttribute("tipopublicacion", tipopublicacion);
            return "tipoUsuario.form";
        }
        tipoUsuarioService.save(tipopublicacion);
        int id = tipopublicacion.getId();
        redirect.addFlashAttribute("messages", new String[]{
            "Guardado correctamente"
        });
        return "redirect:editar/"+id;
    }
}
