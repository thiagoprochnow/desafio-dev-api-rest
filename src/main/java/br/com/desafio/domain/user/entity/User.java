package br.com.desafio.domain.user.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

import br.com.desafio.domain.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Thiago Henrique Prochnow (thiprochnow@gmail.com)
 *
 * Pessoa entity is the user that will make the transactions and hold a account
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Data
@Table(name = "users")
public class User implements Serializable{

	@Id
	@SequenceGenerator(name="account_id_generator", sequenceName="id_generator", allocationSize=1)  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_id_generator")
	@SerializedName(value = "idPessoa")
	@Column(name="\"idPessoa\"")
	private long idPessoa;
	
	@SerializedName(value = "nome")
	@Column(name="\"nome\"")
	private String nome;
	
	@SerializedName(value = "cpf")
	@Column(name="\"cpf\"")
	private String cpf;
	
	@SerializedName(value = "dataNascimento")
	@Column(name="\"dataNascimento\"")
	private Date dataNascimento;
}
