package com.gestaoprotese.sigpro.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Protese implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "solicitante_id")
	private Usuario solicitante;
	
	@ManyToOne
	@JoinColumn(name = "laboratorio_id")
	private Instituicao laboratorio;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	private Boolean totalSuperior;
	private Boolean totalInferior;
	private Boolean parcialSuperior;
	private Boolean parcialInferior;
	
	private String codRastreio;
	private String observacao;
	
	@OneToMany(mappedBy = "protese")
	private List<Movimentacao> movimentacoes = new ArrayList<>();
	
	public Protese() {}

	public Protese(Integer id, Paciente paciente, String codRastreio, String observacao, Boolean totalSuperior, 
			Boolean totalInferior, Boolean parcialSuperior, Boolean parcialInferior, Usuario solicitante, Instituicao laboratorio) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.codRastreio = codRastreio;
		this.observacao = observacao;
		this.totalSuperior = totalSuperior;
		this.totalInferior = totalInferior;
		this.parcialSuperior = parcialSuperior;
		this.parcialInferior = parcialInferior;
		this.solicitante = solicitante;
		this.laboratorio = laboratorio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public Usuario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}

	public Instituicao getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Instituicao laboratorio) {
		this.laboratorio = laboratorio;
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
