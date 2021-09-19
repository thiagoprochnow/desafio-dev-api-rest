package br.com.desafio.domain.account.event;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.desafio.application.common.Utils;
import br.com.desafio.domain.account.entity.Account;
import br.com.desafio.domain.account.repository.AccountRepository;
import br.com.desafio.domain.transaction.entity.Transaction;
import br.com.desafio.domain.transaction.repository.TransactionRepository;

/**
 * 
 * @author Thiago Henrique Prochnow (thiprochnow@gmail.com)
 *
 * Account Service for methods for all account operations
 */

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	/**
	 * Recieve a accountBody as request, and with it, create a account in database
	 * @param accountBody
	 * @return the created account information
	 * @throws Exception
	 */
	public Account createAccount(Account accountBody) throws Exception {
		Date currentDate = Utils.getCurrentDate();
		accountBody.setDataCriacao(currentDate);
		return accountRepository.insertAccountOnPostgreSQL(accountBody);
	}
	
	/**
	 * Recieve a accountBody with the contaId as request, and with it, fetch the full account information in the database
	 * @param accountBody
	 * @return the created account information
	 * @throws Exception
	 */
	public Account getAccount(long idConta) throws Exception {
		return accountRepository.findById(idConta);
	}
	
	/**
	 * Recieve a accountBody with the contaId as request, and with it, fetch the account information in the database and block it by changing the flagAtivo to false
	 * @param accountBody
	 * @return the blocked account information
	 * @throws Exception
	 */
	public Account blockAccount(Account accountBody) throws Exception {
		Account account = accountRepository.findById(accountBody.getIdConta());
		account.setFlagAtivo(false);
		return accountRepository.updateAccountOnPostgreSQL(account);
	}
	
	/**
	 * Recieve a accountBody with the contaId as request, and with it, fetch all transactions in the database of that account
	 * @param accountBody
	 * @return list of all transactions
	 * @throws Exception
	 */
	public List<Transaction> getTransactions(long idConta) throws Exception {
		List<Transaction> transactions = transactionRepository.getAllTransactions(idConta);
		return transactions;
	}
	
	/**
	 * Recieve a accountBody with the contaId as request, and with it, fetch all transactions in the database of that account in a given period
	 * @param accountBody, periodStart, periodEnd
	 * @return list of all transactions in that period
	 * @throws Exception
	 */
	public List<Transaction> getTransactionsByPeriod(long idConta, Date periodStart, Date periodEnd) throws Exception {
		List<Transaction> transactions = transactionRepository.getAllTransactionsByPeriod(idConta, periodStart, periodEnd);
		return transactions;
	}
}
