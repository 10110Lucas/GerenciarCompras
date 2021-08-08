package br.com.GerenciarCompras.controller.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.GerenciarCompras.model.bean.Produto;
import lombok.Data;

@Data
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
	
	
	@SuppressWarnings("unchecked")
	public static List<ProdutoDto> converter(Page<Produto> produtos) {
		return (List<ProdutoDto>) produtos.map(ProdutoDto::new);
	}
}