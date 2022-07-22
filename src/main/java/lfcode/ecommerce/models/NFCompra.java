package lfcode.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_nf_compra")
@SequenceGenerator(name = "seq_nf_compra", sequenceName = "seq_nf_compra", allocationSize = 1, initialValue = 1)
public class NFCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nf_compra")
	private Long id;

	@Column(nullable = false, length = 12)
	private String numeroNota;

	@Column(nullable = false, length = 3)
	private String serieNota;

	private String descricao;

	@Column(nullable = false)
	private BigDecimal valorTotal;

	private BigDecimal valorDesconto;

	private BigDecimal valorICMS;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime dataCompra;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id_nfcompra", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_nfcompra_fx"))
	private Pessoa pessoaNFCompra;

	@ManyToOne
	@JoinColumn(name = "contapg_id_nfcompra", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "contapg_nfcompra_fx"))
	private ContaPagar contaPgNFCompra;

}
