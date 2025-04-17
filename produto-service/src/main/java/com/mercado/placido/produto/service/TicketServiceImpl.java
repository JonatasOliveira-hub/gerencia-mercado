package com.mercado.placido.produto.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mercado.placido.produto.domain.Ticket;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

@Service
public class TicketServiceImpl implements TicketService {

	private static final String CB_NAME = "ticketService";

	private static final Logger LOG = LoggerFactory.getLogger(TicketServiceImpl.class);

	@Autowired
	private WebClient.Builder webClientBuilder;

	@CircuitBreaker(name = CB_NAME, fallbackMethod = "fallbackTicket")
	public Mono<Ticket> findByProdutoId(Integer produtoId) {

		return webClientBuilder.build().get().uri("TICKET-SERVER/localhost:ticket-server:6060/ticket/produto/{produtoId}", produtoId)
				.retrieve()
				.bodyToMono(Ticket.class);
	}

	public Mono<Ticket> fallbackTicket(Integer produtoId, Throwable throwable) {
		LOG.error("Fallback acionado. Mensagem recebida foi: " + throwable.getMessage());
		return Mono.just(new Ticket());
	}
}
