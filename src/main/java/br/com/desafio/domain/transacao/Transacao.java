package br.com.desafio.domain.transacao;

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
 * Transacao entity is the transaction made by the user on a account
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Transacao {
	
	private long idTransacao;
	private long idConta;
	private float valor;
	private Date dataTransacao;
}
