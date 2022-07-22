package lfcode.ecommerce.models;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Data
@Table(name = "tb_cupom_descontos")
@SequenceGenerator(name = "seq_cup_descontos", sequenceName =  "seq_cup_descontos", allocationSize = 1, initialValue = 1)
public class CupomDesconto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cup_descontos")
	private Long id;
	
	@Column(nullable = false,  length = 15)
	private String codigoCupom;

	private BigDecimal valorRealDesconto;

	private BigDecimal valorPorcentoDesconto;

	@Temporal(TemporalType.DATE)
	private Date dataValidadeCupom;

	@Temporal(TemporalType.DATE)
	private Date inicioDesconto;

	@Temporal(TemporalType.DATE)
	private  Date finalDesconto;
}
