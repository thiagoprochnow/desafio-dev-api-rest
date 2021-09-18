package br.com.desafio.application.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.domain.account.entity.Account;
import br.com.desafio.domain.account.event.AccountService;
import br.com.desafio.domain.transaction.entity.Transaction;

@RestController
@RequestMapping(value = "/v1/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public ResponseEntity<Account> createAccountEndpoint(@RequestBody Account accountBody) throws Exception {
		Account createdAccount = accountService.createAccount(accountBody);
		return ResponseEntity.ok(createdAccount);
	}
	
	@RequestMapping(value = "/getAccount", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccountEndpoint(@RequestParam long idConta) throws Exception {
		Account account = accountService.getAccount(idConta);
		return ResponseEntity.ok(account);
	}
	
	@RequestMapping(value = "/blockAccount", method = RequestMethod.POST)
	public ResponseEntity<Account> blockAccountEndpoint(@RequestBody Account accountBody) throws Exception {
		Account account = accountService.blockAccount(accountBody);
		return ResponseEntity.ok(account);
	}
	
	@RequestMapping(value = "/getTransactions", method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getTransactionsEndpoint(@RequestParam long idConta) throws Exception {
		List<Transaction> transactions = accountService.getTransactions(idConta);
		return ResponseEntity.ok(transactions);
	}
}
