package com.mercado.placido.ticket.server.repository;

import org.springframework.data.repository.CrudRepository;

import com.mercado.placido.ticket.server.domain.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

	Ticket findTicketByNumeroPremiado(Integer numeroPedido);
	
	Ticket findAllByProdutoId(Integer produtoId);
}
