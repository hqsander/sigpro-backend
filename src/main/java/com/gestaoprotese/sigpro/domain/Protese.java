package com.gestaoprotese.sigpro.domain;

import java.io.Serializable;
import java.math.BigInteger;

import com.gestaoprotese.sigpro.domain.enums.Situacao;

public class Protese implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private BigInteger id;
	
	private Integer situacao;
	private Paciente paciente;
	private Laboratorio laboratorio;
	private CentroDeSaude centroDeSaude;
	
	private String codRastreio;
	private String observacao;
	private Boolean total;
	private Boolean superior;
	
	public Protese() {}

	public Protese(BigInteger id, Situacao situacao, Paciente paciente, Laboratorio laboratorio,
			CentroDeSaude centroDeSaude, String codRastreio, String observacao, Boolean total, Boolean superior) {
		super();
		this.id = id;
		this.situacao = situacao.getCod();
		this.paciente = paciente;
		this.laboratorio = laboratorio;
		this.centroDeSaude = centroDeSaude;
		this.codRastreio = codRastreio;
		this.observacao = observacao;
		this.total = total;
		this.superior = superior;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Situacao getSituacao() {
		return Situacao.toEnum(situacao);
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao.getCod();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public CentroDeSaude getCentroDeSaude() {
		return centroDeSaude;
	}

	public void setCentroDeSaude(CentroDeSaude centroDeSaude) {
		this.centroDeSaude = centroDeSaude;
	}

	public String getCodRastreio() {
		return codRastreio;
	}

	public void setCodRastreio(String codRastreio) {
		this.codRastreio = codRastreio;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getTotal() {
		return total;
	}

	public void setTotal(Boolean total) {
		this.total = total;
	}

	public Boolean getSuperior() {
		return superior;
	}

	public void setSuperior(Boolean superior) {
		this.superior = superior;
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
		Protese other = (Protese) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
