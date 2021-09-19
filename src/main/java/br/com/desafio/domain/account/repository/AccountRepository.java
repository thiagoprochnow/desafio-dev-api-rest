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
public interface AccountRepository {
	
	public Account insertAccountOnPostgreSQL(Account accountBody) throws Exception;
	
	public Account findById(long accountId) throws Exception;
	
	public Account updateAccountOnPostgreSQL(Account account) throws Exception;
}
