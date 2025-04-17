package com.mercado.placido.produto.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.mercado.placido.produto.domain.Ticket;

import reactor.core.publisher.Mono;

public interface TicketService {

	Mono<Ticket> findByProdutoId(@PathVariable Integer produtoId);
}
