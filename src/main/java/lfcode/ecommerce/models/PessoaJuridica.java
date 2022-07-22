package lfcode.ecommerce.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tb_pessoas_juridicas")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true, length = 18)
	private String cnpj;
	@Column(nullable = false, unique = true, length = 20)
	private String inscrEstadual;
	@Column(unique = true, length = 50)
	private String inscrMunicipal;
	@Column(nullable = false, unique = true, length = 50)
	private String nomeFantasia;
	@Column(nullable = false, unique = true, length = 50)
	private String razaoSocial;
	@Column(nullable = false, length = 50)
	private String categoria;

}
