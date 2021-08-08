package br.com.GerenciarCompras.controller.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.constraints.NotBlank;

import br.com.GerenciarCompras.model.bean.User;
import lombok.Data;

@Data
public class NovoUsuarioDTO {
	
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	public User toUser() {
		return new User(this.username, this.password, false, LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
	}
}