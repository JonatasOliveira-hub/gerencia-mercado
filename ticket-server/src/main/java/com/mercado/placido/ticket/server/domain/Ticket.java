package com.mercado.placido.ticket.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TICKETS")
@Entity
public class Ticket {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TICKETID")
	Integer ticketId;

	@Column(name = "NUMEROPREMIADO")
	Integer numeroPremiado;

	@Column(name = "STATUS")
	String status;

	@Column(name = "PRODUTOID")
	Integer produtoId;

	public Ticket() {
		super();
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", numeroPremiado=" + numeroPremiado + ", status=" + status
				+ ", produtoid=" + produtoId + "]";
	}

	public Ticket(Integer ticketId, Integer numeroPremiado, String status, Integer produtoId) {
		super();
		this.ticketId = ticketId;
		this.numeroPremiado = numeroPremiado;
		this.status = status;
		this.produtoId = produtoId;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getNumeroPremiado() {
		return numeroPremiado;
	}

	public void setNumeroPremiado(Integer numeroPremiado) {
		this.numeroPremiado = numeroPremiado;
	}
}
