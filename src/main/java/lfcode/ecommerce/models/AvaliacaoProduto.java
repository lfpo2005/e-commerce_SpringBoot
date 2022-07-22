package lfcode.ecommerce.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_avaliacao_produtos")
@SequenceGenerator(name = "seq_avaliacao_produtos", sequenceName = "seq_avaliacao_produtos", allocationSize = 1, initialValue = 1)
public class AvaliacaoProduto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_avaliacao_produtos")
    private Long id;

    @Column(nullable = false, length = 30)
    private String descricao;

}
