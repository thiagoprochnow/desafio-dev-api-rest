package br.com.desafio.domain.transaction.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

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
 * Transacao entity is the transaction made by the user on a account
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Data
@Table(name = "transactions")
public class Transaction {
	
	@Id
	@SequenceGenerator(name="transaction_id_generator", sequenceName="id_generator", allocationSize=1)  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transaction_id_generator")
	@SerializedName(value = "idTransacao")
	@Column(name="\"idTransacao\"")
	private long idTransacao;
	
	@SerializedName(value = "idConta")
	@JoinColumn(name="idConta", referencedColumnName="idConta", foreignKey = @ForeignKey(name = "fk_conta"))
	@Column(name="\"idConta\"")
	private long idConta;
	
	@SerializedName(value = "valor")
	@Column(name="\"valor\"")
	private float valor;
	
	@SerializedName(value = "dataTransacao")
	@Column(name="\"dataTransacao\"")
	private Date dataTransacao;
}
