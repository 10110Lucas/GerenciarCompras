package br.com.GerenciarCompras.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.GerenciarCompras.model.bean.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long>{
	
	@Query("select p from Produto p where p.nome = :nome")
	Page<Produto> findByProdutoNome(@Param("nome")String nome, Pageable paginacao);
}