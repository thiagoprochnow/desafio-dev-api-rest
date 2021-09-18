package br.com.desafio.domain.transaction.event;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.desafio.application.common.Utils;
import br.com.desafio.domain.account.entity.Account;
import br.com.desafio.domain.account.repository.AccountRepository;
import br.com.desafio.domain.exception.BadRequestException;
import br.com.desafio.domain.transaction.entity.Transaction;
import br.com.desafio.domain.transaction.repository.TransactionRepository;

/**
 * 
 * @author Thiago Henrique Prochnow (thiprochnow@gmail.com)
 *
 * Transaction Service for methods for all transactions operations
 */

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	/**
	 * Recieve a transactionBody as request, and with it, save a transaction in database and updates de account
	 * @param transactionBody
	 * @return the update user account information after the transaction
	 * @throws Exception
	 */
	public Account makeDeposit(Transaction transactionBody) throws Exception {
		Account userAccount = accountRepository.findById(transactionBody.getIdConta());
		
		if(!Utils.isPositiveNumber(transactionBody.getValor())) {
			throw new BadRequestException("Transaction value must be a positive number");
		}
		
		Date currentDate = Utils.getCurrentDate();
		transactionBody.setDataTransacao(currentDate);
		Transaction transaction = transactionRepository.insertTransactionOnPostgreSQL(transactionBody);
		
		float accountSaldo = userAccount.getSaldo() + transaction.getValor();
		userAccount.setSaldo(accountSaldo);
		accountRepository.updateAccountOnPostgreSQL(userAccount);
		
		return userAccount;
	}
	
	/**
	 * Recieve a transactionBody as request, and with it, save a transaction in database and updates de account
	 * @param transactionBody
	 * @return the update user account information after the transaction
	 * @throws Exception
	 */
	public Account makeWithdraw(Transaction transactionBody) throws Exception {
		Account userAccount = accountRepository.findById(transactionBody.getIdConta());
		
		if(!Utils.isPositiveNumber(transactionBody.getValor())) {
			throw new BadRequestException("Transaction value must be a positive number");
		}
		
		float withdrawValue = transactionBody.getValor() * -1;
		transactionBody.setValor(withdrawValue);
		
		Date currentDate = Utils.getCurrentDate();
		transactionBody.setDataTransacao(currentDate);
		Transaction transaction = transactionRepository.insertTransactionOnPostgreSQL(transactionBody);
		
		float accountSaldo = userAccount.getSaldo() + transaction.getValor();
		userAccount.setSaldo(accountSaldo);
		accountRepository.updateAccountOnPostgreSQL(userAccount);
		
		return userAccount;
	}
}
