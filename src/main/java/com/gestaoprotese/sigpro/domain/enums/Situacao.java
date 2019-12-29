package com.gestaoprotese.sigpro.domain.enums;

public enum Situacao {
	MODELO_DE_GESSO(1, "Modelo de Gesso"),
	PLANO_DE_CERA(2, "Plano de Cera"),
	MONTAGEM_DOS_DENTES(3, "Montagem dos Dentes"),
	PROTESE_PRENSADA(4, "Protese Prensada"),
	ABANDONO(5, "Abandono"),
	ATESTAMENTO(6, "Atestamento");
	
	private int cod;
	private String descricao;
	
	private Situacao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Situacao toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(Situacao situacao : Situacao.values()) {
			if(cod.equals(situacao.getCod())) {
				return situacao;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
