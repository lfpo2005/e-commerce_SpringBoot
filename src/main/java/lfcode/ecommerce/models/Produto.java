package lfcode.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_produtos")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	private Long id;
	@Column( length = 4)
	private String tipoUnidade;

	@Column(nullable = false, length = 150)
	private String nome;

	@Column(nullable = false, length = 2500)
	private String descricao;

	@Column(nullable = false, length = 6)
	private Double peso;

	@Column(nullable = false, length = 6)
	private String largura;

	@Column(nullable = false, length = 6)
	private String altura;

	@Column(nullable = false, length = 6)
	private String profundidade;

	@Column(nullable = false)
	private BigDecimal valorVenda;

	@Column(nullable = false, length = 6)
	private Integer qtdEstoque;

	private Boolean alertaQtdEstoque = Boolean.FALSE; // ativa/desativa o alerta de estoque

	private Integer qtdAlertaEstoque = 0; // Avisa a quantidade de produtos no estoque

	private String linkYoutube;

	private Integer qtdClique = 0;
	
	private Boolean ativo = Boolean.FALSE;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime dataCriacaoProduto;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime dataAtualizacaoProduto;

}
