package br.com.GerenciarCompras.model.bean;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

	@Id
	private String username;
	private String password;
	private boolean enabled;
	private LocalDateTime dataCriacao;

	public User(String username, String password, boolean enabled, LocalDateTime dataCriacao) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.dataCriacao = dataCriacao;
	}
}