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
import javax.validation.constraints.NotNull;

import lfcode.ecommerce.unums.StatusContaReceber;
import lombok.Data;


@Entity
@Data
@Table(name = "tb_contas_receber")
@SequenceGenerator(name = "seq_contas_receber", sequenceName =  "seq_contas_receber", allocationSize = 1, initialValue = 1)
public class ContaReceber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "seq_contas_receber")
	private Long id;
	
	@Column(nullable = false,  length = 150)
	private String descricao;

	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private StatusContaReceber status;

	@Temporal(TemporalType.DATE)
	private Date dtVencimento;

	@Temporal(TemporalType.DATE)
	private Date dtPagamento;

	private BigDecimal valorTotal;

	private BigDecimal valorDesconto;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id_receber", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_receber_fx" ))
	@NotNull
	private Pessoa pessoaReceber;

}
