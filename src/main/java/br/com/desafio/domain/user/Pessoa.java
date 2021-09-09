package br.com.desafio.domain.user;

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
 * Pessoa entity is the user that will make the transactions and hold a account
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Pessoa {

	private long idPessoa;
	private String nome;
	private String cpf;
	private Date dataNascimento;
}
