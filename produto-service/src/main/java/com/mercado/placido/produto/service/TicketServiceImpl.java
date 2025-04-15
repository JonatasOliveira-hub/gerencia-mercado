package com.mercado.placido.produto.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mercado.placido.produto.domain.Ticket;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

@Service
public class TicketServiceImpl implements TicketService {

	private static final String CB_NAME = "ticketService";
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	@CircuitBreaker(name = CB_NAME, fallbackMethod = "fallbackTicket")
	public Mono<Ticket> findByProdutoId(Integer produtoId) {
		return webClientBuilder.build().get()
				.uri("http://localhost:6060/ticket/produto/{produtoId}", produtoId)
				.retrieve()
				.bodyToMono(Ticket.class);
	}
	
	public Mono<Ticket> fallbackTicket(Integer produtoId, Throwable throwable) {
		System.out.println("Fallback triggered: " + throwable.getMessage());
	    return Mono.just(new Ticket());
	}
}
