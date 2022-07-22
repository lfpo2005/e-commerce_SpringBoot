package lfcode.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lfcode.ecommerce.unums.StatusContaPagar;
import lombok.Data;


@Entity
@Data
@Table(name = "tb_contas_pagar")
@SequenceGenerator(name = "seq_contas_pagar", sequenceName =  "seq_contas_pagar", allocationSize = 1, initialValue = 1)
public class ContaPagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "seq_contas_pagar")
	private Long id;
	
	@Column(nullable = false,  length = 100)
	private String descricao;

	private BigDecimal valorTotal;

	private BigDecimal valorDesconto;

	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private StatusContaPagar status;

	@Temporal(TemporalType.DATE)
	private Date dtVencimento;

	@Temporal(TemporalType.DATE)
	private Date dtPagamento;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id_pagar", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_pagar_fx" ))
	private Pessoa pessoaPagar;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id_fornecedor", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fornecedor_fx" ))
	private Pessoa pessoaFornecedor;

}
