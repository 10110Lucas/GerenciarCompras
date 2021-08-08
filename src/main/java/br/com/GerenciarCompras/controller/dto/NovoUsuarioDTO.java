package br.com.GerenciarCompras.controller.dto;

import javax.validation.constraints.NotBlank;

import br.com.GerenciarCompras.model.bean.User;


public class NovoUsuarioDTO {
	
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toUser() {
		return new User(this.username, this.password, false);
	}
}