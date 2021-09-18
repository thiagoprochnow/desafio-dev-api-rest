package br.com.desafio.infra.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.domain.account.entity.Account;
import br.com.desafio.domain.transaction.entity.Transaction;

public interface TransactionInfraPostgreSQL extends JpaRepository<Transaction, Long> {
	
}
