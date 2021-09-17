package br.com.desafio.domain.account.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.google.gson.annotations.SerializedName;

import br.com.desafio.domain.user.entity.User;
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
 * Conta entity is the account holded by a user (Pessoa) that can make transaction (Transacao) on it
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Data
@Table(name = "accounts")
public class Account implements Serializable{

	@Id
	@SequenceGenerator(name="account_id_generator", sequenceName="id_generator", allocationSize=1)  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_id_generator")
	@SerializedName(value = "idConta")
	@Column(name="\"idConta\"")
	private long idConta;
	
	@SerializedName(value = "idPessoa")
	@JoinColumn(name="idPessoa", referencedColumnName="idPessoa", foreignKey = @ForeignKey(name = "fk_pessoa"))
	@Column(name="\"idPessoa\"")
	private long idPessoa;
	
	@SerializedName(value = "saldo")
	@Column(name="\"saldo\"")
	private float saldo;
	
	@SerializedName(value = "limiteSaqueDiario")
	@Column(name="\"limiteSaqueDiario\"")
	private float limiteSaqueDiario;
	
	@SerializedName(value = "flagAtivo")
	@Column(name="\"flagAtivo\"")
	private boolean flagAtivo;
	
	@SerializedName(value = "tipoConta")
	@Column(name="\"tipoConta\"")
	private int tipoConta;
	
	@SerializedName(value = "dataCriacao")
	@Column(name="\"dataCriacao\"")
	private Date dataCriacao;
}
