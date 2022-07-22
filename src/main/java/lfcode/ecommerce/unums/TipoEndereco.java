package lfcode.ecommerce.unums;

public enum TipoEndereco {

	COBRANCA("Cobença"),
	ENTREGA("Entrega");
	
	private String descricao;

	private TipoEndereco(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao ;
	}
	
}
