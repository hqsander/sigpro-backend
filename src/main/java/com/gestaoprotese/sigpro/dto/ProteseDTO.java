package com.gestaoprotese.sigpro.dto;

import java.io.Serializable;

import com.gestaoprotese.sigpro.domain.Protese;

public class ProteseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Boolean totalSuperior;
	private Boolean totalInferior;
	private Boolean parcialSuperior;
	private Boolean parcialInferior;

	private String codRastreio;
	private String observacao;
	
	private Integer solicitanteId;
	private Integer laboratorioId;
	private Integer pacienteId;
	
	public ProteseDTO() {}
	
	public ProteseDTO(Protese protese) {
		id = protese.getId();
		totalSuperior = protese.getTotalSuperior();
		totalInferior = protese.getTotalInferior();
		parcialSuperior = protese.getParcialSuperior();
		parcialInferior = protese.getParcialInferior();
		codRastreio = protese.getCodRastreio();
		observacao = protese.getObservacao();
		solicitanteId = protese.getSolicitante().getId();
		laboratorioId = protese.getLaboratorio().getId();
		pacienteId = protese.getPaciente().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getSolicitanteId() {
		return solicitanteId;
	}

	public void setSolicitanteId(Integer solicitanteId) {
		this.solicitanteId = solicitanteId;
	}

	public Integer getLaboratorioId() {
		return laboratorioId;
	}

	public void setLaboratorioId(Integer laboratorioId) {
		this.laboratorioId = laboratorioId;
	}

	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}
	
}
