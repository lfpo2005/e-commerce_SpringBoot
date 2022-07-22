package lfcode.ecommerce.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "tb_vd_cp_loja_virtual")
@SequenceGenerator(name = "seq_vd_cp_loja_virtual", sequenceName = "seq_vd_cp_loja_virtual", allocationSize = 1, initialValue = 1)
public class VendaCompraLojaVirtual implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vd_cp_loja_virtual")
    private Long id;


    private BigDecimal valorTotal;

    private BigDecimal valorDesconto;

    private BigDecimal valorFrete;

    private Integer prazoEntrega;

    @Temporal(TemporalType.DATE)
    private Date dataVenda;

    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @Temporal(TemporalType.DATE)
    private Date dataEstimaEntrega;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "forma_pagamento_id_fx"))
    @NotNull
    private FormaPagamento formaPagamento;

    @OneToOne
    @JoinColumn(name = "nota_fiscal_venda_id_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "nota_fiscal_venda_id_fx"))
    @NotNull
    private NotaFiscalVenda notaFiscalVenda;

    @ManyToOne
    @JoinColumn(name = "cupom_desconto_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "cupom_desconto_id_fx"))
    private CupomDesconto cupomDesconto;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id_", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fx"))
    @NotNull
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_entrega_id_fx"))
    @NotNull
    private Endereco enderecoEntrega;

    @ManyToOne
    @JoinColumn(name = "endereco_cobranca_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_cobranca_id_fx"))
    @NotNull
    private Endereco enderecoCobranca;
}
