package br.com.desafio.domain.account.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.desafio.domain.account.entity.Account;
import br.com.desafio.domain.exception.NotFoundException;
import br.com.desafio.infra.account.AccountInfraPostgreSQL;

/**
 * 
 * @author Thiago Henrique Prochnow (thiprochnow@gmail.com)
 *
 * Account Repository for CRUD in database
 */

@Repository
public class DbAccountRepository implements AccountRepository {

	@Autowired
	AccountInfraPostgreSQL accountInfraPostgreSQL;
	
	public Account insertAccountOnPostgreSQL(Account accountBody) throws Exception {
		Account account = accountInfraPostgreSQL.save(accountBody);
		return account;
	}
	
	public Account findById(long accountId) throws Exception {
		Optional<Account> account = accountInfraPostgreSQL.findById(accountId);
		if(account.isEmpty()) {
			throw new NotFoundException("Account not found");
		}
		return account.get();
	}
	
	public Account updateAccountOnPostgreSQL(Account account) throws Exception {
		Account updatedAccount = accountInfraPostgreSQL.save(account);
		return updatedAccount;
	}
}
