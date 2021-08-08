package br.com.GerenciarCompras.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.GerenciarCompras.controller.dto.NovoUsuarioDTO;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {

	
	@PostMapping("cadastrar")
	public String cadastrar(@Valid NovoUsuarioDTO requisicao, BindingResult result) {
		if (result.hasErrors()) {
			return "newUsuario";
		}
		System.out.println("Usuario: "+requisicao.toString());
		return "inicial/home";
	}
}