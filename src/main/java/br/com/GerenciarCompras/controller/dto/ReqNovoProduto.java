package br.com.GerenciarCompras.controller.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import br.com.GerenciarCompras.model.bean.Produto;
import lombok.Data;

@Data
public class ReqNovoProduto {

	@NotBlank
	private String nome;
	
//	@NotBlank
	private BigDecimal valor;
	
	@NotBlank
	private String urlImagem;
	private String descricao;
	
	public Produto toProduto() {
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setValor(valor);
		produto.setUrlImagem(urlImagem);
		produto.setDescricao(descricao);
		return produto;
	}
}