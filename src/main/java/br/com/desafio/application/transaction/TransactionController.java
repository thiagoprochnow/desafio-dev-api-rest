package br.com.desafio.application.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.domain.account.entity.Account;
import br.com.desafio.domain.account.event.AccountService;
import br.com.desafio.domain.transaction.entity.Transaction;
import br.com.desafio.domain.transaction.event.TransactionService;

@RestController
@RequestMapping(value = "/v1/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "/makeDeposit", method = RequestMethod.POST)
	public ResponseEntity<Account> makeDepositEndpoint(@RequestBody Transaction transactionBody) throws Exception {
		Account account = transactionService.makeDeposit(transactionBody);
		return ResponseEntity.ok(account);
	}
	
	@RequestMapping(value = "/makeWithdraw", method = RequestMethod.POST)
	public ResponseEntity<Account> makeWithdrawEndpoint(@RequestBody Transaction transactionBody) throws Exception {
		Account account = transactionService.makeWithdraw(transactionBody);
		return ResponseEntity.ok(account);
	}
}
