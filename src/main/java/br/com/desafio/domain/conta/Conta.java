package br.com.desafio.domain.conta;

import java.util.Date;

import lombok.AllArgsConstructor;
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
public class Conta {

	private long idConta;
	private long idPessoa;
	private float saldo;
	private float limiteSaqueDiario;
	private boolean flagAtivo;
	private int tipoConta;
	private Date dataCriacao;
}
