package br.com.desafio.domain.transaction.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.desafio.domain.account.entity.Account;
import br.com.desafio.domain.transaction.entity.Transaction;
import br.com.desafio.infra.transaction.TransactionInfraPostgreSQL;

/**
 * 
 * @author Thiago Henrique Prochnow (thiprochnow@gmail.com)
 *
 * Transaction Repository for CRUD in database
 */

@Repository
public interface TransactionRepository {


	public Transaction insertTransactionOnPostgreSQL(Transaction transactionBody) throws Exception;
	
	public List<Transaction> getAllTransactions(long idConta) throws Exception;
	
	public List<Transaction> getAllTransactionsByPeriod(long idConta, Date periodStart, Date periodEnd) throws Exception;
}
