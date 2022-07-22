package lfcode.ecommerce.models;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "tb_marcas_produtos")
@SequenceGenerator(name = "seq_marca_produto", sequenceName = "seq_marca_produto", allocationSize = 1, initialValue = 1)
public class MarcaProduto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto")
    private Long id;


    private Integer nota;

    @Column(nullable = false, length = 244)
    private String descricao;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id_", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fx"))
    @NotNull
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fx"))
    private Produto produto;

}
