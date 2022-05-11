package br.com.tcessin.financys.enums;

public enum TipoLancamento {

	DESPESA(1), RECEITA(2);

	private int cod;

	private TipoLancamento(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public static TipoLancamento toEnum(Integer cod) {
		if(cod == null) return null;
		
		for(TipoLancamento tipo : TipoLancamento.values()) {
			if(cod.equals(tipo.getCod())) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Id inválido"+ cod);
	}
}
