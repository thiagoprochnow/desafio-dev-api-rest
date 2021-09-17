package br.com.desafio.domain.account.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.desafio.domain.account.entity.Account;
import br.com.desafio.infra.account.AccountInfraPostgreSQL;

@Repository
public class AccountRepository {

	@Autowired
	AccountInfraPostgreSQL accountInfraPostgreSQL;
	
	public Account insertAccountOnPostgreSQL(Account accountBody) throws Exception {
		Account account = accountInfraPostgreSQL.save(accountBody);
		return account;
	}
}
