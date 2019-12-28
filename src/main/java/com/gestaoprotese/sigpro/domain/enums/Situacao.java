package com.gestaoprotese.sigpro.domain.enums;

public enum Situacao {
	MODELO_DE_GESSO(1, "Modelo de Gesso"),
	CHAPA_DE_PROVA(2, "Chapa de Prova"),
	PLANO_DE_CERA(3, "Plano de Cera"),
	MONTAGEM_DOS_DENTES(4, "Montagem dos Dentes"),
	PROTESE_PRENSADA(5, "Protese Prensada"),
	ABANDONO(6, "Abandono"),
	ATESTAMENTO(7, "Atestamento");
	
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
