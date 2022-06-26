package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		//redirigir a ruta interna
		//return "redirect:/index";
		
		//redirigir a ruta externa
		//return "redirect:https://www.google.com";
		
		//sin reiniciar el request, realiza el dispatcher en el mismo request
		//la ruta URL no cambia, no se puede hacer forward a rutas externas 
		return "forward:/index";
	}
}
