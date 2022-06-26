package com.bolsadeideas.springboot.web.app.controller;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;
//import org.springframework.web.servlet.ModelAndView;

//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	// @RequestMapping(value="/index", method = RequestMethod.GET)
	@GetMapping({ "/index", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		//model.addAttribute("titulo", "SpringBoot usando Model");
		return "index";
		/*
		 * public String index(Map<String, Object> map) { //map.put("titulo",
		 * "Monas chinas usando Map"); return "index";
		 */

		/*
		 * public ModelAndView index(ModelAndView mv) { mv.addObject("titulo",
		 * "Monas chinas usando ModelAndView"); mv.setViewName("index"); return mv;
		 */
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jorge");
		usuario.setApellido("Moreno");
		usuario.setEmail("andresmo99@outlook.com");
		model.addAttribute("usuario", usuario);
		//model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		// Otra forma de agregar a la lista
		// List<Usuario> usuarios = Arrays.asList(new Usuario("Goku", "Son",
		// "kame@outlook.com"));

		//model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("titulo", textoListar);
		// model.addAttribute("usuarios", usuarios);
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Jorge", "Moreno", "andresmo99@outlook.com"));
		usuarios.add(new Usuario("Andrés", "Guzman", "ag1986@outlook.com"));
		usuarios.add(new Usuario("Adriana", "Ballesteros", "ardillota@outlook.com"));
		usuarios.add(new Usuario("Goku", "Son", "kame@outlook.com"));
		return usuarios;
	}

}
