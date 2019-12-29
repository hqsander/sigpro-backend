package com.gestaoprotese.sigpro.domain.enums;

public enum TipoInstituicao {
	CENTRO_DE_SAUDE(1, "Centro de Saúde"),
	LABORATORIO(2, "Laboratório");
	
	private int cod;
	private String descricao;
	
	private TipoInstituicao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoInstituicao toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(TipoInstituicao tipo : TipoInstituicao.values()) {
			if(cod.equals(tipo.getCod())) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
