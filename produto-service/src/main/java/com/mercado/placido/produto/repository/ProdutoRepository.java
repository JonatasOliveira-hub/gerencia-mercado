package com.mercado.placido.produto.repository;

import org.springframework.data.repository.CrudRepository;

import com.mercado.placido.produto.domain.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	
	Produto findByProdutoId(Integer produtoId);

}
