package lfcode.ecommerce.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_nota_fiscal_venda")
@SequenceGenerator(name = "seq_tb_nota_fiscal_venda", sequenceName =  "seq_tb_nota_fiscal_venda", allocationSize = 1, initialValue = 1)
public class NotaFiscalVenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tb_nota_fiscal_venda")
	private Long id;

	@Column(nullable = false,  length = 10)
	private String numeroNotaFiscalVenda;

	@Column(nullable = false,  length = 5)
	private String serie;

	private String tipo;

	@Column(columnDefinition = "text")
	private String xml;
	@Column(columnDefinition = "text")
	private String pdf;

	@OneToOne
	@JoinColumn(name = "venda_compra_loja_virtual_id",
			foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "venda_compra_loja_virtual_id_fx" ))
	private VendaCompraLojaVirtual vendaCompraLojaVirtual;
}
