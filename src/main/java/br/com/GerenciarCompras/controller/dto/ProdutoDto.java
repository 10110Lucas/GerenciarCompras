package br.com.GerenciarCompras.controller.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.GerenciarCompras.model.bean.Produto;

public class ProdutoDto {

	private Long id;
	private String nome;
	private Double valor;
	private int qtdade;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.qtdade = produto.getQtdade();
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public int getQtdade() {
		return qtdade;
	}
	public void setQtdade(int qtdade) {
		this.qtdade = qtdade;
	}

	@SuppressWarnings("unchecked")
	public static List<ProdutoDto> converter(Page<Produto> produtos) {
		return (List<ProdutoDto>) produtos.map(ProdutoDto::new);
	}
}