package br.com.desafio.domain.account.event;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.desafio.application.common.Utils;
import br.com.desafio.domain.account.entity.Account;
import br.com.desafio.domain.account.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public Account createAccount(Account accountBody) throws Exception {
		Date currentDate = Utils.getCurrentDate();
		accountBody.setDataCriacao(currentDate);
		return accountRepository.insertAccountOnPostgreSQL(accountBody);
	}
}
