package com.gestaoprotese.sigpro.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CentroDeSaude implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private BigInteger id;
	private String nome;
	
	private List<Protese> proteses = new ArrayList<>();
	
	public CentroDeSaude() {}

	public CentroDeSaude(BigInteger id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Protese> getProteses() {
		return proteses;
	}

	public void setProteses(List<Protese> proteses) {
		this.proteses = proteses;
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
		CentroDeSaude other = (CentroDeSaude) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
