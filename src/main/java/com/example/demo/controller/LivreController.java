package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Livre;
import com.example.demo.service.LivreService;
 
@RestController
@RequestMapping("/emsi_api/livres")
public class LivreController {
@Autowired
    private LivreService service;
 
    @SuppressWarnings("unchecked")
	@GetMapping("/List")
    public List<Livre> getAll(){
        return (List<Livre>) service.listAll();
    }
 
    @GetMapping("/new")
   public void add(Livre l) {
    	//service.save(l);
    }
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLivre(@ModelAttribute("Livre") Livre lvr) {
        service.save(lvr);
        return "redirect:/";
    }
 
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditLivrePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Livre lvr = service.get(id);
        mav.addObject("Livre", lvr);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deleteLivre(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
    
    @PostMapping
    public Livre create(@RequestBody Livre livre) {
    	return service.create(livre);
    }
}
