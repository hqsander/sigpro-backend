package com.gestaoprotese.sigpro.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.gestaoprotese.sigpro.domain.Instituicao;
import com.gestaoprotese.sigpro.domain.enums.TipoInstituicao;

public class InstituicaoDTO {
	
	private Integer id;
	
	@NotEmpty(message = "Nome é obrigatório.")
	@Length(min = 5, max = 80, message = "Nome deve ter entre 5 e 80 caracteres.")
	private String nome;
	
	private Integer tipo;
	
	public InstituicaoDTO() {}

	public InstituicaoDTO(Instituicao instituicao) {
		id = instituicao.getId();
		nome = instituicao.getNome();
		tipo = instituicao.getTipo().getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoInstituicao getTipo() {
		return TipoInstituicao.toEnum(tipo);
	}

	public void setTipo(TipoInstituicao tipo) {
		this.tipo = tipo.getCod();
	}
	
}
