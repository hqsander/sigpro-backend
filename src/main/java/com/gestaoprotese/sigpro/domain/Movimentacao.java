package com.gestaoprotese.sigpro.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gestaoprotese.sigpro.domain.enums.Situacao;

@Entity
public class Movimentacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Date dataMovimentacao;
	private Integer situacaoOrigem;
	private Integer situacaoDestino;
	
	@ManyToOne
	@JoinColumn(name = "responsavel_id")
	private Usuario responsavel;
	
	@ManyToOne
	@JoinColumn(name = "protese_id")
	private Protese protese;

	public Movimentacao() {}
	
	public Movimentacao(Integer id, Date dataMovimentacao, Situacao situacaoOrigem, Situacao situacaoDestino,
			Usuario responsavel, Protese protese) {
		super();
		this.id = id;
		this.dataMovimentacao = dataMovimentacao;
		this.situacaoOrigem = situacaoOrigem.getCod();
		this.situacaoDestino = situacaoDestino.getCod();
		this.responsavel = responsavel;
		this.protese = protese;
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

	public Situacao getSituacaoOrigem() {
		return Situacao.toEnum(situacaoOrigem);
	}

	public void setSituacaoOrigem(Situacao situacaoOrigem) {
		this.situacaoOrigem = situacaoOrigem.getCod();
	}

	public Situacao getSituacaoDestino() {
		return Situacao.toEnum(situacaoDestino);
	}

	public void setSituacaoDestino(Situacao situacaoDestino) {
		this.situacaoDestino = situacaoDestino.getCod();
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public Protese getProtese() {
		return protese;
	}

	public void setProtese(Protese protese) {
		this.protese = protese;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
