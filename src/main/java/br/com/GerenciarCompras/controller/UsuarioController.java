package br.com.GerenciarCompras.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.GerenciarCompras.controller.dto.NovoUsuarioDTO;
import br.com.GerenciarCompras.service.UserService;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {
	
	@Autowired
	private UserService userService;

	@GetMapping("novo-usuario")
	public String acessarFormulario(Model model) {
		model.addAttribute("novoUsuarioDTO", new NovoUsuarioDTO());
		return "newUsuario";
	}
	
	@PostMapping
	public String cadastrar(@Valid NovoUsuarioDTO req, BindingResult result) {
		if (result.hasErrors()) {
			return "newUsuario";
		}
		userService.criarUsuario(req.toUser());
		return "login";
	}
}