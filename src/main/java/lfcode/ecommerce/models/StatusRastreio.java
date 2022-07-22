package lfcode.ecommerce.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_status_rastreio")
@SequenceGenerator(name = "seq_status_rastreio", sequenceName = "seq_status_rastreio", allocationSize = 1, initialValue = 1)
public class StatusRastreio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status_rastreio")
    private Long id;
    @Column(nullable = false, length = 30)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "venda_compra_loja_virtual_id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "venda_compra_loja_virtual_id_fx" ))
    private VendaCompraLojaVirtual vendaCompraLojaVirtual;

}
