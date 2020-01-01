package com.gestaoprotese.sigpro.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gestaoprotese.sigpro.domain.Movimentacao;
import com.gestaoprotese.sigpro.domain.enums.Situacao;

public class MovimentacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataMovimentacao;
	private Integer situacao;
	private Integer remetenteId;
	private Integer destinatarioId;
	private Integer proteseId;
	
	public MovimentacaoDTO() {}
	
	public MovimentacaoDTO(Movimentacao movimentacao) {
		id = movimentacao.getId();
		dataMovimentacao = movimentacao.getDataMovimentacao();
		situacao = movimentacao.getSituacao().getCod();
		remetenteId = movimentacao.getRemetente().getId();
		destinatarioId = movimentacao.getDestinatario().getId();
		proteseId = movimentacao.getProtese().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Situacao getSituacao() {
		return Situacao.toEnum(situacao);
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao.getCod();
	}

	public Integer getRemetenteId() {
		return remetenteId;
	}

	public void setRemetenteId(Integer remetenteId) {
		this.remetenteId = remetenteId;
	}

	public Integer getDestinatarioId() {
		return destinatarioId;
	}

	public void setDestinatarioId(Integer destinatarioId) {
		this.destinatarioId = destinatarioId;
	}

	public Integer getProteseId() {
		return proteseId;
	}

	public void setProteseId(Integer proteseId) {
		this.proteseId = proteseId;
	}
	
}
