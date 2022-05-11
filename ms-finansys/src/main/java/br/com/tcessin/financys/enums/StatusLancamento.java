package br.com.tcessin.financys.enums;

public enum StatusLancamento {

	PAGO(1), PENDENTE(2);

	private int cod;

	private StatusLancamento(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public static StatusLancamento toEnum(Integer cod) {
		if(cod == null) return null;
		
		for(StatusLancamento tipo : StatusLancamento.values()) {
			if(cod.equals(tipo.getCod())) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Id inválido"+ cod);
	}
	
}
