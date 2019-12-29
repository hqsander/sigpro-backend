package com.gestaoprotese.sigpro.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestaoprotese.sigpro.domain.enums.Situacao;

@Entity
public class Movimentacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataMovimentacao;
	
	private Integer situacao;
	
	@ManyToOne
	@JoinColumn(name = "remetente_id")
	private Instituicao remetente;
	
	@ManyToOne
	@JoinColumn(name = "destinatario_id")
	private Instituicao destinatario;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "protese_id")
	private Protese protese;

	public Movimentacao() {}
	
	public Movimentacao(Integer id, Date dataMovimentacao, Situacao situacao,
			Instituicao remetente, Instituicao destinatario, Protese protese) {
		super();
		this.id = id;
		this.dataMovimentacao = dataMovimentacao;
		this.situacao = situacao.getCod();
		this.protese = protese;
		this.remetente = remetente;
		this.destinatario = destinatario;
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

	public Protese getProtese() {
		return protese;
	}

	public void setProtese(Protese protese) {
		this.protese = protese;
	}

	public Instituicao getRemetente() {
		return remetente;
	}

	public void setRemetente(Instituicao remetente) {
		this.remetente = remetente;
	}

	public Instituicao getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Instituicao destinatario) {
		this.destinatario = destinatario;
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
