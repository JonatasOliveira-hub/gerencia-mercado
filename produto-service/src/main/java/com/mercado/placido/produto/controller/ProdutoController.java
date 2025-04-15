package com.mercado.placido.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mercado.placido.produto.domain.Produto;
import com.mercado.placido.produto.repository.ProdutoRepository;
import com.mercado.placido.produto.service.TicketService;

@RestController
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	TicketService ticketService;
	
	@GetMapping(value = "/produto")
	public Iterable<Produto> all() {
		return produtoRepository.findAll();
	}

	@GetMapping(value = "/produto/{produtoId}")
	public Produto findByAccountId(@PathVariable Integer produtoId) {

		Produto produto = produtoRepository.findByProdutoId(produtoId);

		produto.setTicket(ticketService.findByProdutoId(produtoId));

		return produto;
	}

}
