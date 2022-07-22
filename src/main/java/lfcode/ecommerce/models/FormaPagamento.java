package lfcode.ecommerce.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tb_formas_pagamentos")
@SequenceGenerator(name = "seq_formas_pagamentos", sequenceName =  "seq_formas_pagamentos", allocationSize = 1, initialValue = 1)
public class FormaPagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_formas_pagamentos")
	private Long id;

	@Column(nullable = false,  length = 30)
	private String descricao;

}
