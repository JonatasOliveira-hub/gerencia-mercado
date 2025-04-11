package com.mercado.placido.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mercado.placido.produto.domain.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	private String url = "http://ticket-server/ticket/produto/{produtoId}";

	@Override
	public Ticket findByProdutoId(Integer produtoId) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		return circuitBreaker.run(() -> restTemplate.getForObject(url, Ticket.class));

		
	}

}
