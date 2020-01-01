package com.gestaoprotese.sigpro.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.gestaoprotese.sigpro.domain.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Nome é obrigatório.")
	@Length(min = 5, max = 80, message = "Nome deve ter entre 5 e 80 caracteres.")
	private String nome;
	
	private Integer instituicaoId;
	
	public UsuarioDTO() {}
	
	public UsuarioDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		instituicaoId = usuario.getInstituicao().getId();
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

	public Integer getInstituicaoId() {
		return instituicaoId;
	}

	public void setInstituicaoId(Integer instituicaoId) {
		this.instituicaoId = instituicaoId;
	}
	
}
