package lfcode.ecommerce.models;

import lombok.Data;

import java.io.Serializable;

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

@Entity
@Data
@Table(name = "tb_telefones")
@SequenceGenerator(name = "seq_telefone", sequenceName = "seq_telefone", allocationSize = 1, initialValue = 1)
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_telefone")
	private Long id;

	@Column(nullable = false, unique = true, length = 15)
	private String numero;

	@Column(nullable = false, length = 15)
	private String tipo;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id_fone", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fone_fx"))
	private Pessoa pessoaFone;
}
