package lfcode.ecommerce.unums;

public enum StatusContaPagar {

    COBRANCA ("Pagar"),
    VENCIDA ("Vencida"),
    ABERTA ("Aberta"),
    ALUGUEL ("Alguel"),
    FUNCIONARIO ("Funcionario"),
    QUITADA("Quitada"),
    NEGOCIADA("Renegociada");

    private String descricao;
    private StatusContaPagar(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
