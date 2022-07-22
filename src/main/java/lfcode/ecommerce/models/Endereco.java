package lfcode.ecommerce.models;

import java.io.Serializable;

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
import javax.validation.constraints.NotNull;

import lfcode.ecommerce.unums.TipoEndereco;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_enderecos")
@SequenceGenerator(name = "seq_endereco", sequenceName =  "seq_endereco", allocationSize = 1, initialValue = 1)
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "seq_endereco")
	private Long id;
	
	@Column(nullable = false,  length = 20)
	private String rua;
	
	@Column(nullable = false,  length = 10)
	private String numero;
	
	@Column(nullable = false,  length = 9)
	private String cep;
	
	private String complemento;
	
	@Column(nullable = false,  length = 20)
	private String bairro;
	
	@Column(nullable = false,  length = 2)
	private String uf;
	
	@Column(nullable = false,  length = 20)
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	private TipoEndereco tipoEndereco;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fx" ))
	@NotNull
	private Pessoa pessoaEndereco;

}
