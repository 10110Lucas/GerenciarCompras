package br.com.GerenciarCompras.model.bean;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private BigDecimal valor;
	@NotNull
	private int qtdade;
	private String descricao;
	private String urlImagem;

	public Produto(Long id, @NotNull String nome, @NotNull BigDecimal valor, @NotNull int qtdade, String descricao,
			String urlImagem) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.qtdade = qtdade;
		this.descricao = descricao;
		this.urlImagem = urlImagem;
	}
	
	public Produto() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public int getQtdade() {
		return qtdade;
	}
	public void setQtdade(int qtdade) {
		this.qtdade = qtdade;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	@Override
	public String toString() {
		return "Produto: \n[id: " + id + ", Nome: " + nome + ", Valor: " + valor + ", \nqtdade: " + qtdade + ", descricao: "
				+ descricao + ", urlImagem: " + urlImagem + " ]";
	}
}