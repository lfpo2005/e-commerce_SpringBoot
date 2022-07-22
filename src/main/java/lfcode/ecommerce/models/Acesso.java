package lfcode.ecommerce.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
@Table(name = "tb_acessos")
@SequenceGenerator(name = "seq_acesso", sequenceName =  "seq_acesso", allocationSize = 1, initialValue = 1)
public class Acesso implements GrantedAuthority {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "seq_acesso")
	private Long id;
	
	@NotNull
	private String descricao;

	@Override
	public String getAuthority() {
		return null;
	}
}
