package com.mercado.placido.produto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mercado.placido.produto.domain.Ticket;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TicketServiceImpl implements TicketService {

	private String url = "http://ticket-server/ticket/produto/{produtoId}";

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "defaulTicket")
	public Ticket findByProdutoId(Integer produtoId) {
		return restTemplate.getForObject(url, Ticket.class, produtoId);
	}

	private Ticket defaulTicket(Integer produtoId) {
        return new Ticket();
    }

}
