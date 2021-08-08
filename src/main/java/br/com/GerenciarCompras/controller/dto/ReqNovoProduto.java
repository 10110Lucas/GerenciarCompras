package br.com.GerenciarCompras.controller.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import br.com.GerenciarCompras.model.bean.Produto;

public class ReqNovoProduto {

	@NotBlank
	private String nome;
	
//	@NotBlank
	private BigDecimal valor;
	
	@NotBlank
	private String urlImagem;
	private String descricao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Produto toProduto() {
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setValor(valor);
		produto.setUrlImagem(urlImagem);
		produto.setDescricao(descricao);
		return produto;
	}
}