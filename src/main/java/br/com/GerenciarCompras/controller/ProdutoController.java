package br.com.GerenciarCompras.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.GerenciarCompras.controller.dto.ProdutoDto;
import br.com.GerenciarCompras.controller.dto.ReqNovoProduto;
import br.com.GerenciarCompras.model.bean.Produto;
import br.com.GerenciarCompras.model.repository.IProdutoRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private IProdutoRepository produtoRepository;
	
	@GetMapping
	public List<ProdutoDto> lista(@RequestParam(required = false) String nomeProduto, 
								  @PageableDefault(sort="id",direction=Direction.ASC,page=0,size=5) Pageable paginacao){
		if (nomeProduto == null) {
			Page<Produto> produtos = produtoRepository.findAll(paginacao);
			return ProdutoDto.converter(produtos);
		} 
		else {
			Page<Produto> produtos = produtoRepository.findByProdutoNome(nomeProduto, paginacao);
			return ProdutoDto.converter(produtos);
		}
	}
	
	@GetMapping("/novo")
	public String produtoForm(ReqNovoProduto requisicao) {
		return "produtos/produtoForm";
	}
	
	@PostMapping("/novo")
	public String novo(@Valid ReqNovoProduto requisicao, BindingResult result) {
		if (result.hasErrors()) {
			return "produtos/novo";
		}
		Produto produto = requisicao.toProduto();
		System.out.println("Produto criado: "+produto.toString());
//		produtoRepository.save(produto);
		return "redirect:/";
	}
}