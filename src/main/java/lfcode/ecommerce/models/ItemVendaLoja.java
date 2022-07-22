package lfcode.ecommerce.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_item_venda_loja")
@SequenceGenerator(name = "seq_item_venda_loja", sequenceName = "seq_item_venda_loja", allocationSize = 1, initialValue = 1)
public class ItemVendaLoja implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item_venda_loja")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_id_fx"))
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "venda_compra_loja_virtual_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "venda_compra_loja_virtual_id_fx" ))
    private VendaCompraLojaVirtual vendaCompraLojaVirtual;

}
