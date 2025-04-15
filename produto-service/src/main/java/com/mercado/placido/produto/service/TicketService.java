package com.mercado.placido.produto.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.mercado.placido.produto.domain.Ticket;

import reactor.core.publisher.Mono;

//@FeignClient(name = "ticket-server")
public interface TicketService {

	//@GetMapping(value = "/ticket/produto/{produtoId}")
	 Mono<Ticket> findByProdutoId(@PathVariable Integer produtoId);
}
