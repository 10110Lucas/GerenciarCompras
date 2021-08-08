package br.com.GerenciarCompras.model.bean;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	private String username;
	private String password;
	private boolean enabled;
	private LocalDateTime dataCriacao;
	
	public User() { }

	public User(String username, String password, boolean enabled, LocalDateTime dataCriacao) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.dataCriacao = dataCriacao;
	}

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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}