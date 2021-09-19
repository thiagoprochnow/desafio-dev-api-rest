package br.com.desafio.infra.transaction;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.desafio.domain.account.entity.Account;
import br.com.desafio.domain.transaction.entity.Transaction;

public interface TransactionInfraPostgreSQL extends JpaRepository<Transaction, Long> {

	List<Transaction> findAllByidConta(long idConta);
	
	@Query(value = "SELECT * FROM public.transactions transactions WHERE \"idConta\" = ?1 AND \"dataTransacao\" BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Transaction> findAllByPeriod(long idConta, Date periodStart, Date periodEnd);
}
