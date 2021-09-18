package br.com.desafio.domain.account.event;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.desafio.application.common.Utils;
import br.com.desafio.domain.account.entity.Account;
import br.com.desafio.domain.account.repository.AccountRepository;

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
	public Account getAccount(Account accountBody) throws Exception {
		return accountRepository.findById(accountBody.getIdConta());
	}
}
