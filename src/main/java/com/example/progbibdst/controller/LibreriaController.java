package com.example.progbibdst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.progbibdst.model.Libro;
import com.example.progbibdst.service.LibroService;



@Controller
public class LibreriaController {

	@Autowired
	private LibroService libroservice;
	
	 @RequestMapping("/")
	    public String viewHomePage(Model model) {
	        List<Libro> listBooks= libroservice.getAll();
	        model.addAttribute("listBooks", listBooks);
	         
	        return "home";
	    }
	
	  @RequestMapping("/delete/{id}")
	    public String deleteLibro(@PathVariable(name = "id") int id) {
	        libroservice.delete(id);
	        return "redirect:/";       
	    }
	  
	  
	  @GetMapping("/edit/{id}")
	  public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
	      Libro libro = libroservice.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("Invalid book id:" + id));

	      model.addAttribute("libro", libro);
	      return "editBook";
	  }
	  
	  @PostMapping("/update/{id}")
	  public String updateLibro(@PathVariable("id") Integer id, Libro libro, 
	    BindingResult result, Model model) {
	      if (result.hasErrors()) {
	          libro.setId(id);
	          System.out.println("Errore");
	          return "editBook";
	      }

	      libroservice.add(libro);
	      return "redirect:/";
	  }
	  
//	  @RequestMapping("/edit/{id}")
//	    public ModelAndView showEditBookPage(@PathVariable(name = "id") int id) {
//	        ModelAndView mav = new ModelAndView("editBook");
//	        Libro libro = libroservice.getById(id);
//	        mav.addObject("libro", libro);
//	         
//	        return mav;
//	    }
	  
//	  @RequestMapping(value = "/update", method = RequestMethod.POST)
//	    public String updateBook(@ModelAttribute("libro") Libro libro) {
//		  libroservice.delete(libro.getId());   
//		  libroservice.add(libro);
//	        
//	         
//	        return "redirect:/";
//	    }
	  
	  
	  
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveBook(@ModelAttribute("libro") Libro libro) {
		  libroservice.add(libro);
	         
	        return "redirect:/";
	    }
	  
	  
	  @RequestMapping("/new")
	    public String showNewBookPage(Model model) {
	        Libro libro = new Libro();
	        model.addAttribute("libro", libro);
	         
	        return "newBook";
	    }
	  
}



