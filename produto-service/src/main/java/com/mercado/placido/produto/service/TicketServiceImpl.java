package com.mercado.placido.produto.service;

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

	    @CircuitBreaker(name = CB_NAME, fallbackMethod = "defaultTicket")
	    public Mono<Ticket> findByProdutoId(Integer produtoId) {
	        return webClientBuilder.build()
	                .get()
	                .uri("http://ticket-server:6060/ticket/produto/{produtoId}", produtoId)
	                .retrieve()
	                .bodyToMono(Ticket.class);
	    }

	    // Fallback method must match return type and parameters
	    public Mono<Ticket> defaultTicket(Integer produtoId, Throwable throwable) {
	        return Mono.just(new Ticket());
	    }
}
