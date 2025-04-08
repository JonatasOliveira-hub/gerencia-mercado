package com.mercado.placido.produto.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mercado.placido.produto.domain.Ticket;

@FeignClient
public interface TicketService {

	@GetMapping(value = "/ticket/produto/{produtoId}")
	Ticket findByProdutoId(Integer produtoId);
}
