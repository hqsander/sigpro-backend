package com.gestaoprotese.sigpro.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gestaoprotese.sigpro.domain.enums.Situacao;

@Entity
public class Protese implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;
	
	private Integer situacao;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "laboratorio_id")
	private Laboratorio laboratorio;
	
	@ManyToOne
	@JoinColumn(name = "centroDeSaude_id")
	private CentroDeSaude centroDeSaude;
	
	private String codRastreio;
	private String observacao;
	
	private Boolean totalSuperior;
	private Boolean totalInferior;
	private Boolean parcialSuperior;
	private Boolean parcialInferior;
	
	public Protese() {}

	public Protese(BigInteger id, Situacao situacao, Paciente paciente, Laboratorio laboratorio,
			CentroDeSaude centroDeSaude, String codRastreio, String observacao, Boolean totalSuperior,
			Boolean totalInferior, Boolean parcialSuperior, Boolean parcialInferior) {
		super();
		this.id = id;
		this.situacao = situacao.getCod();
		this.paciente = paciente;
		this.laboratorio = laboratorio;
		this.centroDeSaude = centroDeSaude;
		this.codRastreio = codRastreio;
		this.observacao = observacao;
		this.totalSuperior = totalSuperior;
		this.totalInferior = totalInferior;
		this.parcialSuperior = parcialSuperior;
		this.parcialInferior = parcialInferior;
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

	public Boolean getTotalSuperior() {
		return totalSuperior;
	}

	public void setTotalSuperior(Boolean totalSuperior) {
		this.totalSuperior = totalSuperior;
	}

	public Boolean getTotalInferior() {
		return totalInferior;
	}

	public void setTotalInferior(Boolean totalInferior) {
		this.totalInferior = totalInferior;
	}

	public Boolean getParcialSuperior() {
		return parcialSuperior;
	}

	public void setParcialSuperior(Boolean parcialSuperior) {
		this.parcialSuperior = parcialSuperior;
	}

	public Boolean getParcialInferior() {
		return parcialInferior;
	}

	public void setParcialInferior(Boolean parcialInferior) {
		this.parcialInferior = parcialInferior;
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
