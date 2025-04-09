package com.mercado.placido.produto.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mercado.placido.produto.domain.Ticket;

@FeignClient(name = "ticket-server")
public interface TicketService {

	@GetMapping(value = "/ticket/produto/{produtoId}")
	Ticket findByProdutoId(@PathVariable Integer produtoId);
}
